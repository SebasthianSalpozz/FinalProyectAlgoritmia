package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.ElementType;
import com.intuit.fuzzymatcher.domain.Token;
import com.intuit.fuzzymatcher.function.TokenizerElo;

import static com.intuit.fuzzymatcher.domain.MatchType.EQUALITY;

/**
 * Represents a user entity with basic information such as name, level, elo, server, and main characters.
 */
public class UserEntity {

    private final String name;
    private final int level;
    private final String elo;
    private final String server;
    private final CharacterEntity mainCharacters;
    private List<UserEntity> friendList;

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
        this.friendList = new ArrayList<>();
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


    public void addFriend (UserEntity u){
        this.friendList.add(u);
    }

    /**
     * Este método se llama `friendListRecomendation`. Su objetivo es generar una lista de recomendaciones de amigos para el usuario actual
     * Primero, crea una lista vacía `friendListRecomendados` para almacenar las recomendaciones de amigos luego, recorre la lista de amigos 
     * del usuario actual. Para cada amigo, recorre la lista de amigos de ese amigo.
     * Si el amigo del amigo tiene el mismo ELO que el usuario actual y no está ya en la lista de amigos del usuario actual entonces se 
     * considera para la recomendación
     * Para cada amigo del amigo considerado se aplica una función de tokenización a su ELO Esta función se obtiene de `TokenizerElo.eloSoundexEncodeTokenizer()`
     * Se verifica si el amigo del amigo y el usuario actual tienen tokens comunes. Si es así, el amigo del amigo se añade a la lista de recomendaciones de amigos.
     * @return List<UserEntity> - La lista de recomendaciones de amigos.
     */
    public List<UserEntity> friendListRecomendation() {
        List<UserEntity> friendListRecomendados = new ArrayList<>();
        for (UserEntity amigo : friendList) {
            for (UserEntity amigoDeAmigo : amigo.friendList) {
                if (amigoDeAmigo.elo.equals(this.elo) && !friendList.contains(amigoDeAmigo)) {
                    Function<Element<String>, Stream<Token<String>>> eloTokenizer = TokenizerElo.eloSoundexEncodeTokenizer();
                    Stream<Token<String>> amigoDeAmigoTokens = eloTokenizer.apply(new Element<>(ElementType.ELO, "", amigoDeAmigo.elo, 1.0, 0.3, 0.9, null, null, EQUALITY));
                    Stream<Token<String>> thisTokens = eloTokenizer.apply(new Element<>(ElementType.ELO, "", this.elo, 1.0, 0.3, 0.9, null, null, EQUALITY));
                    boolean hasCommonTokens = amigoDeAmigoTokens.anyMatch(token -> thisTokens.anyMatch(t -> t.getValue().equals(token.getValue())));
                    if (hasCommonTokens) {
                        friendListRecomendados.add(amigoDeAmigo);
                    }
                }
            }
        }
        return friendListRecomendados;
    }

}
