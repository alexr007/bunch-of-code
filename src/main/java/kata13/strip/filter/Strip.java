package kata13.strip.filter;

import kata13.strip.state.LineState;

public interface Strip {
  String LINE = "//";
  String BLOCK_OP = "/*";
  String BLOCK_CL = "*/";
  LineState process(LineState ls);
}
