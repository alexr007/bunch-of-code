package kata13.strip.filter;

import kata13.strip.state.LineState;

public class CommentsStripAll implements Strip {
  @Override
  /**
   * LineState:
   *  String input;
   *  int pos;
   *  StringBuilder output;
   *  boolean inBlock;
   */
  public LineState process(LineState ls) {
    /**
     *   if (ls.inBlock)  => look for BLOCK_CL and skip everything
     *      => if BLOCK_CL - cut before => next iteration with diff inBlock state
     *
     *   if (!ls.inBlock) => lok for BLOCK_OP | LINE, what's closer to start
     *     => if LINE => skip whole LINE => finish Line Iteration
     *     => if BLOCK => move to the buffer before => new Line Iteration
     */
    throw new IllegalArgumentException("not implemented");
  }
}
