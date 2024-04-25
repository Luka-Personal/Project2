package ge.tbc.tbcacademy.saucedemo;
import ge.tbc.tbcacademy.configs.BaseSelenideConfig;
import ge.tbc.tbcacademy.data.steps.DatabaseSteps;
import ge.tbc.tbcacademy.data.model.User;
import ge.tbc.tbcacademy.steps.saucedemosteps.InventoryPageSteps;
import ge.tbc.tbcacademy.steps.saucedemosteps.LoginPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.tbcacademy.data.constants.SauceDemoConstants.*;

@Epic("Saucedemo.com Functionality Tests")
@Test(groups = "SauceDemoLogin")
public class LoginTests extends BaseSelenideConfig {
    DatabaseSteps databaseSteps;
    LoginPageSteps loginPageSteps;
    InventoryPageSteps inventoryPageSteps;

    @BeforeClass(alwaysRun = true)
    public void setUpSteps() {
        databaseSteps = new DatabaseSteps();
        loginPageSteps = new LoginPageSteps();
        inventoryPageSteps= new InventoryPageSteps();
    }
    @BeforeMethod(alwaysRun = true)
    public void openURL() {
        open(SAUCE_DEMO_URL);
        System.out.println("CONFLICT MAKER");
        System.out.println("CONFLICT");
    }

    @Test(priority = 1, description = "Checks standard user login functionality")
    @Feature("Standard user login")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Standard user, logs into account and sees offered products")
    @Description("This test opens saucedemo.com, verifies that a user can log in successfully" +
            " and view the available product images on the inventory page.")
    public void successfulLoginTest() {
        databaseSteps
                .getUserFromDb(STANDARD_USER_ID);
        User user = databaseSteps.getCurrentUser();
        loginPageSteps
                .fillUsernameField(user.getUserName())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();
        inventoryPageSteps
                .checkAllImagesAreVisible()
                .checkAllImageAmount()
                .checkAllImagesAreUnique();
    }
    @Test(priority = 2, description = "Checks locked user login functionality")
    @Feature("Locked out user login")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Locked out user, tries to log into account and sees that (suprised face) its locked ")
    @Description("This test opens saucedemo.com, tries to login in with locked account, after failing to do so" +
            "checks that correct error message is displayed and all 'X' icons are visible")
    public void bannedUserLoginTest() {
        databaseSteps
                .getUserFromDb(LOCKED_USER_ID);
        User user = databaseSteps.getCurrentUser();
        loginPageSteps
                .fillUsernameField(user.getUserName())
                .fillPasswordField(user.getPassword())
                .clickLoginButton()
                .checkErrorMessage()
                .checkInputFieldXIconsAreVisible()
                .checkErrorMessageXIconIsVisible();
    }
    @Test(priority = 3, description = "Checks problematic user login functionality")
    @Feature("Problematic user Login")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Problematic user, tries to log into account and sees that inventory images are loaded incorrectly")
    @Description("This test opens saucedemo.com, verifies that user can log in successfully, and makes sure that" +
            "all inventory images are loaded correctly")
    public void problematicLoginTest() {
        databaseSteps
                .getUserFromDb(PROBLEM_USER_ID);
        User user = databaseSteps.getCurrentUser();
        loginPageSteps
                .fillUsernameField(user.getUserName())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();
        inventoryPageSteps
                .checkAllImagesAreVisible()
                .checkAllImageAmount()
                .checkAllImagesAreUnique();
    }
    @Test(priority = 4, description = "Checks logging out functionality")
    @Feature("Logging out")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Any user, clicks on burger menu and tries to log out of account")
    @Description("This test opens saucedemo.com, logs in using any correct account, after that clicks on burger menu" +
            "and tries to log out")
    public void logOutTest() {
        databaseSteps
                .getUserFromDb(STANDARD_USER_ID);
        User user = databaseSteps.getCurrentUser();
        loginPageSteps
                .fillUsernameField(user.getUserName())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();
        inventoryPageSteps
                .clickBurgerMenu()
                .clickLogoutButton();
        loginPageSteps
                .checkUsernameFieldEmpty()
                .checkPasswordFieldEmpty();
    }
}
