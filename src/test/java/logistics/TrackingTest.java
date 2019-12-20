package logistics;

import logistics.extract.Company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackingTest {

  @Test
  void parse_1() {
    String number = "1Z0070860390801616";
    assertEquals(Company.UPS(number), Tracking.parse(number));
  }

  @Test
  void parse_2() {
    String number = "196781615395861";
    assertEquals(Company.FedEx(number), Tracking.parse(number));
  }

  @Test
  void parse_3() {
    String number = "9400110200828210802107";
    assertEquals(Company.USPS(number), Tracking.parse(number));
  }

  @Test
  void parse_4() {
    String number = "a682334";
    assertEquals(Company.AMT(number), Tracking.parse(number));
  }

  @Test
  void parse_5() {
    String number = "TBA177083507000";
    assertEquals(Company.Amazon(number), Tracking.parse(number));
  }

  @Test
  void parse_6() {
    String number = "QQ123456789123WW";
    assertEquals(Company.Noname(number), Tracking.parse(number));
  }

  @Test
  void parse_7() {
    String number = "1234567890";
    assertEquals(Company.DHL(number), Tracking.parse(number));
  }

  @Test
  void parse_8() {
    String number = "123-456789012345678905657";
    assertEquals(Company.Unknown(number), Tracking.parse(number));
  }

}
