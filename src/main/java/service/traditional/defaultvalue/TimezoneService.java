package service.traditional.defaultvalue;

import service.traditional.ITimezoneService;
import service.traditional.IUserRepository;
import service.traditional.User;

import java.util.TimeZone;

public class TimezoneService implements ITimezoneService {

    IUserRepository userRepository;

    public TimezoneService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TimeZone getTimezone(int userId) {
        User user = userRepository.getUser(userId);

        if (user != null)
            if (user.preferences != null)
                if (user.preferences.timeZone != null)
                    return user.preferences.timeZone;

        return TimeZone.getDefault();
    }
}
