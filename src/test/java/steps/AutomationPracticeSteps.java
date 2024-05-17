package steps;

import io.cucumber.java.en.*;
import pages.CheckoutPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductPage;

public class AutomationPracticeSteps {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    PaymentPage paymentPage = new PaymentPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("I Navigate to Automation Practice")
    public void iNavigateToHomePage() {
        homePage.navigateToHomePage();
    }

    @When("I select a product")
    public void iSelectProduct() {
        homePage.selectAProduct();
    }

    @Then("Validate the book title")
    public void validateTitle() {
        productPage.validateTitle();
    }

    @Then("Validate the existing description of the book")
    public void validateDescription() {
        productPage.validateDescription();
    }

    @Then("Validate the existing reviews of the book")
    public void validateReviews() {
        productPage.validateViews();
    }

    @When("I add products to basket")
    public void addToBasketProduct() {
        productPage.addToBasket();
    }

    @Then("Validate products in basket")
    public void validateProductsInBasket() {
        productPage.validateProductsBasket();
    }

    @Then("Validate view products option in basket")
    public void validateViewProductsInBasket() {
        productPage.validateViewProductBasket();
        paymentPage.validateViewProductBasket();
    }

    @When("I enter the coupon")
    public void applyCouponInBasket() {
        paymentPage.applyCouponInBasket();
    }

    @When("Delete product from basket")
    public void deleteProductFromBasket() {
        paymentPage.deleteProduct();
    }

    @Then("Validate product deleted from basket")
    public void validateDeletedProductFromBasket() {
        paymentPage.validateDeletedProduct();
    }

    @When("Increase number of products")
    public void increaseProductsToBasket() {
        paymentPage.increaseNumberProducts();
    }

    @Then("Validate increase number of products")
    public void validateIncreaseProductsToBasket() {
        paymentPage.validateIncreaseNumberProducts();
    }

    @Then("Validate the total price of the products")
    public void validatePriceFromBasket() {
        paymentPage.validateTotalPriceProducts();
    }

    @Then("Validate payment gateway page")
    public void validatePaymentGatewayPage() {
        paymentPage.validatePaymentGatewayPage();
    }

    @When("I enter the information payment")
    public void enterInformation() {
        checkoutPage.enterInformationPayment();
    }
}
