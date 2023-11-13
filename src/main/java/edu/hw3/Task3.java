package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;

public class Task3 {
    public HashMap<Object, Long> getFrequencyDictionary(ArrayList<Object> objects) {
        HashMap<Object, Long> frequencyDictionary = new HashMap<Object, Long>();
        for (Object object : objects) {
            if (!frequencyDictionary.containsKey(object)) {
                frequencyDictionary.put(object, 0L);
            }
            frequencyDictionary.put(object, frequencyDictionary.get(object) + 1L);
        }
        return frequencyDictionary;
    }
}
