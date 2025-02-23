package ws.peoplefirst.point_of_sell.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.dto.product.ProductResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.ProductMapper;
import ws.peoplefirst.point_of_sell.model.Product;
import ws.peoplefirst.point_of_sell.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll().stream().map(ProductMapper::toResponseDTO).toList();
    }

    public ProductResponseDTO getById(UUID id) {
        return ProductMapper.toResponseDTO(productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with id '%s' not found", id))));
    }
}
