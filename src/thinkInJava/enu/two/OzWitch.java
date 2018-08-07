package thinkInJava.enu.two;

/**
 * @author Will
 * @date 2018/8/6.
 */
public enum OzWitch {
    // instances must be defined first, before methods
    WEST("WWW"),
    NORTH("NNN"),
    EAST("EEE"),
    SOURTH("SSS");

    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + " : " + witch.getDescription());
        }
    }
}
