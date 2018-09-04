package parsers;

/**
 * Created by alexr on 18.10.2016.
 */
public class ParsedDataUPS {

    private String date;
    private String status;
    boolean finished;

    public ParsedDataUPS(String date, String status)
    {
        this.date = date;
        this.status = status;
    }

    public String date()
    {
        String d1 = this.date.replace("&nbsp;", " ");
        return d1;
    }

    public String status()
    {
        return this.status;
    }

    public boolean finished()
    {
        return this.status.equals("Delivered");
    }

}
