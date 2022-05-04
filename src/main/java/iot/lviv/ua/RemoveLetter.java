package iot.lviv.ua;

import java.util.Locale;
import java.util.regex.Pattern;

public class RemoveLetter {
    public String removeLetter(String str, String letter, int length) {
        if(length > str.length() || length < 0) {
            length = str.length();
        }

        String end = str.substring(length);
        String beginning = str.substring(0, length);

        String pat = "[" + letter.toLowerCase() + letter.toUpperCase(Locale.ROOT) + "]";
        Pattern pattern = Pattern.compile(pat);

        str = pattern.matcher(beginning).replaceAll("").concat(end);
        System.out.println(str);
        return str;
    }

}