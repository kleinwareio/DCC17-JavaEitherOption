package service.option;

import java.util.TimeZone;

public class Client {

    final TimezoneService timezoneService;
    final TimeZone defaultTimezone;

    public Client(TimezoneService timezoneService, TimeZone defaultTimezone) {
        this.timezoneService = timezoneService;
        this.defaultTimezone = defaultTimezone;
    }

    public void doWork(int userId) {
        TimeZone timezone = timezoneService.getTimezone(userId).orSome(defaultTimezone);
    }
}
