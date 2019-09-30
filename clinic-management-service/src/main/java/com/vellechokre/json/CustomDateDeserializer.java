package com.vellechokre.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class CustomDateDeserializer extends JsonDeserializer<Date> {

    public static final String DATE_FORMAT = "dd-MM-yyyy";

    private static final String DATE_FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    @Override
    public Date deserialize(JsonParser jsonParser,
                            DeserializationContext arg1) throws IOException,
                                                         JsonProcessingException {

        SimpleDateFormat formatter;
        String dateAsString = jsonParser.getText();
        Date date = null;
        try {
            if (null == dateAsString) {
                return date;
            } else if (dateAsString.length() == DATE_FORMAT.length()) {
                formatter = new SimpleDateFormat(DATE_FORMAT);
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            } else {
                formatter = new SimpleDateFormat(DATE_FORMAT_UTC);
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            }
            date = formatter.parse(dateAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
