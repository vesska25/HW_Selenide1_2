package com.vesska;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideTests1_2 {


    @Test
    @DisplayName("Selenide test with hover")
    void checkSolutionsPage() {

        step("open GitHub", () -> {
            open("https://github.com/");
        });

        step("hover on Solutions", () -> {
            $(withText("Solutions")).hover();
        });

        step("click on Enterprise", () -> {
            $(withText("Enterprise")).click();
        });

        step("check text on main page 'Build like the best'", () -> {
            $(".application-main ").shouldHave(Condition.text("Build like the best"));
        });
    }

    @Test
    void dragAndDropTest() {

        step("Open 'The Internet website'", () -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });

        step("Move A to B", () -> {
            //actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300, 200).release().perform();
            $("#column-a").dragAndDropTo("#column-b");
        });

        step("check that column A is in ex position of column B", () -> {
            $("#column-b").shouldHave(Condition.text("A"));
        });
    }
}
