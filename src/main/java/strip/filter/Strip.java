package strip.filter;

import strip.state.LineState;

public interface Strip {
  String LINE = "//";
  String BLOCK_OP = "/*";
  String BLOCK_CL = "*/";
  LineState process(LineState ls);
}
