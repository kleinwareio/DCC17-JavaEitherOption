package service.traditional.exception;

import service.traditional.ITimezoneService;

import java.util.TimeZone;

public class Client {

    final ITimezoneService timezoneService;
    final TimeZone headquarterTimeZone;
    final TimeZone regionTimeZone;

    public Client(ITimezoneService timezoneService, TimeZone headquartersTimeZone, TimeZone regionTimeZone) {
        this.timezoneService = timezoneService;
        this.headquarterTimeZone = headquartersTimeZone;
        this.regionTimeZone = regionTimeZone;
    }

    public void doWork(int userId) {
        TimeZone timeZone;
        try {
            timeZone = timezoneService.getTimezone(userId);
        } catch (UserNotFoundException userNotFoundEx) {
            timeZone = headquarterTimeZone;
        } catch (NoTimezoneSetException noTimeZoneSetEx) {
            timeZone = regionTimeZone;
        }

        // do work with timeZone;
    }
}
