package pages;

public class CheckoutPage extends BasePage {
    private String proceedToCheckoutBtn = "//div[@class='wc-proceed-to-checkout']//a";
    private String firstName = "//input[@id='billing_first_name']";
    private String lastName = "//input[@id='billing_last_name']";
    private String email = "//input[@id='billing_email']";
    private String phone = "//input[@id='billing_phone']";
    private String address = "//input[@id='billing_address_1']";
    private String city = "//input[@id='billing_city']";
    private String zipCode = "//input[@id='billing_postcode']";

    public CheckoutPage() {
        super(driver);
    }
    
    public void enterInformationPayment() {
        clickElement(proceedToCheckoutBtn);
        writeElement(firstName, "lorem");
        writeElement(lastName, "ipsum");
        writeElement(email, "loremipsum@gmail.com");
        writeElement(phone, "3253427548");
        writeElement(address, "Nulla sed odio condimentum");
        writeElement(city, "Praesent");
        writeElement(zipCode, "123");
    }
}
