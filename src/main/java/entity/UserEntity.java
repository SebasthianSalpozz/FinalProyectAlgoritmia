package entity;

public class UserEntity {

    private final String name;
    private final int level;
    private final String elo;
    private final String server;
    private final CharacterEntity mainCharacters;

    public UserEntity(String name, int level, String elo, String server, CharacterEntity mainCharacters) {
        this.name = name;
        this.level = level;
        this.elo = elo;
        this.server = server;
        this.mainCharacters = mainCharacters;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getElo() {
        return elo;
    }

    public String getServer() {
        return server;
    }

    public CharacterEntity getMainCharacters() {
        return mainCharacters;
    }
}
