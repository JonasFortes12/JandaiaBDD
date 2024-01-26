package cucumber.steps;

import com.jandaiabdd.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;

public class UpdateProductSteps {
    ProductController productControl = new ProductController();

    @Given("The store already has registered any products")
    public void theStoreAlreadyHasRegisteredAnyProducts() {
        assertFalse(
                "The store already has registered any products",
                productControl.getAllProducts().isEmpty()
        );
    }

    @And("The product {string} was registered in the store")
    public void theProductWasRegisteredInTheStore(String newProduct) {
        productControl.AddRegisteredProduct(newProduct);
    }

    @When("The user updates the product {string} to {string} in the store")
    public void theUserUpdatesTheProductToInTheStore(String oldProduct, String updatedProduct) {
        productControl.updateProduct(oldProduct, updatedProduct);
    }

    @Then("The product {string} should be in the store")
    public void theProductShouldBeInTheStore(String product) {
        assertTrue(
                String.format("The product %s should be in the store", product),
                productControl.isProductRegistered(product)
        );
    }

    @And("The product {string} should no longer be in the store")
    public void theProductShouldNoLongerBeInTheStore(String oldProduct) {
        assertFalse(
                String.format("The product %s should no longer be in the store", oldProduct),
                productControl.isProductRegistered(oldProduct)
        );
    }
}
