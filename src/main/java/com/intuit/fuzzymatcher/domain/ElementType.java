package com.intuit.fuzzymatcher.domain;


import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.function.PreProcessFunction;
import com.intuit.fuzzymatcher.function.TokenizerFunction;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.intuit.fuzzymatcher.domain.MatchType.EQUALITY;
import static com.intuit.fuzzymatcher.domain.MatchType.NEAREST_NEIGHBORS;
import static com.intuit.fuzzymatcher.function.PreProcessFunction.*;
import static com.intuit.fuzzymatcher.function.TokenizerFunction.*;
import static com.intuit.fuzzymatcher.function.TokenizerElo.eloSoundexEncodeTokenizer;

/**
 * Enum to define different types of Element.
 * This is used only to categorize the data, and apply functions at different stages of match.
 * The functions, can be overridden from Element class using the appropriate setters at the time of creation.
 */
public enum ElementType {
    NAME,
    TEXT,
    ADDRESS,
    EMAIL,
    PHONE,
    NUMBER,
    DATE,
    AGE,
    SERVER,
    ELO;


    protected Function getPreProcessFunction() {
        switch (this) {
            case NAME:
                return namePreprocessing();
            case TEXT:
                return removeSpecialChars();
            case ADDRESS:
                return addressPreprocessing();
            case EMAIL:
                return removeDomain();
            case PHONE:
                return usPhoneNormalization();
            case NUMBER:
            case AGE:
                return numberPreprocessing();
            case SERVER:
                return serverNormalization();
            /**
             * Aqui lo que practicamente hace es que cuando el caso es `ELO`, se llama al método `eloPreprocessing()`
             * Este método probablemente realiza un preprocesamiento específico para los valores de ELO
             */
            case ELO:
                return eloPreprocessing();
            default:
                return none();
        }
    }

    protected Function getTokenizerFunction() {
        switch (this) {
            case NAME:
                return wordSoundexEncodeTokenizer();
            case TEXT:
                return wordTokenizer();
            case ADDRESS:
                return wordSoundexEncodeTokenizer();
            case EMAIL:
                return triGramTokenizer();
            case PHONE:
                return decaGramTokenizer();
            case SERVER:
                return serveTokenizer();
            case ELO:
                return eloSoundexEncodeTokenizer();
            default:
                return valueTokenizer();
        }
    }

    protected MatchType getMatchType() {
        switch (this) {
            case NUMBER:
            case DATE:
            case AGE:
                return NEAREST_NEIGHBORS;
            default:
                return EQUALITY;
        }
    }
}