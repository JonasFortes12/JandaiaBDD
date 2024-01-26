package cucumber.steps;

import com.jandaiabdd.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertEquals;


public class DeleteProductStore {
    ProductController productControl = new ProductController();
    int initialCountProducts = productControl.getProductCount();

    @Given("The store already has registered many products")
    public void theStoreAlreadyHasRegisteredManyProducts() {
        assertTrue(
                "The store already has registered many products",
                productControl.getProductCount() > 5
        );
    }

    @And("The product {string} is registered in the store")
    public void theProductIsRegisteredInTheStore(String product) {
        assertTrue(
                String.format("The product %s is registered in the store", product),
                productControl.isProductRegistered(product)
        );
    }

    @When("The user deletes the product {string} from the store")
    public void theUserDeletesTheProductFromTheStore(String product) {
        productControl.deleteProduct(product);
    }

    @Then("The product {string} should be removed from the store")
    public void theProductShouldBeRemovedFromTheStore(String removedProduct) {
        assertFalse(
                String.format("The product %s should be removed from the store", removedProduct),
                productControl.isProductRegistered(removedProduct)
        );
    }

    @And("The store should have three less product")
    public void theStoreShouldHaveThreeLessProduct() {

        //Why 3 fewer products instead of 1 less product ?
        assertEquals(
                "The store should have three less product",
                productControl.getProductCount(),
                initialCountProducts - 3
        );
    }
}
