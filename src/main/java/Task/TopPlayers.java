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

                { "Corea", "Maestro", "Silver"},

                {"NA", "Hierro", "Jorge"},
                {"LAN", "Oro", "Zafiro"},
                {"NORTE AMERICA", "Bronce", "Trueno"},
                {"Norte America", "Plata", "Rayo"},
                {"KR", "Maestro", "Áureo"},
                {"LAN", "Maestro", "Jade"},
                {"NorTE AMERICA", "Oro", "Luna"},
                {"LAS", "Bronce", "Azabache"},
                {"NA", "Diamante", "Sombra"},
                {"LAN", "Bronce", "Aurora"},
                {"LAS", "Diamante", "Alba"},
                {"LAN", "Plata","Canela"},
                {"LAN", "Platino", "Neblina"},

                { "KR", "Maestro", "Figue"},

                {"LAS", "Hierro", "Amatista"},
                {"EUW", "Bronce", "Topacio"},
                {"LAS", "Plata", "Coral"},
                {"JP", "Oro", "Silex"},
                {"LAS", "Maestro", "Penumbra"},
                {"LAS", "Oro", "Ámbar"},
                {"EUW", "Plata", "Carmesí"},
                {"LAS", "Platino", "Pétalo"},
                {"EUW", "Hierro", "Orquídea"},
                {"OCE", "Oro", "Melancolía"},
                {"EUW", "Oro", "Esencia"},
                {"NORTE america", "Platino", "Estrella"},
                {"EUW", "Diamante", "Nimbo"},
                {"EUNE", "Plata", "Enigma"},
                {"EUW", "Maestro", "Fénix"},

                { "COREA", "Maestro", "Wolf"},

                {"EUNE", "Hierro", "Grial"},
                {"EUW", "Platino", "Valquiria"},
                {"EUNE", "Oro", "Albor"},
                {"OCE", "Bronce", "Luminaria"},
                {"EUNE", "Platino", "Zodiaco"},
                {"OCE", "Hierro", "Cenit"},
                {"EUNE", "Diamante", "Caoba"},
                {"JP", "Diamante", "Nimbus"},
                {"EUNE", "Maestro", "Alud"},
                {"KR", "Hierro", "Quimera"},
                {"JP", "Plata", "Querubín"},
                {"KR", "Plata", "Argón"},
                {"KR", "Oro", "Píxel"},
                {"LAN", "Hierro", "Centella"},
                {"KR", "Platino", "Nebuloso"},
                {"KR", "Bronce", "Lucero"},
                {"KR", "Diamante", "Caramelo"},
                {"NA", "Maestro", "Brisa"},
                {"JP", "Hierro", "Helio"},
                {"LAN", "Diamante", "Marfil"},
                {"JP", "Bronce", "Anochecer"},
                {"OCE", "Platino", "Azotea"},
                {"JP", "Platino", "Vendaval"},
                {"CN", "Diamante", "Celaje"},
                {"JP", "Maestro", "Corinto"},
                {"CN", "Hierro","Magnolia"},
                {"CN", "Bronce", "Hibisco"},
                {"CN", "Plata", "Sándalo"},
                {"EUNE", "Bronce", "Relámpago"},
                {"CN", "Oro", "Bambú"},
                {"CN", "Maestro", "Boreal"},
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
