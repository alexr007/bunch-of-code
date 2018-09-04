package parsers;

import java.net.MalformedURLException;
import java.util.Arrays;

/**
 * Created by alexr on 18.10.2016.
 */
public class TrackingParser  {

    public static void main(String[] args) throws MalformedURLException {
        Arrays.asList(
            "http://www.yegor256.com/2017/09/12/evil-object-name-suffix-client.html",
            "https://stackoverflow.com/questions/23932061/convert-iterable-to-stream-using-java-8-jdk"
            ,"http://www.google.com"
            )
            .forEach(s -> new ProcessText(s).process());
    }
}
