package strip.filter;

import strip.state.LineState;

public class CommentsStripEmptyOnly implements Strip {
  @Override
  public LineState process(LineState ls) {
    ls.output.append(ls.input);
    return ls.finish();
  }
}
