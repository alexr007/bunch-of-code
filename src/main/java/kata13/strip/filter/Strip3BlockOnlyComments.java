package kata13.strip.filter;

import kata13.strip.state.LineState;

/**
 * StripBlockOnlyComments Implementation
 * based on StripBlankLines (Blank Lines isn't counted)
 * and removes Line comments
 *
 * if (ls.inBlock)
 *   => BLOCK_CL found     - cut until, switch inBlock, next iteration
 *   => BLOCK_CL not found - skip till the end on the line
 * if (!ls.inBlock)
 *   => BLOCK_OP found     - save until, switch inBlock, next iteration
 *   => BLOCK_OP not found - save all until the end of the line
 */
public class Strip3BlockOnlyComments extends Strip1BlankLines {
  @Override
  public LineState process(LineState ls) {
    if (ls.inBlock) {
      // inside th block comment, look for a closing tag: */
      int cl_pos = ls.input.indexOf(BLOCK_CL, ls.pos);
      if (cl_pos > 0) {
        // closing `*/` found
        return ls.moveTo(cl_pos + BLOCK_CL.length(), false);
      } else {
        // no closing until end of the line
        return ls.finish();
      }
    } else {
      // outside the block comment, look for an opening tag: /*
      int op_pos = ls.input.indexOf(BLOCK_OP, ls.pos);
      if (op_pos >= 0) {
        // opening `/*` found
        String before = ls.input.substring(ls.pos, op_pos);
        ls.output.append(before);
        return ls.moveTo(op_pos + BLOCK_OP.length(), true);
      } else {
        // no opening block found till the end of the line
        String residual = ls.input.substring(ls.pos);
        ls.output.append(residual);
        return ls.finish();
      }
    }
  }
}
