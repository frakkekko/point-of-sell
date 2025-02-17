package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.model.Product;
import ws.peoplefirst.point_of_sell.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity getAll() {
        List<Product> products = productService.getAll();
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping("/product")
    public void add(@RequestBody Product product) {
        productService.add(product);
    }
}
