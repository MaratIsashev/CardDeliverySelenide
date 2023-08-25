package ru.netology.cardDelivery;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import java.time.Duration;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryFormTest {

    @Test
    void testPositive(){

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("span[data-test-id=city] input").setValue("Новосибирск");
        $("span[data-test-id=name] input").setValue("Исашев Марат");
        $("span[data-test-id=phone] input").setValue("+79137940954");
        $("label[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).should(Condition.appear, Duration.ofSeconds(15));

    }

}
