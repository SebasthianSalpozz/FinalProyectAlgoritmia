package features.characterFInder;

import java.util.*;

public class FiniteAutomata_Modified {

    public boolean match(String completeTxt, String patternTxt){
        List<String> pattern = splitString(patternTxt);
        Map<String, Integer>[] table = new Map[pattern.size()+1];
        setInitialData(table, pattern);
        fillTable(table, getLetters(splitString(completeTxt)), pattern);

        return searchMatch(splitString(completeTxt), table, pattern.size());
    }

    public boolean searchMatch(List<String> lettersList, Map<String, Integer>[] table, int patternLength){
        int auxValue;
        int key = 0;
        for (String letter : lettersList){
            auxValue = table[key].get(letter);
            key = auxValue;
            if(auxValue == patternLength){
                return true;
            }
        }
        return false;
    }

    public int getLongestPrefix(List<String> pattern, List<String> subPattern, String plus){
        List<String> auxSubPattern = new ArrayList<>(subPattern);
        auxSubPattern.add(plus);
        List<String> auxComparator;

        int index = auxSubPattern.size() <= pattern.size() ?  0 :  1;;

        for (int i = index; i < auxSubPattern.size(); i++) {
            auxComparator = auxSubPattern.subList(i, auxSubPattern.size());
            if (auxComparator.equals(pattern.subList(0, auxComparator.size()))) {
                return auxComparator.size();
            }
        }

        return 0;
    }

    public void setInitialData(Map<String, Integer>[] table, List<String> values){
        int index = 0;
        for (String letter : values){
            table[index] = new HashMap<>();
            table[index].put(letter, index + 1);
            index++;
        }
        table[index] = new HashMap<>();
    }

    public void fillTable(Map<String, Integer>[] table, List<String> values, List<String> pattern){
        List<String> emptyList = new ArrayList<>();
        for (String value : values){
            if (table[0].get(value) == null){
                table[0].put(value, getLongestPrefix(pattern, emptyList, value));
            }
        }
        int index = 1;
        for (int i = 0; i < pattern.size(); i++){
            for (String value : values){
                if (table[index].get(value) == null){
                    table[index].put(value, getLongestPrefix(pattern, pattern.subList(0, i+1), value));
                }
            }
            index++;
        }
    }

    public List<String> splitString(String string) {
        //string = string.replaceAll(" ", "");
        String[] list = string.split("");
        return Arrays.asList(list);
    }

    public List<String> getLetters(List<String> string){
        Set<String> letters = new HashSet<>(string);
        return new ArrayList<>(letters);
    }


}
