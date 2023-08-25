package ru.netology.cardDelivery;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryFormTest {

    private String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    void testPositive() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("span[data-test-id=city] input").setValue("Новосибирск");
        String currentDate = generateDate(5, "dd.MM.yyyy");
        $("span[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("span[data-test-id=date] input").setValue(currentDate);
        $("span[data-test-id=name] input").setValue("Исашев Марат");
        $("span[data-test-id=phone] input").setValue("+79137940954");
        $("label[data-test-id=agreement]").click();
        $(withText("button.button")).click();
        $(withText("Успешно!")).should(Condition.appear, Duration.ofSeconds(15));

    }

}
