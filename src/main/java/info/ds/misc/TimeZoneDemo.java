package info.ds.misc;

import sun.util.resources.TimeZoneNames;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneDemo {

    public static void main(String[] args) {
        System.out.println(ZoneId.of("UTC"));
    }
}
