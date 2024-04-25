package ge.tbc.tbcacademy.pages.saucedemopages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {
    public ElementsCollection
            allInventoryItemImages = $$("img.inventory_item_img"),
            allInventoryItems = $$(".inventory_item");

    public SelenideElement
            burgerButton = $(".bm-burger-button"),
            logoutButton = $("#logout_sidebar_link");
}
