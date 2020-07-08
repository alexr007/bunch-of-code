package kata13.strip.state;

/**
 * LineState:
 *  String input;
 *  int pos;
 *  StringBuilder output;
 *  boolean inBlock;
 */
public class LineState {
  public final String input;
  public final int pos;
  public final StringBuilder output;
  public final boolean inBlock;

  public LineState(String input, int pos, StringBuilder output, boolean inBlock) {
    this.input = input;
    this.pos = pos;
    this.output = output;
    this.inBlock = inBlock;
  }

  public static LineState fresh(String input, boolean inBlock) {
    return new LineState(input, 0, new StringBuilder(), inBlock);
  }

  public LineState moveTo(int pos, boolean inBlock) {
    return new LineState(input, pos, output, inBlock);
  }

  public LineState switchAndMove(int pos) {
    return new LineState(input, pos, output, !inBlock);
  }

  public LineState finish() {
    return new LineState(input, input.length(), output, inBlock);
  }

}
