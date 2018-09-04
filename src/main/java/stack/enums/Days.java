package stack.enums;

public enum Days {
    Monday("Mo"),
    Tuesday("Tu"),
    Wednesday("We"),
    Thursday("Th"),
    Friday("Fr"),
    Saturday("Sa"),
    Sunday("Su");

    private final String shortname;
    Days(String shortname) {
        this.shortname=shortname;
    }

    public String sname() {
        return this.shortname;
    }
}
