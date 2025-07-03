package marvtech.lynx.faction.model;

/** Simple POJO for faction. */
public class Faction {
    private final int id;
    private final String name;

    public Faction(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
