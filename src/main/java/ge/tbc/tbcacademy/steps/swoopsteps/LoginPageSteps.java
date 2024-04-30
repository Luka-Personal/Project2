package ge.tbc.tbcacademy.steps.swoopsteps;
import ge.tbc.tbcacademy.pages.swooppages.LoginPage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.back;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    @Step("Verifies that login page is displayed")
    public LoginPageSteps verifyLoginPageRedirect() {
        loginPage.loginText.shouldBe(visible);
        loginPage.loginPasswordInput.shouldBe(visible);
        return this;
    }
    @Step("Navigates back one page to 'nightClubOffersPage'")
    public void goBackOnePage() {
        back();
    }
}
