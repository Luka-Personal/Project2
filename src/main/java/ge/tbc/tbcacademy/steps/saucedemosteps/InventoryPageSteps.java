package ge.tbc.tbcacademy.steps.saucedemosteps;
import ge.tbc.tbcacademy.pages.saucedemopages.InventoryPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import java.util.HashSet;
import java.util.Set;
import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.CollectionCondition.size;
import static ge.tbc.tbcacademy.data.constants.SauceDemoConstants.*;

public class InventoryPageSteps {
    InventoryPage inventoryPage = new InventoryPage();

    @Step("Checks that all items in inventory page have images which are unique")
    public void checkAllImagesAreUnique() {
        Set<String> srcValues = new HashSet<>();
        inventoryPage.allInventoryItemImages.shouldBe(
                allMatch(IMAGE_UNIQUENESS_ASSERTION, image-> srcValues.add(image.getAttribute(SRC_TAG)))
        );
    }
    @Step("Checks that all images in inventory page are visible")
    public InventoryPageSteps checkAllImagesAreVisible() {
        inventoryPage.allInventoryItemImages.shouldBe(
                allMatch(IMAGE_VISIBILITY_ASSERTION, WebElement::isDisplayed)
        );
        return this;
    }
    @Step("Checks that each item in inventory page has image")
    public InventoryPageSteps checkAllImageAmount() {
        inventoryPage.allInventoryItemImages.shouldBe(
                size(inventoryPage.allInventoryItems.size())
        );
        return this;
    }
    @Step("Clicks on burger menu")
    public InventoryPageSteps clickBurgerMenu() {
        inventoryPage.burgerButton.click();
        return this;
    }
    @Step("Clicks the logout button")
    public void clickLogoutButton() {
        inventoryPage.logoutButton.click();
    }
}
