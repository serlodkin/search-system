package org.search.system.recognition;

import org.search.system.interfaces.Recognizer;
import org.search.system.models.Word;
import org.search.system.recognition.synonims.SynonimProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class TagsRecognizer implements Recognizer {
    @Override
    public ArrayList<Word> recognize(String request) {
        ArrayList<String> words = new ArrayList<>((Arrays.asList(request.split(",")))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList()));
        ArrayList<Word> keywords = new ArrayList<>();
        SynonimProvider synonimProvider = new SynonimProvider();
        keywords.addAll(words.stream().map(word -> new Word(word, synonimProvider.getSynonymsFromDB(word))).collect(Collectors.toList()));
        return keywords;
    }
}
