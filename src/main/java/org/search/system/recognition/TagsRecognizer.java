package org.search.system.recognition;

import org.search.system.interfaces.Recognizer;
import org.search.system.recognition.synonims.SynonimProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TagsRecognizer implements Recognizer {
    @Override
    public List<String> recognize(String request) {
        ArrayList<String> words = new ArrayList<>((Arrays.asList(request.split(",")))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList()));
        ArrayList<String> keywords = new ArrayList<>();
        SynonimProvider synonimProvider = new SynonimProvider();
        for (String word : words) {
            keywords.addAll(synonimProvider.getSynonymsFromDB(word));
        }
        return keywords;
    }
}
