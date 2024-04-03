package features.characterFInder;

import Data.UserEntityData;

import java.util.HashSet;
import java.util.Set;

import entity.CharacterEntity;
import entity.UserEntity;

/**
 * This class provides methods to find characters associated with users based on specific criteria.
 */
public class CharacterFinder {

    private final FiniteAutomata_Modified finiteAutomataModified;
    private final UserEntity[] userList;

    /**
     * Constructor to initialize the CharacterFinder.
     */
    public CharacterFinder() {
        this.finiteAutomataModified = new FiniteAutomata_Modified();
        this.userList = UserEntityData.userList;
    }


    /**
     * Finds characters associated with a given user.
     * @param user The user for whom characters will be searched.
     * @return A set of character names associated with the user.
     */
    public Set<String> findCharacter(UserEntity user){
        Set<String> aux = new HashSet<>();
        for (UserEntity auxUser : userList){
            if (aux.size() <= 10){
                if (finiteAutomataModified.match(auxUser.getElo(), user.getElo())
                        && finiteAutomataModified.match(auxUser.getServer(), user.getServer())){
                    aux.add(auxUser.getMainCharacters().getName());
                }
            } else {
                break;
            }
        }
        return aux;
    }


    public static void main(String[] args) {
        CharacterFinder characterFinder = new CharacterFinder();
        System.out.println(characterFinder.findCharacter(new UserEntity("Diego", 34, "oro", "las", CharacterEntity.AHRI)));
    }


}
