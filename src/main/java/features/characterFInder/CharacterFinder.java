package features.characterFInder;

import Data.UserEntityData;
import entity.CharacterEntity;
import entity.UserEntity;

import java.util.HashSet;
import java.util.Set;

public class CharacterFinder {

    private final FiniteAutomata_Modified finiteAutomataModified;
    private final UserEntity[] userList;

    public CharacterFinder() {
        this.finiteAutomataModified = new FiniteAutomata_Modified();
        this.userList = UserEntityData.userList;
    }

    public Set<CharacterEntity> findCharacter(UserEntity user){
        Set<CharacterEntity> aux = new HashSet<>();
        for (UserEntity auxUser : userList){
            if (aux.size() <= 10){
                if (finiteAutomataModified.match(auxUser.getElo(), user.getElo())
                        && finiteAutomataModified.match(auxUser.getServer(), user.getServer())){
                    aux.add(auxUser.getMainCharacters());
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
