package test.intetics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromTest {
    @Test
    public void isPalindrom1() throws Exception {
        assertEquals(new Palindrome(1,1).is(), true);
    }
    @Test
    public void isPalindrom3() throws Exception {
        assertEquals(new Palindrome(1,11).is(), true);
    }
    @Test
    public void isPalindrom4() throws Exception {
        assertEquals(new Palindrome(1,121).is(), true);
    }
    @Test
    public void isPalindrom5() throws Exception {
        assertEquals(new Palindrome(1,1221).is(), true);
    }
    @Test
    public void isPalindrom6() throws Exception {
        assertEquals(new Palindrome(1,12321).is(), true);
    }
    @Test
    public void isPalindrom1F() throws Exception {
        assertEquals(new Palindrome(1,12).is(), false);
    }
    @Test
    public void isPalindrom2F() throws Exception {
        assertEquals(new Palindrome(1,123).is(), false);
    }

}