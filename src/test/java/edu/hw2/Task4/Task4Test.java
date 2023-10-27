package edu.hw2.Task4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task4Test {
    @Test
    void callingInfoShouldReturnThisMethodInfo() {
        CallingInfo causingInfo = Task4.callingInfo();
        Assertions.assertThat(causingInfo.className() + '.' + causingInfo.methodName()).isEqualTo("Task4Test.callingInfoShouldReturnThisMethodInfo");
    }
}
