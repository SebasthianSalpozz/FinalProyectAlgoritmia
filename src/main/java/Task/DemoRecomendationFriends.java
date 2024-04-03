package Task;
import entity.UserEntity;
import entity.CharacterEntity;
import java.util.List;
public class DemoRecomendationFriends {
    public static void main(String[] args) {
        // Iron
        UserEntity felix = new UserEntity("Felix", 13, "Iron", "EUW", CharacterEntity.FIZZ);
        UserEntity lucia = new UserEntity("Lucia", 20, "Iron", "NA", CharacterEntity.ZED);
        UserEntity camila = new UserEntity("Camila", 27, "Iron", "KR", CharacterEntity.SORAKA);
        UserEntity samuel = new UserEntity("Samuel", 12, "Iron", "LAS", CharacterEntity.KARTHUS);
        UserEntity monica = new UserEntity("Monica", 5, "Iron", "JAP", CharacterEntity.ZED);
        //Bronze
        UserEntity luca = new UserEntity("Luca", 12, "Bronze", "LAS", CharacterEntity.TRISTANA);
        UserEntity hugo = new UserEntity("Hugo", 19, "Bronze", "LAS", CharacterEntity.JINX);
        UserEntity vale = new UserEntity("Vale", 26, "Bronze", "EUW", CharacterEntity.KATARINA);
        UserEntity jose = new UserEntity("Jose", 13, "Bronze", "KR", CharacterEntity.JANNA);
        UserEntity antonio = new UserEntity("Antonio", 6, "Bronze", "EUW", CharacterEntity.KAI_SA);
        //Silver
        UserEntity luis = new UserEntity("Luis", 11, "Silver", "NA", CharacterEntity.AHRI);
        UserEntity sofia = new UserEntity("Sofia", 18, "Silver", "KR", CharacterEntity.GAREN);
        UserEntity pablo = new UserEntity("Pablo", 25, "Silver", "NA", CharacterEntity.TEEMO);
        UserEntity amon86 = new UserEntity("Amon86", 14, "Silver", "EUW", CharacterEntity.CAITLYN);
        UserEntity juana = new UserEntity("Juana", 7, "Silver", "LAS", CharacterEntity.BLITZCRANK);
        //Gold
        UserEntity pedro = new UserEntity("Pedro", 10, "Gold", "NA", CharacterEntity.YASUO);
        UserEntity deidamia = new UserEntity("Deidamia", 17, "Gold", "EUW", CharacterEntity.LUX);
        UserEntity sara = new UserEntity("Sara", 24, "Gold", "LAS", CharacterEntity.ANNIE);
        UserEntity mateo = new UserEntity("Mateo", 15, "Gold", "NA", CharacterEntity.NAUTILUS);
        UserEntity batten = new UserEntity("Batten", 8, "Gold", "KR", CharacterEntity.VARUS);
        //Platinum
        UserEntity lucho = new UserEntity("lucho", 16, "Platinum", "NA", CharacterEntity.ASHE);
        UserEntity diego = new UserEntity("Diego", 23, "Platinum", "KR", CharacterEntity.LEE_SIN);
        UserEntity isabella = new UserEntity("Isabella", 30, "Platinum", "EUW", CharacterEntity.GRAGAS);
        UserEntity emiliano = new UserEntity("Emiliano", 9, "Platinum", "NA", CharacterEntity.GRAGAS);
        UserEntity agustin = new UserEntity("Agustin", 2, "Platinum", "KR", CharacterEntity.YASUO);
        //Emerald
        UserEntity alex = new UserEntity("Alex", 14, "Emerald", "KR", CharacterEntity.MORGANA);
        UserEntity danielo = new UserEntity("Danielo", 21, "Emerald", "EUW", CharacterEntity.LEONA);
        UserEntity emma = new UserEntity("Emma", 28, "Emerald", "NA", CharacterEntity.ZOE);
        UserEntity victoria = new UserEntity("Victoria", 11, "Emerald", "NA", CharacterEntity.LEE_SIN);
        UserEntity emilio = new UserEntity("Emilio", 4, "Emerald", "LAS", CharacterEntity.LUX);
        //Diamond
        UserEntity lorenza = new UserEntity("Lorenza", 15, "Diamond", "JAP", CharacterEntity.DARIUS);
        UserEntity ana = new UserEntity("Ana", 22, "Diamond", "JAP", CharacterEntity.ASHE);
        UserEntity martin = new UserEntity("Martin", 29, "Diamond", "LAS", CharacterEntity.VAYNE);
        UserEntity gabriel = new UserEntity("Gabriel", 10, "Diamond", "EUW", CharacterEntity.AHRI);
        UserEntity katalina = new UserEntity("Katalina", 3, "Diamond", "NA", CharacterEntity.JINX);
        
        batten.addFriend(felix);
        batten.addFriend(luca);
        batten.addFriend(luis);
        batten.addFriend(pedro);
        batten.addFriend(lucho);
        batten.addFriend(alex);
        batten.addFriend(lorenza);
        
        felix.addFriend(lucia);
        felix.addFriend(camila);
        felix.addFriend(monica);

        camila.addFriend(samuel);
        
        luca.addFriend(hugo);
        luca.addFriend(vale);

        vale.addFriend(jose);
        vale.addFriend(antonio);
        
        luis.addFriend(sofia);
        luis.addFriend(pablo);
        luis.addFriend(amon86);
        luis.addFriend(juana);
        
        pedro.addFriend(deidamia);
        pedro.addFriend(sara);
        pedro.addFriend(mateo);

        lucho.addFriend(diego);
        lucho.addFriend(isabella);
        lucho.addFriend(emiliano);
        lucho.addFriend(agustin);

        alex.addFriend(danielo);
        alex.addFriend(emma);
        alex.addFriend(victoria);
        alex.addFriend(emilio);

        lorenza.addFriend(ana);
        lorenza.addFriend(martin);
        lorenza.addFriend(gabriel);
        lorenza.addFriend(katalina);  

        List<UserEntity> amigosRecomendados = batten.friendListRecomendation();
        System.out.println("Amigos recomendados para Batten:");
        if(amigosRecomendados.size() == 0){
            System.out.println("No hay amigos recomendados para Luis");
        }else{
            for (UserEntity usuario : amigosRecomendados) {
                System.out.println(usuario.getName());
            }
        }
        
        List<UserEntity> amigosRecomendados2 = felix.friendListRecomendation();
        System.out.println("Amigos recomendados para Felix:");
        if(amigosRecomendados2.size() == 0){
            System.out.println("No hay amigos recomendados para Felix");
        }else{
            for (UserEntity usuario : amigosRecomendados2) {
                System.out.println(usuario.getName());
            }
        }

        List<UserEntity> amigosRecomendados3 = luca.friendListRecomendation();
        System.out.println("Amigos recomendados para Luca:");
        if(amigosRecomendados3.size() == 0){
            System.out.println("No hay amigos recomendados para Luca");
        }else{
            for (UserEntity usuario : amigosRecomendados3) {
                System.out.println(usuario.getName());
            }
        }

        List<UserEntity> amigosRecomendados4 = luis.friendListRecomendation();
        System.out.println("Amigos recomendados para Luis:");
        if(amigosRecomendados4.size() == 0){
            System.out.println("No hay amigos recomendados para Luis");
        }else{
            for (UserEntity usuario : amigosRecomendados4) {
                System.out.println(usuario.getName());
            }
        }
        
    }
}
