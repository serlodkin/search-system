/*
MIT License

Copyright (c) 2016-2017 Daniil Matkov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package org.search.system.recognition;

import org.search.system.interfaces.Recognizer;
import org.search.system.models.Word;
import org.search.system.recognition.synonims.SynonymProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


/*
 * Recognizes keywords for user request
 * implements {@link Recognizer}
 *
 * @author Daniil Matkov
 */
public class TagsRecognizer implements Recognizer {
    /*
     * Recognizes all keywords form user request
     * @param request user request
     * @return list of {@link Word} which contains all keywords that are synonym to user request
     */
    @Override
    public ArrayList<Word> recognize(String request) {
        ArrayList<String> words = new ArrayList<>(Arrays.stream(request.split(","))
                .parallel()
                .map(String::trim)
                .collect(Collectors.toList()));
        ArrayList<Word> keywords = new ArrayList<>();
        SynonymProvider synonymProvider = new SynonymProvider();
        keywords.addAll(words.stream().map(word -> new Word(word, synonymProvider.getSynonymsFromDB(word))).collect(Collectors.toList()));
        return keywords;
    }
}
