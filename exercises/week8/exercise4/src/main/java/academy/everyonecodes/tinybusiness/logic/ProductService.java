package academy.everyonecodes.tinybusiness.logic;

import academy.everyonecodes.tinybusiness.persistence.domain.Product;
import academy.everyonecodes.tinybusiness.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product post(Product product) {
        productRepository.save(product);
        return product;
    }

    public List<Product> getAllPremium() {
        return productRepository.findByIsPremium(true);
    }

    public List<Product> getNonPremium() {
        return productRepository.findByIsPremium(false);
    }

    public List<Product> getEmpty() {
        return new ArrayList<>();
    }
}
