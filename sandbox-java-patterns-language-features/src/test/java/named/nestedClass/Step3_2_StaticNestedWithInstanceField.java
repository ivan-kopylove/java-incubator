package named.nestedClass;

public class Step3_2_StaticNestedWithInstanceField {

    private int field = 1;

    static class Nested {
        private void run()
        {
//            field = 2; // can I do like this?
        }
    }
}
