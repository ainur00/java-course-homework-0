package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;

public class Task5 {
    private Boolean hasSurname(String contact) {
        return contact.indexOf(' ') != -1;
    }

    private String flip(String contact) {
        return contact
            .substring(contact.indexOf(' ') + 1)
            .concat(" ")
            .concat(contact.substring(0, contact.indexOf(' ')));
    }

    private void formatContacts(ArrayList<String> contacts) {
        for (int i = 0; i < contacts.size(); ++i) {
            if (hasSurname(contacts.get(i))) {
                contacts.set(i, flip(contacts.get(i)));
            }
        }
    }

    private void parseContacts(ArrayList<String> contacts, Boolean isASC) {
        formatContacts(contacts);
        contacts.sort(isASC ? Comparator.naturalOrder() : Comparator.reverseOrder());
        formatContacts(contacts);
    }

    public ArrayList<Object> getParsedContacts(ArrayList<String> contacts, Boolean isASC) {
        if (contacts == null || contacts.isEmpty()) {
            return new ArrayList<Object>();
        }
        ArrayList<String> contactsCopy = (ArrayList<String>) contacts.clone();
        parseContacts(contactsCopy, isASC);
        return new ArrayList<Object>(contactsCopy);
    }
}
