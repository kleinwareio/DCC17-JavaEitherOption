package service.traditional.defaultvalue;


import service.traditional.ITimezoneService;

import java.util.TimeZone;

public class Client {

    final ITimezoneService timezoneService;

    public Client(ITimezoneService timezoneService) {
        this.timezoneService = timezoneService;
    }

    public void doWork(int userId) {
        TimeZone timeZone = timezoneService.getTimezone(userId);

        // do work with timeZone;
    }
}
