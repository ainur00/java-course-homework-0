package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class Task1Test {
    private Task1 task1;

    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    @ParameterizedTest
    @CsvSource({
        "Hello world!, Svool dliow!",
        "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler, Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
    })
    void giveLineShouldEncrypt(String line, String correctEncryptedLine) {
        String encryptedLine = task1.getAtbash(line);
        Assertions.assertThat(encryptedLine).isEqualTo(correctEncryptedLine);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/1`!*-+", "", "   "})
    void giveNotEncryptedLineShouldNotEncrypt(String line) {
        String encryptedLine = task1.getAtbash(line);
        Assertions.assertThat(encryptedLine).isEqualTo(line);
    }
}
