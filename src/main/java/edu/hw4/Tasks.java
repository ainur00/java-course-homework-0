package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {
    public List<Animal> getSortedByHeight(Collection<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    public List<Animal> getKHeaviestAnimals(Collection<Animal> animals, Integer k) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    public Map<Animal.Type, Integer> getAnimalTypesCount(Collection<Animal> animals) {
        return animals
            .stream()
            .collect(Collectors.toMap(Animal::type, animal -> 1, (oldValue, newValue) -> oldValue + 1));
    }

    public Animal getLongestNameAnimal(Collection<Animal> animals) {
        return animals
            .stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .get();
    }

    public Animal.Gender getMostPopularGender(Collection<Animal> animals) {
        return animals
            .stream()
            .collect(Collectors.groupingBy(Animal::gender, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .get()
            .getKey();
    }

    public Map<Animal.Type, Animal> getHeaviestAnimals(Collection<Animal> animals) {
        return animals
            .stream()
            .collect(Collectors
                .toMap(Animal::type,
                    animal -> animal,
                    (oldValue, newValue) -> newValue.weight() > oldValue.weight() ? newValue : oldValue));
    }

    public Animal getKOldestAnimal(Collection<Animal> animals, Integer k) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .get();
    }

    public Optional<Animal> getHeaviestAnimalThatShorterThanK(Collection<Animal> animals, Integer k) {
        return animals
            .stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public Integer getAllPawsCount(Collection<Animal> animals) {
        return animals
            .stream()
            .mapToInt(Animal::paws)
            .reduce(Integer::sum)
            .getAsInt();
    }

    public List<Animal> getAnimalsAgeNotEqualsToPawCount(Collection<Animal> animals) {
        return animals
            .stream()
            .filter(animal -> animal.paws() != animal.age())
            .collect(Collectors.toList());
    }

    private final static Byte HUNDRED = 100;

    public List<Animal> getBitingAnimalsHigherHundred(Collection<Animal> animals) {
        return animals
            .stream()
            .filter(animal -> (animal.bites()) && (animal.height() > HUNDRED))
            .collect(Collectors.toList());
    }

    public Integer getCountOfAnimalsWeightLargerHeight(Collection<Animal> animals) {
        return ((int) animals
            .stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());
    }

    public List<Animal> getAnimalsNameConsistsOfAtLeastThreeWords(Collection<Animal> animals) {
        return animals
            .stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }

    public Boolean hasDogHeightLargerK(Collection<Animal> animals, Integer k) {
        return animals
            .stream()
            .anyMatch(animal -> (animal.type() == Animal.Type.DOG) && (animal.height() > k));
    }

    public Map<Animal.Type, Integer> getAnimalsOlderKUnderLTypesSummaryWeight(
        Collection<Animal> animals, Integer k, Integer l
    ) {
        return animals
            .stream()
            .filter(animal -> (animal.age() > k) && (animal.age() < l))
            .collect(Collectors.toMap(Animal::type, Animal::weight, Integer::sum));
    }

    public List<Animal> getAnimalsSortedByTypeThenGenderThenName(Collection<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Comparator.comparing(Animal::gender))
                .thenComparing(Comparator.comparing(Animal::name)))
            .collect(Collectors.toList());
    }

    public Boolean isSpidersBiteMoreOftenThanDogs(Collection<Animal> animals) {
        Map<Animal.Type, Long> bitingSpidersAndDogsCount = animals
            .stream()
            .filter(animal -> ((animal.type() == Animal.Type.DOG) || (animal.type() == Animal.Type.SPIDER))
                    && (animal.bites()))
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
        if (!bitingSpidersAndDogsCount.containsKey(Animal.Type.SPIDER)) {
            return false;
        }
        if (!bitingSpidersAndDogsCount.containsKey(Animal.Type.DOG)) {
            return true;
        }
        return bitingSpidersAndDogsCount.get(Animal.Type.SPIDER) > bitingSpidersAndDogsCount.get(Animal.Type.DOG);
    }

    private Stream<Animal> getGeneralAnimalStream(List<List<Animal>> animalsLists) {
        if (animalsLists.size() == 1) {
            return animalsLists.get(0).stream();
        }
        Stream<Animal> generalAnimalStream = Stream.concat(animalsLists.get(0).stream(), animalsLists.get(1).stream());
        for (int i = 2; i < animalsLists.size(); ++i) {
            generalAnimalStream = Stream.concat(generalAnimalStream, animalsLists.get(i).stream());
        }
        return generalAnimalStream;
    }

    public Animal getHeaviestFish(List<List<Animal>> animalsLists) {
        if (animalsLists == null || animalsLists.isEmpty()) {
            return null;
        }
        Stream<Animal> generalAnimalStream = getGeneralAnimalStream(animalsLists);
        return generalAnimalStream
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .get();
    }
}
