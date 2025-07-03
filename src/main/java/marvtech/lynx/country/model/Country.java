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
        members.add(player);
    }

    public void removeMember(String player) {
        members.remove(player);
    }
}
