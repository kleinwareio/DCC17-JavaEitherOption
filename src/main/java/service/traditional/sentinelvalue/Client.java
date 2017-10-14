package service.traditional.sentinelvalue;


import service.traditional.ITimezoneService;

import java.util.TimeZone;

public class Client {

    final ITimezoneService timezoneService;
    final TimeZone defaultTimezone;

    public Client(ITimezoneService timezoneService, TimeZone defaultTimezone) {
        this.timezoneService = timezoneService;
        this.defaultTimezone = defaultTimezone;
    }

    public void doWork(int userId) {
        TimeZone timeZone = timezoneService.getTimezone(userId);
        if (timeZone == null)
            timeZone = defaultTimezone;

        // do work with timeZone;
    }
}
