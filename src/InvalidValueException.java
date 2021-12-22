public class InvalidValueException extends Exception {
    public InvalidValueException() {
        System.out.println("String must contain only valid roman numerals\n" +
                "[I, V, X, L, C, D, M]");
    }
}
