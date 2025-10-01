package com.manhnv.vimaserver.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String ConvertToYYYYMMDD(Instant instant) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd")
                .withZone(ZoneId.systemDefault());
        return fmt.format(instant);
    }
}
