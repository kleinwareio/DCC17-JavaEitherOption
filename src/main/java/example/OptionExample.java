package example;

import fj.data.Option;

public class OptionExample {

    public void creationAndMap() {
        // I have no value
        Option<String> maybeString1 = Option.none();
        // I do have a value
        Option<String> maybeString2 = Option.some("I have a value");

        // Still has no value, logic is ignored
        Option<Integer> maybeLength1 = maybeString1.map(str -> str.length());
        // Has value of 14
        Option<Integer> maybeLength2 = maybeString2.map(str -> str.length());

        // Has value of 0
        int length1 = maybeLength1.orSome(0);
        // Has value of 14
        int length2 = maybeLength2.orSome(0);
    }

    public void chainingMap() {
        Option<Integer> value1 = Option.none();
        Option<Integer> value2 = Option.some(42);

        int result1 = value1.map(i -> Integer.toString(i)) // No value
                            .map(s -> s.length())          // still no value, logic not executed
                            .orSome(-1);                  // returns -1

        int result2 = value2.map(i -> Integer.toString(i))   // 42 -> "42"
                            .map(s -> s.length())            // "42" -> 2
                            .orSome(-1);                  // return 2 since it has a value
    }

    public void chainingMapWhenReturningOption() {
        Option<Integer> intOption = Option.some(99);

        // `map` wraps an Option<Double> in another Option... very ugly =(
        Option<Option<Double>> ugly = intOption.map(value -> squareRoot(value));

        // use `bind` to prevent the double-wrapping. Also known as `flatMap`.
        Option<Double> maybeSquareRoot = intOption.bind(value -> squareRoot(value));

        // can chain bind and map together
        String result = intOption.bind(value -> squareRoot(value))
                                 .map(sqrt -> Double.toString(sqrt))
                                 .orSome("Negative Value");
    }

    private Option<Double> squareRoot(int value) {
        if (value < 0)
            return Option.none();
        else
            return Option.some(Math.sqrt(value));
    }
}
