package edu.hw4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class TasksTest {
    Tasks tasks;

    @BeforeEach
    void setUp() {
        tasks = new Tasks();
    }

    static private Arguments[] getAnimals() {
        return new Arguments[] {
            Arguments.of(List.of(
                new Animal("cat", Animal.Type.CAT, Animal.Gender.M, 5, 40, 3, false),
                new Animal("dog", Animal.Type.DOG, Animal.Gender.F, 4, 50, 5, false),
                new Animal("fish", Animal.Type.FISH, Animal.Gender.M, 1, 15, 1, false),
                new Animal("bird", Animal.Type.BIRD, Animal.Gender.F, 1, 10, 1, false),
                new Animal("spider", Animal.Type.SPIDER, Animal.Gender.M, 1, 3, 0, true)
            ))
        };
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldSortThemByHeight(Collection<Animal> animals) {
        List<Animal> animalsSortedByHeight = tasks.getSortedByHeight(animals);
        Assertions.assertThat(animalsSortedByHeight).isEqualTo(List.of(
            new Animal("spider", Animal.Type.SPIDER, Animal.Gender.M, 1, 3, 0, true),
            new Animal("bird", Animal.Type.BIRD, Animal.Gender.F, 1, 10, 1, false),
            new Animal("fish", Animal.Type.FISH, Animal.Gender.M, 1, 15, 1, false),
            new Animal("cat", Animal.Type.CAT, Animal.Gender.M, 5, 40, 3, false),
            new Animal("dog", Animal.Type.DOG, Animal.Gender.F, 4, 50, 5, false)
        ));
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnKHeaviestAnimals(Collection<Animal> animals) {
        Integer k = 2;
        List<Animal> kHeaviestAnimals = tasks.getKHeaviestAnimals(animals, k);
        Assertions.assertThat(kHeaviestAnimals).isEqualTo(List.of(
            new Animal("dog", Animal.Type.DOG, Animal.Gender.F, 4, 50, 5, false),
            new Animal("cat", Animal.Type.CAT, Animal.Gender.M, 5, 40, 3, false)
        ));
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnAnimalTypesCount(Collection<Animal> animals) {
        Map<Animal.Type, Integer> animalTypesCount = tasks.getAnimalTypesCount(animals);
        Assertions.assertThat(animalTypesCount).isEqualTo(
            new HashMap<Animal.Type, Integer>() {{
                put(Animal.Type.CAT, 1);
                put(Animal.Type.DOG, 1);
                put(Animal.Type.FISH, 1);
                put(Animal.Type.BIRD, 1);
                put(Animal.Type.SPIDER, 1);
            }}
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnLongestNameAnimal(Collection<Animal> animals) {
        Animal longestNameAnimal = tasks.getLongestNameAnimal(animals);
        Assertions.assertThat(longestNameAnimal).isEqualTo(
            new Animal("spider", Animal.Type.SPIDER, Animal.Gender.M, 1, 3, 0, true)
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnMostPopularGender(Collection<Animal> animals) {
        Animal.Gender mostPopularGender = tasks.getMostPopularGender(animals);
        Assertions.assertThat(mostPopularGender).isEqualTo(Animal.Gender.M);
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnHeaviestAnimal(Collection<Animal> animals) {
        Map<Animal.Type, Animal> heaviestAnimal = tasks.getHeaviestAnimals(animals);
        Assertions.assertThat(heaviestAnimal).isEqualTo(
            new HashMap<Animal.Type, Animal>() {{
                put(Animal.Type.CAT, new Animal("cat", Animal.Type.CAT, Animal.Gender.M, 5, 40, 3, false));
                put(Animal.Type.DOG, new Animal("dog", Animal.Type.DOG, Animal.Gender.F, 4, 50, 5, false));
                put(Animal.Type.FISH, new Animal("fish", Animal.Type.FISH, Animal.Gender.M, 1, 15, 1, false));
                put(Animal.Type.BIRD, new Animal("bird", Animal.Type.BIRD, Animal.Gender.F, 1, 10, 1, false));
                put(Animal.Type.SPIDER, new Animal("spider", Animal.Type.SPIDER, Animal.Gender.M, 1, 3, 0, true));
            }}
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnKOldestAnimal(Collection<Animal> animals) {
        Integer k = 2;
        Animal kOldestAnimal = tasks.getKOldestAnimal(animals, k);
        Assertions.assertThat(kOldestAnimal).isEqualTo(
            new Animal("dog", Animal.Type.DOG, Animal.Gender.F, 4, 50, 5, false)
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnHeaviestAnimalThatShorterThanK(Collection<Animal> animals) {
        Integer k = 50;
        Optional<Animal> heaviestAnimalThatShorterThanK = tasks.getHeaviestAnimalThatShorterThanK(animals, k);
        Assertions.assertThat(heaviestAnimalThatShorterThanK.get()).isEqualTo(
            new Animal("cat", Animal.Type.CAT, Animal.Gender.M, 5, 40, 3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnAllPawsCount(Collection<Animal> animals) {
        Integer allPawsCount = tasks.getAllPawsCount(animals);
        Assertions.assertThat(allPawsCount).isEqualTo(18);
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnAnimalsAgeNotEqualsToPawCount(Collection<Animal> animals) {
        List<Animal> animalsAgeNotEqualsToPawCount = tasks.getAnimalsAgeNotEqualsToPawCount(animals);
        Assertions.assertThat(animalsAgeNotEqualsToPawCount).isEqualTo(
            List.of(
                new Animal("cat", Animal.Type.CAT, Animal.Gender.M, 5, 40, 3, false),
                new Animal("fish", Animal.Type.FISH, Animal.Gender.M, 1, 15, 1, false),
                new Animal("bird", Animal.Type.BIRD, Animal.Gender.F, 1, 10, 1, false),
                new Animal("spider", Animal.Type.SPIDER, Animal.Gender.M, 1, 3, 0, true)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnBitingAnimalsHigherHundred(Collection<Animal> animals) {
        List<Animal> bitingAnimalsHigherHundred = tasks.getBitingAnimalsHigherHundred(animals);
        Assertions.assertThat(bitingAnimalsHigherHundred).isEqualTo(
            List.of()
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnCountOfAnimalsWeightLargerHeight(Collection<Animal> animals) {
        Integer countOfAnimalsWeightLargerHeight = tasks.getCountOfAnimalsWeightLargerHeight(animals);
        Assertions.assertThat(countOfAnimalsWeightLargerHeight).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnAnimalsNameConsistsOfAtLeastThreeWords(Collection<Animal> animals) {
        List<Animal> animalsNameConsistsOfAtLeastThreeWords = tasks.getAnimalsNameConsistsOfAtLeastThreeWords(animals);
        Assertions.assertThat(animalsNameConsistsOfAtLeastThreeWords).isEqualTo(
            List.of()
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnHasDogHeightLargerK(Collection<Animal> animals) {
        Boolean hasDogHeightLargerK = tasks.hasDogHeightLargerK(animals, 49);
        Assertions.assertThat(hasDogHeightLargerK).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnAnimalsOlderKUnderLTypesSummaryWeight(Collection<Animal> animals) {
        Integer k = 2;
        Integer l = 5;
        Map<Animal.Type, Integer> animalsOlderKUnderLTypesSummaryWeight = tasks.getAnimalsOlderKUnderLTypesSummaryWeight(animals, k, l);
        Assertions.assertThat(animalsOlderKUnderLTypesSummaryWeight).isEqualTo(
            new HashMap<Animal.Type, Integer>() {{
                put(Animal.Type.DOG, 5);
            }}
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnAnimalsSortedByTypeThenGenderThenName(Collection<Animal> animals) {
        List<Animal> animalsSortedByTypeThenGenderThenName = tasks.getAnimalsSortedByTypeThenGenderThenName(animals);
        Assertions.assertThat(animalsSortedByTypeThenGenderThenName).isEqualTo(
            List.of(
                new Animal("cat", Animal.Type.CAT, Animal.Gender.M, 5, 40, 3, false),
                new Animal("dog", Animal.Type.DOG, Animal.Gender.F, 4, 50, 5, false),
                new Animal("bird", Animal.Type.BIRD, Animal.Gender.F, 1, 10, 1, false),
                new Animal("fish", Animal.Type.FISH, Animal.Gender.M, 1, 15, 1, false),
                new Animal("spider", Animal.Type.SPIDER, Animal.Gender.M, 1, 3, 0, true)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getAnimals")
    void giveAnimalsShouldReturnGetHeaviestFish(Collection<Animal> animals) {
        List<Animal> newAnimals = List.of(
            new Animal("cat", Animal.Type.CAT, Animal.Gender.M, 5, 40, 3, false),
            new Animal("dog", Animal.Type.DOG, Animal.Gender.F, 4, 50, 5, false),
            new Animal("bird", Animal.Type.BIRD, Animal.Gender.F, 1, 10, 1, false),
            new Animal("fish", Animal.Type.FISH, Animal.Gender.M, 1, 15, 3, false),
            new Animal("spider", Animal.Type.SPIDER, Animal.Gender.M, 1, 3, 0, true)
        );
        Animal heaviestFish = tasks.getHeaviestFish(List.of((List) animals, newAnimals));
        Assertions.assertThat(heaviestFish).isEqualTo(
            new Animal("fish", Animal.Type.FISH, Animal.Gender.M, 1, 15, 3, false)
        );
    }
}
