package cucumber.steps;

import com.jandaiabdd.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;

public class AddProductsSteps {
    ProductController productControl = new ProductController();
    String newProductToAdd = "Personality Bottle";

    @Given("The store already has registered products")
    public void theStoreAlreadyHasRegisteredProducts() {
        assertFalse(
                "The store already has registered products",
                productControl.getAllProducts().isEmpty()
        );
    }

    @And("The store has fewer than {int} products")
    public void theStoreHasFewerThanProducts(int qtdProducts) {
        assertTrue(
                String.format("The store has fewer than %d products", qtdProducts),
                productControl.getProductCount() < qtdProducts
        );
    }

    @And("The product does not exist in the store")
    public void theProductDoesNotExistInTheStore() {
        assertFalse(
                "The product does not exist in the store",
                productControl.isProductRegistered(newProductToAdd)
        );
    }

    @When("The user is going to add a product to the store")
    public void theUserIsGoingToAddAProductToTheStore() {
        productControl.AddRegisteredProduct(newProductToAdd);
    }

    @Then("The product must be added successfully")
    public void theProductMustBeAddedSuccessfully() {
        assertTrue(
                "The product must be added successfully",
                productControl.isProductRegistered(newProductToAdd)
        );
    }


}
