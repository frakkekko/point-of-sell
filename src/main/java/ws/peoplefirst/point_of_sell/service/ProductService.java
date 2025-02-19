package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.product.ProductResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.ProductMapper;
import ws.peoplefirst.point_of_sell.model.Product;
import ws.peoplefirst.point_of_sell.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll().stream().map(product -> ProductMapper.toResponseDTO(product)).toList();
    }

    public ProductResponseDTO getById(UUID id) {
        return ProductMapper.toResponseDTO(productRepository.getReferenceById(id));
    }
}
