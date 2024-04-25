package ge.tbc.tbcacademy.steps.saucedemosteps;
import ge.tbc.tbcacademy.pages.saucedemopages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.*;
import static ge.tbc.tbcacademy.data.constants.SauceDemoConstants.*;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Inputs username: '{0}'")
    public LoginPageSteps fillUsernameField(String username) {
        loginPage.usernameField.sendKeys(username);
        return this;
    }
    @Step("Inputs password: '{0}'")
    public LoginPageSteps fillPasswordField(String password) {
        loginPage.passwordField.sendKeys(password);
        return this;
    }
    @Step("Clicks login button")
    public LoginPageSteps clickLoginButton() {
        loginPage.loginButton.click();
        return this;
    }
    @Step("Checks that error message appears and is correct")
    public LoginPageSteps checkErrorMessage() {
        loginPage.errorMessage.shouldBe(visible).shouldHave(exactText(LOCKED_USER_ERROR_MESSAGE));
        return this;
    }
    @Step("Checks that after failed login red 'X' icon is visible in input fields")
    public LoginPageSteps checkInputFieldXIconsAreVisible() {
        loginPage.inputFieldXIcons.shouldBe(allMatch(INPUT_FIELD_X_ICON_VISIBILITY_MESSAGE_ASSERTION, WebElement::isDisplayed));
        return this;
    }
    @Step("Checks that after failed login red 'X' icon is visible in error message")
    public void checkErrorMessageXIconIsVisible() {
        loginPage.errorMessageXIcon.shouldBe(visible);
    }
    @Step("Checks that username input is empty")
    public LoginPageSteps checkUsernameFieldEmpty() {
        loginPage.usernameField.shouldBe(empty);
        return this;
    }
    @Step("Checks that password input is empty")
    public void checkPasswordFieldEmpty() {
        loginPage.passwordField.shouldBe(empty);
    }
}
