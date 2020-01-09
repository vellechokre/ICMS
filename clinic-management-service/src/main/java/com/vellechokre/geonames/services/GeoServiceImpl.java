package com.vellechokre.geonames.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vellechokre.entity.master.City;
import com.vellechokre.entity.master.Country;
import com.vellechokre.entity.master.District;
import com.vellechokre.entity.master.State;
import com.vellechokre.geonames.bo.GeoChild;
import com.vellechokre.geonames.bo.GeoChildResponse;
import com.vellechokre.geonames.bo.GeoCountry;
import com.vellechokre.geonames.bo.GeoCountryResponse;
import com.vellechokre.repository.master.CityRepo;
import com.vellechokre.repository.master.CountryRepo;
import com.vellechokre.repository.master.DistrictRepo;
import com.vellechokre.repository.master.StateRepo;
import com.vellechokre.util.RestUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Dec 1, 2019
 */
@Service
public class GeoServiceImpl implements GeoService {

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private StateRepo stateRepo;

    @Autowired
    private DistrictRepo districtRepo;

    @Autowired
    private CityRepo cityRepo;

    private final static String COUNTRY_URL = "http://api.geonames.org/countryInfoJSON";

    private final static String CHILD_URL = "http://api.geonames.org/childrenJSON";

    @Override
    public void fetchCountry() {

        Map<String, String> params = getParam();
        Object response = RestUtil.get(COUNTRY_URL, new HashMap<>(), params);
        ObjectMapper mapper = new ObjectMapper();
        GeoCountryResponse countryResponse =
                mapper.convertValue(response, GeoCountryResponse.class);
        ArrayList<GeoCountry> geoCountries = countryResponse.getGeonames();
        List<Country> countries = new ArrayList<>();
        if (!CollectionUtils.isEmpty(geoCountries)) {
            geoCountries.forEach(item -> {
                Country country = new Country();
                country.setAreaInSqKm(new BigDecimal(item.getAreaInSqKm()));
                country.setCode(item.getCountryCode());
                country.setContinentName(item.getContinentName());
                country.setCurrencyCode(item.getCurrencyCode());
                country.setGeonameId(String.valueOf(item.getGeonameId()));
                country.setName(item.getCountryName());
                country.setPopulation(new BigDecimal(item.getPopulation()));
                countries.add(country);
            });
            countryRepo.saveAll(countries);
        }
    }

    /**
     * @return
     */
    private Map<String, String> getParam() {

        Map<String, String> params = new HashMap<>();
        params.put("username", "Bhardwaz23");
        return params;
    }

    @Override
    public void fetchStates() {

        // We will fetch State for India only (For India geonameId = 1269750)
        Country country = countryRepo.findById(105).get();// id=105 for India
        Map<String, String> params = getParam();
        params.put("geonameId", "1269750");
        Object response = RestUtil.get(CHILD_URL, new HashMap<>(), params);
        ObjectMapper mapper = new ObjectMapper();
        GeoChildResponse childResponse = mapper.convertValue(response, GeoChildResponse.class);
        ArrayList<GeoChild> getchildren = childResponse.getGeonames();
        List<State> states = new ArrayList<>();
        if (!CollectionUtils.isEmpty(getchildren)) {
            getchildren.forEach(item -> {
                State state = new State();
                state.setCode(item.getAdminCodes1().getISO3166_2());
                state.setCountry(country);
                state.setGeonameId(String.valueOf(item.getGeonameId()));
                state.setName(item.getName());
                state.setPopulation(new BigDecimal(item.getPopulation()));
                states.add(state);
            });
            stateRepo.saveAll(states);
        }
    }

    @Override
    public void fetchDistricts() {

        Country country = countryRepo.findById(105).get();// id=105 for India
        List<State> states = stateRepo.findAll();
        Map<String, String> params = getParam();
        ObjectMapper mapper = new ObjectMapper();
        states.forEach(state -> {
            // For Ladhakh we need to update the geonameId to 12096464.0 in database.
            params.put("geonameId",
                    state.getGeonameId().substring(0, state.getGeonameId().indexOf('.')));
            Object response = RestUtil.get(CHILD_URL, new HashMap<>(), params);
            GeoChildResponse childResponse = mapper.convertValue(response, GeoChildResponse.class);
            ArrayList<GeoChild> getchildren = childResponse.getGeonames();
            List<District> districts = new ArrayList<>();
            if (!CollectionUtils.isEmpty(getchildren)) {
                getchildren.forEach(item -> {
                    District district = new District();
                    district.setCode(item.getAdminCodes1().getISO3166_2());
                    district.setCountry(country);
                    district.setState(state);
                    district.setGeonameId(String.valueOf(item.getGeonameId()));
                    district.setName(item.getName());
                    district.setPopulation(new BigDecimal(item.getPopulation()));
                    districts.add(district);
                });
                districtRepo.saveAll(districts);
            }
        });
    }

    @Override
    public void fetchCities() {

        Country country = countryRepo.findById(105).get();// id=105 for India
        List<District> districts = districtRepo.findAll();
        Map<String, String> params = getParam();
        ObjectMapper mapper = new ObjectMapper();
        districts.forEach(district -> {
            // For Ladhakh we need to update the geonameId to 12096464.0 in database.
            params.put("geonameId",
                    district.getGeonameId().substring(0, district.getGeonameId().indexOf('.')));
            Object response = RestUtil.get(CHILD_URL, new HashMap<>(), params);
            GeoChildResponse childResponse = mapper.convertValue(response, GeoChildResponse.class);
            ArrayList<GeoChild> getchildren = childResponse.getGeonames();
            List<City> cities = new ArrayList<>();
            if (!CollectionUtils.isEmpty(getchildren)) {
                getchildren.forEach(item -> {
                    City city = new City();
                    city.setCode(item.getAdminCodes1().getISO3166_2());
                    city.setCountry(country);
                    city.setState(district.getState());
                    // city.setDistrict(district);
                    city.setGeonameId(String.valueOf(item.getGeonameId()));
                    city.setName(item.getName());
                    city.setPopulation(new BigDecimal(item.getPopulation()));
                    cities.add(city);
                });
                cityRepo.saveAll(cities);
            }
        });
    }
}
