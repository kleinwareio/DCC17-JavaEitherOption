package service.option;

import fj.data.Option;

public interface IUserRepository {
    Option<User> getUser(int id);
}
