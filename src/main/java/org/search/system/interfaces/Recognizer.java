package org.search.system.interfaces;

import java.util.List;

public interface Recognizer {
    List<String> recognize(String request);
}
