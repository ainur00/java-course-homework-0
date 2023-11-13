package edu.hw4;

public record Animal(
    String name,
    Type type,
    Gender gender,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Gender {
        M, F
    }

    private final static Byte CAT_DOG_PAWS_COUNT = 4;
    private final static Byte BIRD_PAWS_COUNT = 2;
    private final static Byte FISH_PAWS_COUNT = 0;
    private final static Byte SPIDER_DOG_PAWS_COUNT = 8;

    public int paws() {
        return switch (type) {
            case CAT, DOG -> CAT_DOG_PAWS_COUNT;
            case BIRD -> BIRD_PAWS_COUNT;
            case FISH -> FISH_PAWS_COUNT;
            case SPIDER -> SPIDER_DOG_PAWS_COUNT;
        };
    }
}
