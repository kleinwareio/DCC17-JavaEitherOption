package service.option.userrepository;

import fj.data.Option;
import service.option.IUserRepository;
import service.option.User;

public class FailureUserRepository implements IUserRepository {
    @Override
    public Option<User> getUser(int id) {
        return Option.none();
    }
}
