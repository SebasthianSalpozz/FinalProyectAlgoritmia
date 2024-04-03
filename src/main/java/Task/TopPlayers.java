package Task;

import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.domain.Document;
import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.Match;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.intuit.fuzzymatcher.domain.ElementType.*;

public class TopPlayers {
    public static void main(String[] args) {
        String[][] input = {
                { "KR", "Maestro", "Figue"},
                { "Corea", "Maestro", "Silver"},
                { "COREA", "Maestro", "Wolf"},

                {"NA", "Hierro", "Jorge"},
                {"NORTE AMERICA", "Bronce", "Trueno"},
                {"Norte America", "Plata", "Rayo"},
                {"NorTE AMERICA", "Oro", "Luna"},
                {"NORTE america", "Platino", "Estrella"},
                {"NA", "Diamante", "Sombra"},
                {"NA", "Maestro", "Brisa"},


                {"LAN", "Hierro", "Centella"},
                {"LAN", "Bronce", "Aurora"},
                {"LAN", "Plata","Canela"},
                {"LAN", "Oro", "Zafiro"},
                {"LAN", "Platino", "Neblina"},
                {"LAN", "Diamante", "Marfil"},
                {"LAN", "Maestro", "Jade"},


                {"LAS", "Hierro", "Amatista"},
                {"LAS", "Bronce", "Azabache"},
                {"LAS", "Plata", "Coral"},
                {"LAS", "Oro", "Ámbar"},
                {"LAS", "Platino", "Pétalo"},
                {"LAS", "Diamante", "Alba"},
                {"LAS", "Maestro", "Penumbra"},


                {"EUW", "Hierro", "Orquídea"},
                {"EUW", "Bronce", "Topacio"},
                {"EUW", "Plata", "Carmesí"},
                {"EUW", "Oro", "Esencia"},
                {"EUW", "Platino", "Valquiria"},
                {"EUW", "Diamante", "Nimbo"},
                {"EUW", "Maestro", "Fénix"},


                {"EUNE", "Hierro", "Grial"},
                {"EUNE", "Bronce", "Relámpago"},
                {"EUNE", "Plata", "Enigma"},
                {"EUNE", "Oro", "Albor"},
                {"EUNE", "Platino", "Zodiaco"},
                {"EUNE", "Diamante", "Caoba"},
                {"EUNE", "Maestro", "Alud"},


                {"KR", "Hierro", "Quimera"},
                {"KR", "Bronce", "Lucero"},
                {"KR", "Plata", "Argón"},
                {"KR", "Oro", "Píxel"},
                {"KR", "Platino", "Nebuloso"},
                {"KR", "Diamante", "Caramelo"},
                {"KR", "Maestro", "Áureo"},


                {"JP", "Hierro", "Helio"},
                {"JP", "Bronce", "Anochecer"},
                {"JP", "Plata", "Querubín"},
                {"JP", "Oro", "Silex"},
                {"JP", "Platino", "Vendaval"},
                {"JP", "Diamante", "Nimbus"},
                {"JP", "Maestro", "Corinto"},


                {"CN", "Hierro","Magnolia"},
                {"CN", "Bronce", "Hibisco"},
                {"CN", "Plata", "Sándalo"},
                {"CN", "Oro", "Bambú"},
                {"CN", "Diamante", "Celaje"},
                {"CN", "Maestro", "Boreal"},


                {"OCE", "Hierro", "Cenit"},
                {"OCE", "Bronce", "Luminaria"},

                {"OCE", "Oro", "Melancolía"},
                {"OCE", "Platino", "Azotea"},
                {"OCE", "Maestro", "Ébano"},

        };

        List<Document> documentList = Arrays.asList(input).stream().map(contact -> {
            return new Document.Builder(contact[0])
                    .addElement(new Element.Builder<String>().setValue(contact[0]).setType(SERVER).createElement())
                    .addElement(new Element.Builder<String>().setValue(contact[1]).setType(TEXT).createElement())
                    .addElement(new Element.Builder<String>().setValue(contact[2]).setType(NAME).createElement())
                    .createDocument();
        }).collect(Collectors.toList());

        MatchService matchService = new MatchService();
        Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(documentList);

        result.entrySet().forEach(entry -> {
            entry.getValue().forEach(match -> {
                System.out.println("Data: " + match.getData() + " Matched With: " + match.getMatchedWith() + " Score: " + match.getScore().getResult());
            });
        });

    }
}
