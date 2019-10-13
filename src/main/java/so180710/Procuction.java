package so180710;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

class GenericRequest {}

class SpecificRequest1 extends GenericRequest {
    void method1() {
        System.out.println("specific1");
    }
}

class SpecificRequest2 extends GenericRequest {
    void method2() {
        System.out.println("specific2");
    }
}

interface ReqInterface {
    void method();
}

class Specific1 implements ReqInterface {
    private final SpecificRequest1 req =new SpecificRequest1();

    @Override
    public void method() {
        req.method1();
    }
}

class Specific2 implements ReqInterface {
    private final SpecificRequest2 req =new SpecificRequest2();

    @Override
    public void method() {
        req.method2();
    }
}

public class Procuction {
    void method(ReqInterface req) {
        req.method();
    }

    public static void main3(String[] args) {
        Procuction l3 = new Procuction();
        l3.method(new Specific1());
        l3.method(new Specific2());
    }

    public String test78 (Set<String> set) {
        return set.
                stream()
                .collect(Collectors.joining(" "));
    }

    public String test77 (Set<String> set) {
        return set.stream().reduce("", (a,b)->(a+" "+b));
    }

    public String test76 (Set<String> set) {
        return String.join(" ", set);
    }

    public static void main(String[] args) {
        Procuction p = new Procuction();
        System.out.println(p.test76(new HashSet<String>(){{add("qq");add("ww");add("ee");}}));
    }
}
