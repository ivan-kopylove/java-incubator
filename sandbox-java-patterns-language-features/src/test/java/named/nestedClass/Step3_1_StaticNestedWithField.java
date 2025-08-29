package named.nestedClass;

class Step3_1_StaticNestedWithField {

    private static int a = 1;
    private int b = 1;

    static void foo()
    {

    }

    static class Nested {
        private void bar() {
//            a = 2; // can I access it here?
//            b = 2; // can I access it here?
        }
    }
}
