package kata13.strip.filter;

import kata13.strip.state.LineState;

/**
 * StripAllComments Implementation
 * based on StripBlankLines (Blank Lines isn't counted)
 * and removes all comments
 * heavily based on StripBlockOnlyComments
 *
 * if (ls.inBlock)
 *   => BLOCK_CL found     - cut until, switch inBlock, next iteration
 *   => BLOCK_CL not found - skip till the end on the line
 * if (!ls.inBlock)
 *   => BLOCK_OP and LINE found - process first
 *   => LINE found              - save until, skip till the end on the line
 *   => BLOCK_OP found          - save until, switch inBlock, next iteration
 *   => not found               - save all until the end of the line
 */
public class Strip4AllComments extends Strip1BlankLines {
    @Override
    public LineState process(LineState ls) {
      if (ls.inBlock) {
        // inside th block comment, look for a closing tag: */
        int cl_pos = ls.input.indexOf(BLOCK_CL, ls.pos);
        if (cl_pos > 0) {
          // closing `*/` found
          return ls.switchAndMove(cl_pos + BLOCK_CL.length());
        } else {
          // no closing until end of the line
          return ls.finish();
        }
      } else {
        // outside the block comment, look for an opening tag: /*
        int op_pos = ls.input.indexOf(BLOCK_OP, ls.pos);
        int ln_pos = ls.input.indexOf(LINE, ls.pos);
        if (op_pos >=0 && ln_pos >= 0) {
          // we found both. process what we found first.
          if (op_pos < ln_pos) {
            // block first
            String before = ls.input.substring(ls.pos, op_pos);
            ls.output.append(before);
            return ls.switchAndMove(op_pos + BLOCK_OP.length());
          } else {
            // line first
            String before = ls.input.substring(ls.pos, ln_pos);
            ls.output.append(before);
            return ls.finish();
          }
        } else if (op_pos >= 0) {
          // opening `/*` found only
          String before = ls.input.substring(ls.pos, op_pos);
          ls.output.append(before);
          return ls.switchAndMove(op_pos + BLOCK_OP.length());
        } else if (ln_pos >= 0) {
          // line comment found
          String before = ls.input.substring(ls.pos, ln_pos);
          ls.output.append(before);
          return ls.finish();
        } else {
          // no opening block, no line comment found till the end of the line
          String residual = ls.input.substring(ls.pos);
          ls.output.append(residual);
          return ls.finish();
        }
      }
    }
}
