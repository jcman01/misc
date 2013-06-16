package misc;

// retrieve the last element of an array of any type

public class GetLastArrayElement {
    private <T> T last(T[] array) {
        return array[array.length - 1];
    }
}