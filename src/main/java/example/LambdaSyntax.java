package example;

import java.util.function.Function;

public class LambdaSyntax {

    private void doWorkWithFunction(Function<String, Integer> lambdaWork) {
        // performs work using provided function
    }

    private void syntax() {
        // call method "doWorkWithFunction" and pass in function to use
        doWorkWithFunction(str -> str.length());
    }

    private Integer getLength(String str) {
        return str.length();
    }
}
