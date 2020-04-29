package academy.everyonecodes.tinybusiness.logic;

import academy.everyonecodes.tinybusiness.persistence.domain.Product;
import academy.everyonecodes.tinybusiness.persistence.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    @Test
    void post() {
        Product product = new Product("table", 25.5, false);
        when(productService.post(product)).thenReturn(product);
        productService.post(product);
        verify(productRepository).save(product);
    }

    @Test
    void getAllPremium() {
        when(productService.getAllPremium()).thenReturn(List.of(new Product("table", 25.5, true)));
        List<Product> products = productService.getAllPremium();
        List<Product> expected = List.of(new Product("table", 25.5, true));
        assertEquals(expected, products);
        verify(productRepository).findByIsPremium(true);
    }

    @Test
    void getNonPremium() {
        when(productService.getNonPremium()).thenReturn(List.of(new Product("table", 25.5, false)));
        List<Product> products = productService.getNonPremium();
        List<Product> expected = List.of(new Product("table", 25.5, false));
        assertEquals(expected, products);
        verify(productRepository).findByIsPremium(false);
    }

    @Test
    void getEmpty() {
        List<Product> products = productService.getEmpty();
        List<Product> expected = List.of();
        assertEquals(expected, products);
    }
}