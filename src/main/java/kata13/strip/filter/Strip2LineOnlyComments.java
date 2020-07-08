package kata13.strip.filter;

import kata13.strip.state.LineState;

import java.util.Optional;

/**
 * StripLineOnlyComments Implementation
 * based on StripBlankLines (Blank Lines isn't counted)
 * and removes Line comments
 */
public class Strip2LineOnlyComments extends Strip1BlankLines {
  @Override
  public LineState process(LineState ls) {
    String stripped = Optional.of(ls.input.indexOf(LINE, ls.pos))
        .filter(idx -> idx >= 0)
        .map(idx -> ls.input.substring(ls.pos, idx))
        .orElse(ls.input);
    ls.output.append(stripped);
    return ls.finish();
  }
}
