package ru.netology.cardDelivery;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardDeliveryFormTest {

    @Test
    void testPositive(){
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 1);
        Date deliveryDate = calendar.getTime();
        
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("span[data-test-id=city] input").setValue("Новосибирск");
        //$("span[data-test-id=date] input").clear();
        //$("span[data-test-id=date] input").setValue("1");
        //Selenide.actions("span[data-test-id=date] input").keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
        //$("span[data-test-id=date] input").setValue("1");
        $("span[data-test-id=date] input").setValue(String.valueOf(deliveryDate));
        $("span[data-test-id=name] input").setValue("Исашев Марат");
        $("span[data-test-id=phone] input").setValue("+79137940954");
        $("label[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).should(Condition.appear, Duration.ofSeconds(15));

    }

}
