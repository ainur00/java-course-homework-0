package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private final static Map<Character, Character> ENCRYPTOR = new HashMap<Character, Character>() {
        {
            put('a', 'z');
            put('b', 'y');
            put('c', 'x');
            put('d', 'w');
            put('e', 'v');
            put('f', 'u');
            put('g', 't');
            put('h', 's');
            put('i', 'r');
            put('j', 'q');
            put('k', 'p');
            put('l', 'o');
            put('m', 'n');
            put('n', 'm');
            put('o', 'l');
            put('p', 'k');
            put('q', 'j');
            put('r', 'i');
            put('s', 'h');
            put('t', 'g');
            put('u', 'f');
            put('v', 'e');
            put('w', 'd');
            put('x', 'c');
            put('y', 'b');
            put('z', 'a');
        }
    };

    private Character getEncrypted(Character c) {
        if (ENCRYPTOR.containsKey(c)) {
            return ENCRYPTOR.get(c);
        }
        if (ENCRYPTOR.containsKey(Character.toLowerCase(c))) {
            return Character.toUpperCase(ENCRYPTOR.get(Character.toLowerCase(c)));
        }
        return c;
    }

    public String getAtbash(String line) {
        char[] encryptedChars = new char[line.length()];
        for (int i = 0; i < line.length(); ++i) {
            encryptedChars[i] = getEncrypted(line.charAt(i));
        }
        return new String(encryptedChars);
    }
}
