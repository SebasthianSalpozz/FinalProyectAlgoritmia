package entity;

/**
 * Represents a user entity with basic information such as name, level, elo, server, and main characters.
 */
public class UserEntity {

    private final String name;
    private final int level;
    private final String elo;
    private final String server;
    private final CharacterEntity mainCharacters;

    /**
     * Constructs a new UserEntity with the specified parameters.
     * @param name The name of the user.
     * @param level The level of the user.
     * @param elo The elo (ranking) of the user.
     * @param server The server where the user plays.
     * @param mainCharacters The main characters associated with the user.
     */
    public UserEntity(String name, int level, String elo, String server, CharacterEntity mainCharacters) {
        this.name = name;
        this.level = level;
        this.elo = elo;
        this.server = server;
        this.mainCharacters = mainCharacters;
    }

    /**
     * Gets the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the level of the user.
     * @return The level of the user.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the elo (ranking) of the user.
     * @return The elo of the user.
     */
    public String getElo() {
        return elo;
    }

    /**
     * Gets the server where the user plays.
     * @return The server of the user.
     */
    public String getServer() {
        return server;
    }

    /**
     * Gets the main characters associated with the user.
     * @return The main characters of the user.
     */
    public CharacterEntity getMainCharacters() {
        return mainCharacters;
    }
}
