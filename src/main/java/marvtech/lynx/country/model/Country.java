package marvtech.lynx.country.model;


import java.util.HashSet;
import java.util.Set;

/**
 * Minimal country model storing basic data for demonstration.
 */
public class Country {
    private final String name;
    private final String founder;
    private final Set<String> members = new HashSet<>();
    private final Set<String> invites = new HashSet<>();
    private String color = "#FFFFFF";
    private int capitalX;
    private int capitalZ;

    public Country(String name, String founder) {
        this.name = name;
        this.founder = founder;
        this.members.add(founder);
    }

    public String getName() {
        return name;
    }

    public String getFounder() {
        return founder;
    }

    public Set<String> getMembers() {
        return members;
    }

    public void addMember(String player) {
        invites.remove(player);
        members.add(player);
    }

    public void removeMember(String player) {
        members.remove(player);
    }

    public Set<String> getInvites() {
        return invites;
    }

    public void invite(String player) {
        invites.add(player);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapitalX() {
        return capitalX;
    }

    public int getCapitalZ() {
        return capitalZ;
    }

    public void setCapital(int x, int z) {
        this.capitalX = x;
        this.capitalZ = z;
    }
=======
/** Simple POJO for country. */
public class Country {

}
