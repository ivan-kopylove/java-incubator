package named.nestedClass;

class Step3_1_StaticNestedWithField {

    private static int a = 1;
    private int b = 1;

    static void foo1()
    {

    }

    void foo2()
    {

    }

    static class Nested {
        private void bar() {
//            foo1();// can I access it here?
//            foo2();// can I access it here?
//            foo(); // can I access it here?
//            a = 2; // can I access it here?
//            b = 2; // can I access it here?
        }
    }
}
