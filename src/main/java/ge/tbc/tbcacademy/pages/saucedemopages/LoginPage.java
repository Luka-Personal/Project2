package ge.tbc.tbcacademy.pages.saucedemopages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    public SelenideElement
            usernameField = $("#user-name"),
            passwordField = $("#password"),
            loginButton = $("#login-button"),
            errorMessage = $(byAttribute("data-test", "error")),
            errorMessageXIcon = $(".error-button");

    public ElementsCollection inputFieldXIcons = $$(".form_group svg");
}
