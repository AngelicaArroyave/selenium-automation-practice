package pages;

public class PaymentPage extends BasePage {
    final String COUPON = "krishnasakinala";

    private String titlePage = "//h2[text()]";
    private String applyCoupon = "//input[@id='coupon_code']";
    private String applyCouponBtn = "//input[@name='apply_coupon']";
    private String deleteProduct = "//a[@title='Remove this item']";
    private String deleteMessage = "//p[@class='cart-empty']";
    private String numberProduct = "//input[@class='input-text qty text']";
    private String updateBasketBtn = "//input[@name='update_cart']";
    private String updatedMessage = "//div[@class='woocommerce-message']";
    private String totalPrice = "//td[@class='product-subtotal']//span";
    private String proceedToCheckoutBtn = "//div[@class='wc-proceed-to-checkout']//a";
    private String ourOrder = "//h3[@id='order_review_heading']";

    public PaymentPage() {
        super(driver);
    }
    
    public void validateViewProductBasket() {
        validateEquals(titlePage, "Basket Totals");
    }

    public void applyCouponInBasket() {
        writeElement(applyCoupon, COUPON);
        clickElement(applyCouponBtn);
    }

    public void deleteProduct() {
        clickElement(deleteProduct);
    }

    public void validateDeletedProduct() {
        validateEquals(deleteMessage, "Your basket is currently empty.");
    }

    public void increaseNumberProducts() {
        writeElement(numberProduct, "1");
        clickElement(updateBasketBtn);
    }

    public void validateIncreaseNumberProducts() {
        validateEquals(updatedMessage, "Basket updated.");
    }

    public void validateTotalPriceProducts() {
        validateTotalPrice(totalPrice);
    }

    public void validatePaymentGatewayPage() {
        clickElement(proceedToCheckoutBtn);
        scrollIntoView(ourOrder);
    }
}