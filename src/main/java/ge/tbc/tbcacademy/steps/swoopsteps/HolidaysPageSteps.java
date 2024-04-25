package ge.tbc.tbcacademy.steps.swoopsteps;
import ge.tbc.tbcacademy.pages.swooppages.HolidaysPage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.CollectionCondition.allMatch;
import static ge.tbc.tbcacademy.data.constants.SwoopConstants.HOLIDAY_OFFER_PRICE_FILTER_ASSERTION;
import static ge.tbc.tbcacademy.util.HelperFunctions.getNumbersFromMixedString;

public class HolidaysPageSteps {
    HolidaysPage holidaysPage = new HolidaysPage();

    @Step("Verifies that prices of all holiday offers are between '{0}' and '{1}'")
    public void validateElementsPriceRange(int minPrice, int maxPrice) {
        holidaysPage.offersPrices.should(allMatch(String.format(HOLIDAY_OFFER_PRICE_FILTER_ASSERTION, minPrice, maxPrice), offer -> {
            int price = getNumbersFromMixedString(offer.getText());
            return price >= minPrice && price <= maxPrice;
        }));
    }
}
