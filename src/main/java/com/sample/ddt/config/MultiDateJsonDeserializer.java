package com.sample.ddt.config;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * <a href="https://stackoverflow.com/questions/41954561/jackson-deserialise-different-date-formats">...</a>
 */
public class MultiDateJsonDeserializer extends JsonDeserializer<Date> {

    private static final String[] DATE_FORMATTERS = new String[]{
            "yyyyMMdd",
            "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss Z",
            "yyyy-MM-dd HH:mm' UTC'",
            "yyyy-MM-dd'T'HH:mm:ss",
            "MMM dd, yyyy HH:mm:ss 'UTC'",
            "MMM dd, yyyy 'at' HH:mm 'GMT'",
    };

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser == null || "".equals(jsonParser.getText()))
            return null;
        String date = jsonParser.getText();

        for (String format : DATE_FORMATTERS) {
            try {
                return new SimpleDateFormat(format, Locale.ENGLISH).parse(date);
            } catch (ParseException ignored) {
            }
        }

        throw new JsonParseException(jsonParser, "Unable to parse date: [" + jsonParser.getValueAsString() + "]. Supported formats: " + Arrays.toString(DATE_FORMATTERS));
    }
}
