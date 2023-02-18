package se616;

public class StringExample {

    public boolean matchName(String name) {

        String myName = "SomeName";
        if(myName.equalsIgnoreCase(name)) {
            return true;
        }else {
            return false;
        }
    }
}
