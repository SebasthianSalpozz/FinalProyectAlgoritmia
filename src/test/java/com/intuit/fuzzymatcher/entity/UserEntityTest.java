package com.intuit.fuzzymatcher.entity;

import java.util.List;

public class UserEntityTest {
    public static void main(String[] args) {
        UserEntity pedro = new UserEntity("Pedro", 10, "Gold", "NA", null);
        UserEntity Luis = new UserEntity("Luis", 10, "Gold", "NA", null);
        UserEntity luca = new UserEntity("Luca",11, "Gold","NA", null);
        UserEntity felix = new UserEntity("Felix", 11, "Gold","NA", null);
        UserEntity Alex = new UserEntity("Alex",11, "Silver","Silver", null);
        UserEntity Lorenza = new UserEntity("Lorenza",11, "Silver","Silver", null);
    
        pedro.addFriend(Luis);
        pedro.addFriend(Alex);
        Luis.addFriend(luca);
        Luis.addFriend(felix);
        Alex.addFriend(Lorenza);

        List<UserEntity> amigosRecomendados = pedro.friendListRecomendation();
        System.out.println("Amigos recomendados para Pedro:");
        for (UserEntity usuario : amigosRecomendados) {
            System.out.println(usuario.getName());
        }
    }
}
