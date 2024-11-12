package org.example;

public class Link {
    private final String nameLink;
    private final int level;

    public Link(String nameLink, int level) {
        this.nameLink = nameLink;
        this.level = level;
    }


    public String getNameLink() {
        return nameLink;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Link{" +
                "nameLink='" + nameLink + '\'' +
                '}';
    }
}
