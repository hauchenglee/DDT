//package com.sample.ddt.config;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//import lombok.SneakyThrows;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Locale;
//import java.util.stream.Collectors;
//
///**
// * https://stackoverflow.com/a/42567051/11152683
// * https://stackoverflow.com/questions/24912992/configure-jackson-to-parse-multiple-date-formats
// * http://www.javabyexamples.com/how-to-format-date-for-serialization-with-jackson
// */
//public class MultiDateStdDeserializer extends StdDeserializer<Date> {
//    private static final long serialVersionUID = 1L;
//
//    private final SimpleDateFormat[] DATE_FORMATTERS = new SimpleDateFormat[]{
//            new SimpleDateFormat("yyyyMMdd"),
//            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.US),
//            new SimpleDateFormat("yyyy-MM-dd HH:mm' UTC'", Locale.US),
//            new SimpleDateFormat("MMM dd, yyyy HH:mm:ss 'UTC'", Locale.US),
//            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'", Locale.US),
//            new SimpleDateFormat("MMM dd, yyyy 'at' HH:mm 'GMT'", Locale.US),
//    };
//
//    public MultiDateStdDeserializer() {
//        this(null);
//    }
//
//    public MultiDateStdDeserializer(Class<?> vc) {
//        super(vc);
//        System.out.println("ddd");
//    }
//
//    @SneakyThrows
//    @Override
//    public Date deserialize(JsonParser jp, DeserializationContext ctxt) {
////        JsonNode node = jp.getCodec().readTree(jp);
////        final String date = node.textValue();
//        String date = jp.getText();
//
//        for (SimpleDateFormat formatter : DATE_FORMATTERS) {
//            try {
//                return formatter.parse(date); //.toInstant();
//            } catch (ParseException ignored) {
//            }
//        }
//
//        throw new JsonParseException(jp, "Unparseable date: \"" + date + "\". Supported formats: " +
//                Arrays.stream(DATE_FORMATTERS).map(SimpleDateFormat::toPattern).collect(Collectors.joining("; ")));
//    }
//}
