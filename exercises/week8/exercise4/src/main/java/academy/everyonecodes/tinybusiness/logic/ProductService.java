package academy.everyonecodes.tinybusiness.logic;

import academy.everyonecodes.tinybusiness.persistence.domain.Product;
import academy.everyonecodes.tinybusiness.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ShopService shopService;

    public ProductService(ProductRepository productRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.shopService = shopService;
    }

    public Product post(Product product) {
        productRepository.save(product);
        return product;
    }

    public List<Product> getAllPremium() {
        if (shopService.isOpen()) {
            return productRepository.findByIsPremium(true);
        }
        return getEmpty();
    }

    public List<Product> getNonPremium() {
        if (!shopService.isOpen()) {
            return productRepository.findByIsPremium(false);
        }
        return getEmpty();
    }

    public List<Product> getEmpty() {
        return new ArrayList<>();
    }
}
