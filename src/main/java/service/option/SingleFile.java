package service.option;

import fj.data.Option;

import java.util.TimeZone;

public class SingleFile {
    service.option.IUserRepository userRepository;

    public interface IUserRepository {
        Option<User> getUser(int id);
    }

    public class User {
        public Preferences preferences;
    }

    public class Preferences {
        public Option<TimeZone> timeZone;
    }

    public Option<TimeZone> getTimezone(int userId) {
        return userRepository
            .getUser(userId)
            .map(user -> user.preferences)
            .bind(preferences -> preferences.timeZone);
    }
}
