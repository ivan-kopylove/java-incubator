package named.nestedClass;

public class Step3_1_StaticNestedWithField {

    private static int a = 1;
    private int b = 1;

    static class Nested {
        private void run() {
//            a = 2; // can I access it here?
//            b = 2; // can I access it here?
        }
    }
}
