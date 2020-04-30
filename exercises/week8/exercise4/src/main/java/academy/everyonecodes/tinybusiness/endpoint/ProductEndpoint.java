package academy.everyonecodes.tinybusiness.endpoint;

import academy.everyonecodes.tinybusiness.logic.ProductService;
import academy.everyonecodes.tinybusiness.persistence.domain.Product;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {
    private final ProductService productService;

    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Secured("ROLE_OWNER")
    Product postOne(@RequestBody Product product) {
        return productService.post(product);
    }

    @GetMapping
    List<Product> getAllNonPremium() {
        return productService.getNonPremium();
    }

    @GetMapping("/premium")
    @Secured("ROLE_PREMIUM")
    List<Product> getAllPremium() {
        return productService.getAllPremium();
    }
}
