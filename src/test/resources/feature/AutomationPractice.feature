Feature: Navigate to page Automation Practice Site
    View products to buy

Background: I am in the Automation Practice Web
    Given I Navigate to Automation Practice
    When I select a product

@Title
Scenario: Validate the images in Arrivals should navigate
    Then Validate the book title

@Description
Scenario: Validate the images in Arrivals should navigate and view the description
    Then Validate the existing description of the book

@Review
Scenario: Validate the images in Arrivals should navigate and view the reviews
    Then Validate the existing reviews of the book

@AddBasket
Scenario: Add basket and validate products
    When I add products to basket
    Then Validate products in basket

@ViewBasket
Scenario: Add to basket and view basket
    When I add products to basket
    Then Validate products in basket
    And Validate view products option in basket

@ApplyCoupon
Scenario: Add to basket, view product in basket and apply coupon
    When I add products to basket
    Then Validate products in basket
    And Validate view products option in basket
    When I enter the coupon

@DeleteProduct
Scenario: Add to basket, view product in basket and delete product from basket
    When I add products to basket
    Then Validate products in basket
    And Validate view products option in basket
    When Delete product from basket
    Then Validate product deleted from basket

@IncreaseProduct
Scenario: Add to basket, view product in basket and increase number of products
    When I add products to basket
    Then Validate products in basket
    And Validate view products option in basket
    When Increase number of products
    Then Validate increase number of products

# Presenta problemas la validación de los precios, no se guarda correctamente el precio
# esperado, obtenido en una validación anterior en 'Validate products in basket'
@ValidatePrice
Scenario: Add to basket, view product in basket and validate total price in payment page
    When I add products to basket
    Then Validate products in basket
    And Validate view products option in basket
    And Validate the total price of the products

@PaymentGateway
Scenario: Add to basket, view product in basket and go to the payment gateway page
    When I add products to basket
    Then Validate products in basket
    And Validate view products option in basket
    Then Validate payment gateway page

@EnterInformation
Scenario: Add to basket, view product in basket, go to the payment gateway page and I enter the information for payment
    When I add products to basket
    Then Validate products in basket
    And Validate view products option in basket
    When I enter the information payment