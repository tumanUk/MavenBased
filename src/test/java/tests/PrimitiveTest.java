package tests;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitiveTest {
    @Step
    @Test
    public void sumTest(){
        Assertions.assertEquals(100,10+90);
    }
}