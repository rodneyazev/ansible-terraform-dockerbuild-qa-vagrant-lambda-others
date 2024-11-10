

import org.junit.Test;

import br.product.app.Product;
import br.product.app.ProductService;

public class ProductServiceTest {
	
	ProductService productService = new ProductService();

	@Test
    public void addProductNotNull() {
        Product product_1 = new Product(1,"Golden Earring", 7.5);
        productService.addProduct(product_1);
    }
    @Test
    public void addProductNull() {
        Product product_2 = new Product(0, null, 0);
        productService.addProduct(product_2);
    }

}
