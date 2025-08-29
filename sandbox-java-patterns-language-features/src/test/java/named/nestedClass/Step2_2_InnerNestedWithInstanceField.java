package named.nestedClass;

class Step2_2_InnerNestedWithInstanceField {

    private int someField = 3;

    class Nested {
        private void run() {
//            someField = 4; // can I access it here?
        }
    }
}


