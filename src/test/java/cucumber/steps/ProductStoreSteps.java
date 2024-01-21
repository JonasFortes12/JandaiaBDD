package cucumber.steps;

import com.jandaiabdd.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;



@CucumberContextConfiguration
public class ProductStoreSteps {

    @Given("I have more than {int} products in my store")
    public void iHaveMoreThanProductsInMyStore(int productNumber) {

        ProductController productControl = new ProductController();

        assertTrue(
                "I have more than {int} productControl in my store",
                productControl.getAllProducts().size() > productNumber
                );
    }


    @And("One of these products is a CellPhone")
    public void oneOfTheseProductsIsACellPhone() {
        ProductController productControl = new ProductController();

        assertTrue(
                "One of these products is a CellPhone",
                productControl.getAllProducts().contains("CellPhone")
                //productControl.getAllProducts().stream().anyMatch(product -> product.equals("CellPhone")
        );

    }


    @Then("All product should be returned successfully")
    public void allProductShouldBeReturnedSuccessfully() {
        // Test Patters AAA (Arrange, Act, Assert)

        List<String> productsToBeVerified = new ArrayList<String>(
                List.of("mouse", "mousepad", "keyboard", "CellPhone", "notebook", "soundbox")
        );
        ProductController productControl = new ProductController();

        assertTrue(
                "All product should be returned successfully",
                productControl.getAllProducts().containsAll(productsToBeVerified)
        );
    }
}
