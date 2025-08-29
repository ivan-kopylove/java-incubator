package named.nestedClass;

class Step2_1_InnerNestedWithField {

    private static int a = 3;
    private int b = 3;

    static void foo1()
    {

    }

    void foo2()
    {

    }

    class Nested {
        private void bar() {
            foo1();
            foo2();
            a = 4; // can I access it here?
            b = 4; // can I access it here?
        }
    }
}


