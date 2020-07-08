package kata13.strip.state;

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
    return new LineState(this.input, pos, this.output, inBlock);
  }

  public LineState finish() {
    return finish(this.inBlock);
  }

  public LineState finish(boolean inBlock) {
    return new LineState(this.input, this.input.length(), this.output, inBlock);
  }
}
