package iot.lviv.ua;

public class Main {
    public static void main(String[] args) {
        RemoveLetter removeLetter = new RemoveLetter();
        String text = "ABb matcher may be reset explicitly by invoking its " +
                "reset() method or, if a new input sequence is desired, its " +
                "reset(CharSequence) method. Resetting a matcher discards its " +
                "explicit state information and sets the append position to zero.";
        String str = removeLetter.removeLetter(text, "b", -1);
        System.out.println(str);
    }
}
