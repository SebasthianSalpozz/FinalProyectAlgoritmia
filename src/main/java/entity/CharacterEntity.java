package entity;

/**
 * Enum representing different characters in a game, along with their respective lanes.
 */
public enum CharacterEntity {

    YASUO ("Yasuo", "Mid"),
    AHRI ("Ahri", "Mid"),
    TRISTANA ("Tristana", "ADC"),
    FIZZ ("Fizz", "Mid"),
    MORGANA ("Morgana", "Support"),
    DARIUS ("Darius", "Top"),
    ASHE ("Ashe", "ADC"),
    LUX ("Lux", "Mid-Support"),
    GAREN ("Garen", "Top"),
    JINX ("Jinx", "ADC"),
    ZED ("Zed", "Mid"),
    LEONA ("Leona", "Support"),
    LEE_SIN ("Lee Sin", "Jungle"),
    EKKO ("Ekko", "Mid"),
    KAI_SA ("Kai'Sa", "ADC"),
    MALPHITE ("Malphite", "Top"),
    NAMI ("Nami", "Support"),
    RIVEN ("Riven", "Top"),
    SONA ("Sona", "Support"),
    THRESH ("Thresh", "Support"),
    VAYNE ("Vayne", "ADC"),
    ZOE ("Zoe", "Mid"),
    ALISTAR ("Alistar", "Support"),
    CAMILLE ("Camille", "Top"),
    EZREAL ("Ezreal", "ADC"),
    KATARINA ("Katarina", "Mid"),
    NAUTILUS ("Nautilus", "Support"),
    RENGAR ("Rengar", "Jungle"),
    TEEMO ("Teemo", "Top"),
    VARUS ("Varus", "ADC"),
    ANNIE ("Annie", "Mid"),
    BLITZCRANK ("Blitzcrank", "Support"),
    FIORA ("Fiora", "Top"),
    GRAVES ("Graves", "Jungle"),
    JANNA ("Janna", "Support"),
    KARTHUS ("Karthus", "Mid"),
    NOCTURNE ("Nocturne", "Jungle"),
    SORAKA ("Soraka", "Support"),
    VEIGAR ("Veigar", "Mid"),
    ZYRA ("Zyra", "Support"),
    AMUMU ("Amumu", "Jungle"),
    CAITLYN ("Caitlyn", "ADC"),
    GRAGAS ("Gragas", "Jungle"),
    JAYCE ("Jayce", "Top-Mid"),
    KHA_ZIX ("Kha'Zix", "Jungle"),
    LULU ("Lulu", "Support"),
    ORIANNA ("Orianna", "Mid"),
    SHEN ("Shen", "Top-Support"),
    TARIC ("Taric", "Support"),
    VLADIMIR ("Vladimir", "Top-Mid");

    private final String name;
    private final String lane;

    /**
     * Constructs a CharacterEntity enum with the given name and lane.
     * @param name The name of the character.
     * @param lane The lane where the character typically plays.
     */
    CharacterEntity(String name, String lane) {
        this.name = name;
        this.lane = lane;
    }

    /**
     * Gets the name of the character.
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the lane where the character typically plays.
     * @return The lane of the character.
     */
    public String getLane() {
        return lane;
    }

    /**
     * Gets the character entity by name.
     * @param name The name of the character.
     * @return The character entity if found, null otherwise.
     */
    public static CharacterEntity getCharacterByName(String name) {
        for (CharacterEntity character : CharacterEntity.values()) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }
        return null;
    }
}
