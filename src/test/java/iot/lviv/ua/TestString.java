package iot.lviv.ua;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestString {
    private final RemoveLetter removeLetter = new RemoveLetter();
    @Test
    public void testOneLatter(){
        assertEquals("", removeLetter.removeLetter("aaaaaaaaaaaa", "a", -1));
        assertEquals("", removeLetter.removeLetter("AAAAAAAAAAAAAaaaaaa", "a", -1));
        assertEquals("bbbbbbBBBBBBBBBBBbbbbb", removeLetter.removeLetter("bbbbbbBBBBBBBBBBBbbbbb", "a", -1));
    }

    @Test
    public void testEmptyString() {
        assertEquals("" , removeLetter.removeLetter("", "a", -1));
        assertEquals("" , removeLetter.removeLetter("", "b", 0));
        assertEquals("" , removeLetter.removeLetter("", "c", 100));
    }

    @Test
    public void testBigText() {
        assertEquals("Ech of these methods returns  boolen indicting success or filure." +
                        " More informtion bout  successful mtch cn be obtined by querying the " +
                        "stte of the mtcher. mtcher finds mtches in  subset of its input clled " +
                        "the region. By defult, the region contins ll of the mtcher's input. The " +
                        "region cn be modified vi theregion method nd queried vi the regionStrt" +
                        " nd regionEnd methods. The wy tht the region boundries interct with some" +
                        " pttern constructs cn be chnged. See usenchoringBounds nd useTrnsprentBounds" +
                        " for more detils.",
                removeLetter.removeLetter("Each of these methods returns a boolean indicating success" +
                        " or failure. More information about a successful match can be obtained by querying the state of the matcher." +
                        "A matcher finds matches in a subset of its input called the region. By default, the region" +
                        " contains all of the matcher's input. The region can be modified via theregion method and" +
                        " queried via the regionStart and regionEnd methods. The way that the region boundaries interact" +
                        " with some pattern constructs can be changed. See useAnchoringBounds and useTransparentBounds for more details.", "a", -1));
    }

    @Test
    public void testLength(){
        assertEquals("12345a", removeLetter.removeLetter("12345a", "a", 5));
        assertEquals("12345", removeLetter.removeLetter("12345a", "A", 6));
        assertEquals("1a2345a", removeLetter.removeLetter("1a2345a", "a", 1));
        assertEquals("a", removeLetter.removeLetter("a", "a", 0));
    }

    @Test
    public void testWithPunctuation() {
        assertEquals(",./,/.,/.?//?/!!%^***(){{{}]}}}&&;;;:::'''./.",
                removeLetter.removeLetter(",./,aa/.AaA,/AaA.?/a/AAAA?aaaa/!a!%^AaAAa***AAaa(a){{{aaAAAA}]}}}AAA&&;;AA;:AA:AA:'''./.", "a", -1  ));
    }
}
