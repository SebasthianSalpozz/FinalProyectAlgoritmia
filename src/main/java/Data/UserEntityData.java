package Data;

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
            /*
            America:
            Norteamérica (NA)
            Latinoamérica Norte (LAN)
            Latinoamérica Sur (LAS)
            Europa:
            Europa Oeste (EUW)
            Europa Nórdica y del Este (EUNE)
            Asia:
            Corea (KR):
            Japón (JP)
            China (CN)
            Sudeste Asiático (EUW)
            Otras regiones:
            Oceanía (OCE)
            Rusia (EUW)
            Turquía (EUW)

            Hierro
            Bronce
            Plata
            Oro
            Platino
            Diamante
            Maestro
            Challenger
             */
            new UserEntity("SilverWolf", 35, "Challenger", "LAS",
                    CharacterEntity.YASUO),
            new UserEntity("DarkKnight", 28, "Oro", "lan",
                    CharacterEntity.AHRI),
            new UserEntity("ShadowNinja", 40, "Diamante", "las",
                    CharacterEntity.TRISTANA),
            new UserEntity("FrostMage", 31, "Platino", "Jp",
                    CharacterEntity.FIZZ),
            new UserEntity("NightmareQueen", 25, "Maestro", "KR",
                    CharacterEntity.MORGANA),
            new UserEntity("BloodAssassin", 29, "Plata", "EuW",
                    CharacterEntity.DARIUS),
            new UserEntity("FireGoddess", 33, "Hierro", "EUw",
                    CharacterEntity.ASHE),
            new UserEntity("ThunderLord", 27, "Plata", "LAS",
                    CharacterEntity.LUX),
            new UserEntity("IronWarrior", 30, "Diamante", "LAN",
                    CharacterEntity.GAREN),
            new UserEntity("WindRanger", 26, "Bronce", "NA",
                    CharacterEntity.JINX)
    };

}
