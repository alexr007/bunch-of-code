package kata13.strip.filter;

import kata13.strip.state.LineState;

public class CommentsStripEmptyAndLine implements Strip {
  @Override
  public LineState process(LineState ls) {
    int comm_pos = ls.input.indexOf(LINE, ls.pos);
    if (comm_pos>0) {
      String beforeComment = ls.input.substring(ls.pos, comm_pos);
      ls.output.append(beforeComment);
    } else {
      ls.output.append(ls.input);
    }
    return ls.finish();
  }
}
