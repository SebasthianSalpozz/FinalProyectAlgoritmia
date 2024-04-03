package data;

import entity.CharacterEntity;
import entity.UserEntity;

/**
 * Simulates a database with user entities.
 */
public class UserEntityData {

    /**
     * Array representing user data.
     */
    public static UserEntity[] userList = new UserEntity[]{
            new UserEntity("SilverWolf", 35, "platino-diamante", "las y lan",
                    CharacterEntity.YASUO),
            new UserEntity("DarkKnight", 28, "oro", "lan",
                    CharacterEntity.AHRI),
            new UserEntity("ShadowNinja", 40, "diamante", "las",
                    CharacterEntity.TRISTANA),
            new UserEntity("FrostMage", 31, "platino hierro", "las - jap",
                    CharacterEntity.FIZZ),
            new UserEntity("NightmareQueen", 25, "plata", "lan y lan",
                    CharacterEntity.MORGANA),
            new UserEntity("BloodAssassin", 29, "oroplata", "laslan",
                    CharacterEntity.DARIUS),
            new UserEntity("FireGoddess", 33, "platino-challenger", "lan",
                    CharacterEntity.ASHE),
            new UserEntity("ThunderLord", 27, "plata", "las",
                    CharacterEntity.LUX),
            new UserEntity("IronWarrior", 30, "diamante", "lan",
                    CharacterEntity.GAREN),
            new UserEntity("WindRanger", 26, "platino hierro maestro", "las",
                    CharacterEntity.JINX)
    };

}
