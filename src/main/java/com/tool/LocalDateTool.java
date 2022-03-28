package com.tool;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

@Service
public class LocalDateTool {

    private final DateTimeFormatter ymd = DateTimeFormat.forPattern("yyyy-MM-dd");

    public LocalDate getObjByString(String string) {
        return ymd.parseLocalDate(string);
    }

}
