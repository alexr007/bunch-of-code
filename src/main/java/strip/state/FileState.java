package strip.state;

public class FileState {
  public final long count;
  public final boolean inBlock;

  public FileState(long count, boolean inBlock) {
    this.count = count;
    this.inBlock = inBlock;
  }

  public static FileState zero() {
    return new FileState(0, false);
  }

  public FileState next(int delta, boolean inBlock) {
    return new FileState(this.count + delta, inBlock);
  }
}
