package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Task4Test {
    @ParameterizedTest
    @CsvSource({
        "2, II",
        "12, XII",
        "16, XVI",
        "3888, MMMDCCCLXXXVIII",
        "999, CMXCIX"
    })
    void giveNumShouldConvertToRoman(Integer num, String numRoman) {
        Task4 task4 = new Task4();
        String numConvertedToRoman = task4.getConvertedToRoman(num);
        Assertions.assertThat(numConvertedToRoman).isEqualTo(numRoman);
    }
}
