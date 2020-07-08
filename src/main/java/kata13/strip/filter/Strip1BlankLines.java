package kata13.strip.filter;

/**
 * StripBlankLines Implementation
 * based on StripNothing
 * but doesn't count Blank Lines
 */
public class Strip1BlankLines extends Strip0Nothing {
  @Override
  public int count(StringBuilder sb) {
    return sb.toString().isBlank() ? 0 : 1;
  }
}
