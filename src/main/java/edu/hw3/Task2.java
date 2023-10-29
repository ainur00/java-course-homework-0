package edu.hw3;

import java.util.ArrayList;

public class Task2 {
    public ArrayList<String> getClusteredBrackets(String bracketsSequence) {
        if (bracketsSequence.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> clusteredBrackets = new ArrayList<String>();
        int anotherClusterEndIndex = 0;
        while (anotherClusterEndIndex != bracketsSequence.length()) {
            int anotherClusterStartIndex = anotherClusterEndIndex;
            anotherClusterEndIndex = getClusterEndIndex(bracketsSequence, anotherClusterStartIndex);
            if (anotherClusterEndIndex == -1) {
                break;
            }
            clusteredBrackets.add(bracketsSequence.substring(anotherClusterStartIndex, anotherClusterEndIndex));
        }
        return clusteredBrackets;
    }

    private int getClusterEndIndex(String bracketsSequence, int anotherClusterStartIndex) {
        int anotherClusterLength = 1;
        int clusterDepth = bracketsSequence.charAt(0) == '(' ? 1 : -1;
        while ((clusterDepth != 0) && (anotherClusterStartIndex + anotherClusterLength < bracketsSequence.length())) {
            clusterDepth += (bracketsSequence.charAt(anotherClusterStartIndex + anotherClusterLength) == '(') ? 1 : -1;
            ++anotherClusterLength;
        }
        if (clusterDepth != 0) {
            return -1;
        }
        return anotherClusterStartIndex + anotherClusterLength;
    }
}
