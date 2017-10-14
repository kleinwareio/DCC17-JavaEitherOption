package service.option;

import fj.data.Option;

import java.util.TimeZone;

public class Preferences {
    Option<TimeZone> timeZone;

    public Preferences(Option<TimeZone> timeZone) {
        this.timeZone = timeZone;
    }
}
