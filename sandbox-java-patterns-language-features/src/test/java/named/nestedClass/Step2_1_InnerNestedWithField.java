package named.nestedClass;

class Step2_1_InnerNestedWithField {

    private static int someField = 3;

    class Nested {
        private void run() {
//            someField = 4; // can I access it here?
        }
    }
}


