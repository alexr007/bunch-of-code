package logistics;

import logistics.extract.Match;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EbayTestExtract {

  @Test
  void extract_id_1() {
    assertEquals(Optional.of("352624904606"),
        Match.extractEbayItem("352624904606"));
  }

  @Test
  void extract_id_2() {
    assertEquals(Optional.empty(),
        Match.extractEbayItem("{3454352624904606' dvsdvsftsf"));
  }

  @Test
  void extract_id_3() {
    assertEquals(Optional.of("352624904606"),
        Match.extractEbayItem(" fdffd 352624904606 dvsdvsftsf"));
  }

  @Test
  void extract_id_4() {
    assertEquals(Optional.of("352624904606"),
        Match.extractEbayItem(" fdffd ,352624904606. dvsdvsftsf"));
  }

  @Test
  void extract_id_5() {
    assertEquals(Optional.of("352624904606"),
        Match.extractEbayItem(" fdffd >352624904606< dvsdvsftsf"));
  }

  @Test
  void extract_id_6() {
    assertEquals(Optional.of("293323425371"),
        Match.extractEbayItem("eBay item number:293323425371\nSeller assumes all responsibility for this listing."));
  }

}
