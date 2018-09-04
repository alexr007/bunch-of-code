package streams;

import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Split {
    public static void main(String[] args) {
        Pattern compiled = Pattern.compile("[(\\!),(\\?),(\\.)]");
        compiled.splitAsStream("Hello! World? Maaybe.").forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("_"+s+"_");
            }
        });

    }
}
