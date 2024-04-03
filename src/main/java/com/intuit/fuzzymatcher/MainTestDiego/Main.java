package com.intuit.fuzzymatcher.MainTestDiego;

import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.intuit.fuzzymatcher.domain.ElementType.*;

public class Main {
    public static void main(String[] args) {
        String[][] input = {
                {"1", "Steven"},
                {"2", "John Doe"},
                {"3", "Steven Stephen Wilkson"}
        };

        List<Document> documentList = Arrays.asList(input).stream().map(contact -> {
            return new Document.Builder(contact[0])
                    .addElement(new Element.Builder<String>().setValue(contact[1]).setType(NAME).setMatchType(MatchType.FINITE_AUTOMATA).createElement())
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
