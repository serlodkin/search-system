package org.search.system.interfaces;

import org.search.system.models.Word;

import java.util.ArrayList;

public interface Recognizer {
    ArrayList<Word> recognize(String request);
}
