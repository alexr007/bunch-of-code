package parsers.cambridge;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.List;

public class CambridgeParsed {
    private final String address="https://dictionary.cambridge.org/dictionary/english/";
    private final List<String> words;

    public CambridgeParsed(String... words) {
        this(Arrays.asList(words));
    }

    public CambridgeParsed(List<String> words) {
        this.words = words;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("compulsory", "ambidextrous", "ligament");
        new CambridgeParsed(words).run();
    }

    public void run() {
        words.forEach(this::grabSingleFile);
    }

    private void grabSingleFile(String word) {
        Document parsed = null;
        try {
            parsed = Jsoup.connect(this.address + word).get();
/*        PrintWriter out3 = new PrintWriter(name + "3");
        out3.print(parsed.text());
        out3.close();
*/

//        Document parsed = Jsoup.parse(new File("malfeasance.html"), "UTF-8");
            String addr = parsed
                    .select("div.contain")
                    .select("div.entry-body__el")
                    .select("span.pron-info")
                    .select("span[title]")
                    .first()
                    .attributes()
                    .get("data-src-mp3");
            System.out.println(addr);
            URL url = new URL(addr);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(word+".mp3");
            fos.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
