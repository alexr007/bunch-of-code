package kata13.strip.filter;

import kata13.strip.state.LineState;

/**
 * StripNothing Implementation
 * just keeps original text
 */
public class Strip0Nothing implements Strip {
  @Override
  public LineState process(LineState ls) {
    ls.output.append(ls.input);
    return ls.finish();
  }
}
