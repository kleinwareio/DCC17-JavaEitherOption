package example;

import fj.data.Either;
import fj.data.Option;

public class EitherExample {

    public void example() {
        // an Either in the "right" state with a value of "Success!"
        Either<Exception, String> result1 = Either.right("Success!");

        // an Either in the "left" state that is holding an exception object
        Either<Exception, String> result2 = Either.left(new Exception("poof"));

        // this Either is in the Right state with a value of 8
        Either<Exception, Integer> resultLength1 = result1.right().map(str -> str.length());
        // this Either is in the Left state with the same exception object as above
        Either<Exception, Integer> resultLength2 = result1.right().map(str -> str.length());

        // this Either is in the "right" state, so the length as a string is returned
        String finalValue1 = resultLength1.either(ex -> ex.getMessage(), len -> len.toString());
        // this Either is in the "left" state, so the exception message is returned
        String finalValue2 = resultLength2.either(ex -> ex.getMessage(), len -> len.toString());
    }

    private enum Error {
        UserNotFound,
        AgeNotSet
    }

    private static class User {
        Option<Integer> getAge() {
            return Option.some(42);
        }
    }

    public String getAge(int userId) {
        return getUser(userId)
            .right().bind(user -> getAge(user))
            .right().map(age -> age.toString())
            .either(error -> error.name(), age -> age);
    }

    private Either<Error, User> getUser(int userId) {
        if (userId < 100)
            return Either.left(Error.UserNotFound);
        else
            return Either.right(new User());
    }

    private Either<Error, Integer> getAge(User user) {
        return user.getAge()
                   .map(age -> Either.<Error, Integer>right(age))
                   .orSome(Either.left(Error.AgeNotSet));
    }

}
