package org.search.system.recognition;

import org.search.system.interfaces.Recognizer;
import org.search.system.models.Word;
import org.search.system.recognition.synonims.SynonymProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class TagsRecognizer implements Recognizer {
    /**
     * Recognizes all keywords form user request
     * @param request user request
     * @return list of {@link Word} which contains all keywords that are synonym to user request
     */
    @Override
    public ArrayList<Word> recognize(String request) {
        ArrayList<String> words = new ArrayList<>((Arrays.asList(request.split(",")))
                .stream()
                .parallel()
                .map(String::trim)
                .collect(Collectors.toList()));
        ArrayList<Word> keywords = new ArrayList<>();
        SynonymProvider synonymProvider = new SynonymProvider();
        keywords.addAll(words.stream().map(word -> new Word(word, synonymProvider.getSynonymsFromDB(word))).collect(Collectors.toList()));
        return keywords;
    }
}
