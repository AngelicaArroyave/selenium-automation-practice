package pages;

public class ProductPage extends BasePage {
    private String titleBook = "//h1[contains(@class,'product_title')]";
    private String sectionBookDescription = "//div[contains(@class,'woocommerce-tabs')]";
    private String descriptionBook = "//h2[text()='Product Description']";
    private String reviewsBookBtn = "//li[@class='reviews_tab']//a";
    private String reviewsBook = "//h2[text()='Reviews']";
    private String numberProducts = "//input[@name='quantity']";
    private String addBasketBtn = "//button[contains(@class,'single_add_to_cart_button')]";
    private String addedBasketMessage = "//div[@class='woocommerce-message']";
    private String priceProduct = "//span[contains(@class,'woocommerce-Price-amount')]";
    private String totalPrice = "//span[@class='amount']";
    private String viewProductBtn = "//a[contains(@class,'wc-forward')]";

    public ProductPage() {
        super(driver);
    }
    
    public void validateTitle() {
        validateEquals(titleBook, "Selenium Ruby");
    }

    public void validateDescription() {
        scrollIntoView(sectionBookDescription);
        validateEquals(descriptionBook, "Product Description");
    }

    public void validateViews() {
        scrollIntoView(sectionBookDescription);
        clickElement(reviewsBookBtn);
        validateEquals(reviewsBook, "Reviews");
    }

    public void addToBasket() {
        writeElement(numberProducts, "2");
        clickElement(addBasketBtn);
    }

    public void validateProductsBasket() {
        validateDisplayed(addedBasketMessage);
        validatePrice("2", priceProduct, totalPrice);
    }

    public void validateViewProductBasket() {
        clickElement(viewProductBtn);
    }
}