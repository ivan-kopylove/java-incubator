package named.nestedClass;

class Step2_1_InnerNestedWithField {

    private static int a = 3;
    private int b = 3;

    class Nested {
        private void run() {
            a = 4; // can I access it here?
            b = 4; // can I access it here?
        }
    }
}


