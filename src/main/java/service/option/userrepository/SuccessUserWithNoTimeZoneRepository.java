package service.option.userrepository;

import fj.data.Option;
import service.option.IUserRepository;
import service.option.Preferences;
import service.option.User;

public class SuccessUserWithNoTimeZoneRepository implements IUserRepository {
    @Override
    public Option<User> getUser(int id) {
        return Option.some(new User(new Preferences(Option.none())));
    }
}
