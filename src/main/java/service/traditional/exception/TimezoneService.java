package service.traditional.exception;

import service.traditional.IUserRepository;
import service.traditional.User;

import java.util.TimeZone;

public class TimezoneService {

    IUserRepository userRepository;

    public TimezoneService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TimeZone getTimezone(int userId) {
        User user = userRepository.getUser(userId);
        if (user == null)
            throw new UserNotFoundException();

        if (user.preferences.timeZone == null)
            throw new NoTimezoneSetException();

        return user.preferences.timeZone;
    }
}
