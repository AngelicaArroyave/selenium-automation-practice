package pages;

public class HomePage extends BasePage {

    private String product = "//div[contains(@class,'gutter-default   sub_row_1-0-2')]";
    private String seleniumBook = "//img[@title='Selenium Ruby']";

    public HomePage() {
        super(driver);
    }
    
    public void navigateToHomePage() {
        navigateTo("https://practice.automationtesting.in/");
    }

    public void selectAProduct() {
        scrollIntoView(product);
        clickElement(seleniumBook);
    }
}
