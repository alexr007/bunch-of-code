package logistics;

import logistics.extract.Match;
import logistics.extract.Pt;
import logistics.extract.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Tracking {

  static class Ex {
    public final Function<String, Optional<String>> extractor;
    public final Function<String, Company> create_company;

    public Ex(Function<String, Optional<String>> extractor, Function<String, Company> create_company) {
      this.extractor = extractor;
      this.create_company = create_company;
    }

    public static Ex of(Function<String, Optional<String>> extractor, Function<String, Company> create) {
      return new Ex(extractor, create);
    }
  }

  private final static List<Ex> parsers = new ArrayList<Ex>(7) {{
    add(Ex.of(s -> Match.many(s, Pt.TR_UPS),    Company::UPS));
    add(Ex.of(s -> Match.many(s, Pt.TR_FEDEX),  Company::FedEx));
    add(Ex.of(s -> Match.many(s, Pt.TR_USPS),   Company::USPS));
    add(Ex.of(s -> Match.many(s, Pt.TR_DHL),    Company::DHL));
    add(Ex.of(s -> Match.many(s, Pt.TR_AMAZON), Company::Amazon));
    add(Ex.of(s -> Match.many(s, Pt.TR_AMT),    Company::AMT));
    add(Ex.of(s -> Match.many(s, Pt.TR_CHINA),  Company::Noname));
  }};

  /**
   * it parses given String to Company
   * if no company found - return Company.Unknown
   */
  public static Company parse(String origin_) {
    return Match.one(origin_, Pt.ANY_TRACK)
        .flatMap(origin -> parsers.stream()
            .map(parser -> parser.extractor.apply(origin).map(parser.create_company))
            .flatMap(c -> c.map(Stream::of).orElseGet(Stream::empty))
            .findFirst())
        .orElseGet(() -> Company.Unknown(origin_));
  }

}
