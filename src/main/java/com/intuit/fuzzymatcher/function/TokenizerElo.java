package com.intuit.fuzzymatcher.function;

import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.Token;
import com.intuit.fuzzymatcher.exception.MatchException;
import com.intuit.fuzzymatcher.util.Utils;
import org.apache.commons.codec.language.Soundex;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class TokenizerElo {

    private static final Soundex soundex = new Soundex();

    /*
     * Este método devuelve una función que toma un `Element` como entrada y devuelve
     *  un `Stream` de `Token`. Cada `Token` contiene el valor preprocesado del `Element`.
     */
    public static Function<Element, Stream<Token>> valueTokenizer() {
        return (element -> Stream.of(new Token(element.getPreProcessedValue(), element)));
    }

    /*
     * Este método devuelve una función que toma un `Element<String>` como entrada y divide su valor 
     * preprocesado en palabras. Cada palabra se convierte en un `Token<String>`.
     */
    public static Function<Element<String>, Stream<Token<String>>> wordTokenizer() {
        return (element) -> Arrays.stream(element.getPreProcessedValue().split("\\s+"))
                .map(token -> new Token<String>(token, element));
    }
    /*
     * Este método devuelve una función que toma un `Element<String>` como entrada y divide 
     * su valor preprocesado en palabras. Cada palabra se codifica usando Soundex, a menos que sea numérica. Cada palabra 
     * codificada se convierte en un `Token<String>`.
     */

    public static Function<Element<String>, Stream<Token<String>>> eloSoundexEncodeTokenizer() {
        return (element) -> Arrays.stream(element.getPreProcessedElo().toString().split("\\s+"))
                .map(val -> {
                    String code = val;
                    if (!Utils.isNumeric(val)) {
                        code = soundex.encode(val);
                        if (code.equals("")) {
                            code = val;
                        }
                    }
                    // System.out.println(val +"->" + code);
                    return code;
                }).map(token -> new Token<String>(token, element));
    }

    /*Este método devuelve una función que toma un `Element<String>` como entrada y divide 
    su valor preprocesado en trigramas. Cada trigrama se convierte en un `Token<String>`. */

    public static Function<Element<String>, Stream<Token<String>>> triGramTokenizer() {
        return (element) -> getNGramTokens(3, element);
    }

    /*Este método devuelve una función que toma un `Element<String>` como entrada y divide su valor 
    preprocesado en decagramas. Cada decagrama se convierte en un `Token<String>`. */
    public static Function<Element<String>, Stream<Token<String>>> decaGramTokenizer() {
        return (element) -> getNGramTokens(10, element);
    }
    /*Este método toma un tamaño y un `Element` como entrada y divide el valor preprocesado del 
    `Element` en n-gramas del tamaño dado. Cada n-grama se convierte en un `Token<String>`. */
    public static Stream<Token<String>> getNGramTokens(int size, Element element) {
        Object elementValue = element.getPreProcessedValue();
        String elementValueStr;
        if (elementValue instanceof String) {
            elementValueStr = (String) elementValue;
        } else {
            throw new MatchException("Unsupported data type");
        }
        return Utils.getNGrams(elementValueStr, size).map(str -> new Token<String>(str, element));

    }
    /*
     *Este método toma una serie de tokenizadores como entrada y devuelve una función que aplica todos estos tokenizadores
     *  a un `Element<String>`. El resultado es un `Stream` de `Token<String>` que contiene los tokens de todos los tokenizadores.
     */
    public static Function<Element<String>, Stream<Token<String>>> chainTokenizers(Function<Element<String>, Stream<Token<String>>>... tokenizers) {
        return element -> Arrays.stream(tokenizers).flatMap(fun -> fun.apply(element));
    }
}
