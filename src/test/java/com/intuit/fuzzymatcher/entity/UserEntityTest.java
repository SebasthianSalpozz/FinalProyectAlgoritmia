package com.intuit.fuzzymatcher.entity;

import entity.CharacterEntity;
import entity.UserEntity;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class UserEntityTest {
    @Test
    public void testFriendListRecomendation() {
        UserEntity pedro = new UserEntity("Pedro", 10, "Gold", "NA", CharacterEntity.YASUO);
        UserEntity Luis = new UserEntity("Luis", 10, "Gold", "NA", CharacterEntity.AHRI);
        UserEntity luca = new UserEntity("Luca",11, "Gold","NA", CharacterEntity.TRISTANA);
        UserEntity felix = new UserEntity("Felix", 11, "Gold","NA", CharacterEntity.FIZZ);
        UserEntity Alex = new UserEntity("Alex",11, "Silver","NA", CharacterEntity.MORGANA);
        UserEntity Lorenza = new UserEntity("Lorenza",11, "Silver","NA", CharacterEntity.DARIUS);
    
        pedro.addFriend(Luis);
        pedro.addFriend(Alex);
        Luis.addFriend(luca);
        Luis.addFriend(felix);
        Alex.addFriend(Lorenza);

        List<UserEntity> amigosRecomendados = pedro.friendListRecomendation();
        assertEquals(2, amigosRecomendados.size());
        assertTrue(amigosRecomendados.contains(luca));
        assertTrue(amigosRecomendados.contains(felix));
    }

    @Test
    public void testFriendListRecomendationWithDifferentUsers() {
        UserEntity maria = new UserEntity("Maria", 12, "Silver", "NA", null);
        UserEntity juan = new UserEntity("Juan", 12, "Silver", "NA", null);
        UserEntity carlos = new UserEntity("Carlos", 13, "Gold", "NA", null);
        UserEntity sofia = new UserEntity("Sofia", 13, "Gold", "NA", null);
        UserEntity ana = new UserEntity("Ana", 13, "Silver", "NA", null);
        UserEntity david = new UserEntity("David", 13, "Silver", "NA", null);

        maria.addFriend(juan);
        maria.addFriend(ana);
        juan.addFriend(carlos);
        juan.addFriend(sofia);
        ana.addFriend(david);

        List<UserEntity> amigosRecomendados = maria.friendListRecomendation();
        assertEquals(1, amigosRecomendados.size());
        assertTrue(amigosRecomendados.contains(david));
    }

    @Test
    public void testFriendListRecomendationWithEmptyFriendList() {
        UserEntity john = new UserEntity("John", 20, "Gold", "NA", null);

        List<UserEntity> amigosRecomendados = john.friendListRecomendation();
        assertEquals(0, amigosRecomendados.size());
    }

    @Test
    public void testFriendListRecomendationWithNoRecommendations() {
        UserEntity emily = new UserEntity("Emily", 18, "Silver", "NA", null);
        UserEntity sophia = new UserEntity("Sophia", 18, "Silver", "NA", null);
        UserEntity oliver = new UserEntity("Oliver", 18, "Silver", "NA", null);

        emily.addFriend(sophia);
        emily.addFriend(oliver);

        List<UserEntity> amigosRecomendados = emily.friendListRecomendation();
        assertEquals(0, amigosRecomendados.size());
    }
}
