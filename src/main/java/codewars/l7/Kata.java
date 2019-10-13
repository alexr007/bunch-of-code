package codewars.l7;

import static org.junit.Assert.assertEquals;

public class Kata {

  public static String encryptOnce(final String text) {
    StringBuilder p1 = new StringBuilder();
    StringBuilder p2 = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      if (i%2 == 0) {
        p2.append(text.charAt(i));
      } else {
        p1.append(text.charAt(i));
      }
    }
    return p1.append(p2).toString();
  }

  public static String decryptOnce(final String text) {
    String s1 = text.substring(0,text.length()/2);
    String s2 = text.substring(text.length()/2);
    StringBuilder r = new StringBuilder();
    int p1 = 0; int l1 = s1.length();
    int p2 = 0; int l2 = s2.length();
    while (p1<l1 && p2<l2) {
      r.append(s2.charAt(p2++))
      .append(s1.charAt(p1++));
    }
    while (p2<l2) {
      r.append(s2.charAt(p2++));
    }
    while (p1<l1) {
      r.append(s1.charAt(p1++));
    }
    return r.toString();
  }

  public static String encrypt(final String text, final int n) {
    if (n<=0) return text;
    if (text == null || text.isEmpty()) return text;
    String s = text;
    for (int i = 0; i < n; i++) {
      s = encryptOnce(s);
    }
    return s;
  }

  public static String decrypt(final String encryptedText, final int n) {
    if (n<=0) return encryptedText;
    if (encryptedText == null || encryptedText.isEmpty()) return encryptedText;
    String s = encryptedText;
    for (int i = 0; i < n; i++) {
      s = decryptOnce(s);
    }
    return s;
  }

  public static void main1(String[] args) {
    assertEquals(
        "This kata is very interesting!",
        Kata.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
  }

  public static void main(String[] args) {
    assertEquals("This is a test!", Kata.encrypt("This is a test!", 0));
    assertEquals("hsi  etTi sats!", Kata.encrypt("This is a test!", 1));
    assertEquals("s eT ashi tist!", Kata.encrypt("This is a test!", 2));
    assertEquals(" Tah itse sits!", Kata.encrypt("This is a test!", 3));
    assertEquals("This is a test!", Kata.encrypt("This is a test!", 4));
    assertEquals("This is a test!", Kata.encrypt("This is a test!", -1));
    assertEquals("hskt svr neetn!Ti aai eyitrsig", Kata.encrypt("This kata is very interesting!", 1));
    assertEquals("This is a test!", Kata.decrypt("This is a test!", 0));
      assertEquals("This is a test!", Kata.decrypt("hsi  etTi sats!", 1));
    assertEquals("This is a test!", Kata.decrypt("s eT ashi tist!", 2));
    assertEquals("This is a test!", Kata.decrypt(" Tah itse sits!", 3));
    assertEquals("This is a test!", Kata.decrypt("This is a test!", 4));
    assertEquals("This is a test!", Kata.decrypt("This is a test!", -1));
    assertEquals("This kata is very interesting!", Kata.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    assertEquals("", Kata.encrypt("", 0));
    assertEquals("", Kata.decrypt("", 0));
    assertEquals(null, Kata.encrypt(null, 0));
    assertEquals(null, Kata.decrypt(null, 0));
  }
}
