package com.vellechokre.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

    public static final String DATE_FORMAT = "dd-MM-yyyy";

    private static final String DATE_FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final SimpleDateFormat FORMATTER =
            new SimpleDateFormat(DATE_FORMAT_UTC, Locale.US);

    public static final SimpleDateFormat REQUIRED_FORMATTER =
            new SimpleDateFormat(DATE_FORMAT, Locale.US);

    @Override
    public void serialize(Date value, JsonGenerator gen,
                          SerializerProvider arg2) throws IOException, JsonProcessingException {

        FORMATTER.setTimeZone(TimeZone.getTimeZone("UTC"));
        gen.writeString(REQUIRED_FORMATTER.format(value));
    }
}
