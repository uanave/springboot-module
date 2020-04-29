package academy.everyonecodes.tinybusiness.endpoint;

import academy.everyonecodes.tinybusiness.logic.ProductService;
import academy.everyonecodes.tinybusiness.logic.ShopService;
import academy.everyonecodes.tinybusiness.persistence.domain.Product;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ShopEndpoint {
    private final ShopService shopService;
    private final ProductService productService;

    public ShopEndpoint(ShopService shopService, ProductService productService) {
        this.shopService = shopService;
        this.productService = productService;
    }

    @PostMapping("/products")
    @Secured("ROLE_OWNER")
    Product postOne(@RequestBody Product product) {
        return productService.post(product);
    }

    @GetMapping("/products")
    List<Product> getAllWhenOpen() {
        if(shopService.isOpen()) {
            return productService.getNonPremium();
        }
        return productService.getEmpty();

    }

    @GetMapping("products/premium")
    @Secured("ROLE_PREMIUM")
    List<Product> getAllPremium() {
        if(shopService.isOpen()) {
           return productService.getAllPremium();
        }
        return productService.getEmpty();
    }

    @PutMapping("/shop/open")
    @Secured("ROLE_OWNER")
    String open() {
        return shopService.open();
    }

    @PutMapping("/shop/close")
    @Secured("ROLE_OWNER")
    String close() {
        return shopService.close();
    }
}
