package service.option;

import fj.data.Option;

import java.util.TimeZone;

public class TimezoneService {

    IUserRepository userRepository;

    public TimezoneService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Option<TimeZone> getTimezone(int userId) {
        return userRepository
                .getUser(userId)
                .map(user -> user.preferences)
                .bind(preferences -> preferences.timeZone);
    }
}
