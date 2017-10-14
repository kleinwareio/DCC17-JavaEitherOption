package example;

public class GenericsExample<T> {

    public T myValue;

    public static GenericsExample<String> makeExample() {
        GenericsExample<String> example = new GenericsExample<String>();
        example.myValue = "My Value";
        return example;
    }
}
