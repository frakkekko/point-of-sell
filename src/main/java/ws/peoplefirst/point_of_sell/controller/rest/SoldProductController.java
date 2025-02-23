package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.dto.soldProduct.SoldProductResponseDTO;
import ws.peoplefirst.point_of_sell.service.SoldProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sold-products")
public class SoldProductController {

    private final SoldProductService soldProductService;

    public SoldProductController(SoldProductService soldProductService) {
        this.soldProductService = soldProductService;
    }

    @GetMapping
    public ResponseEntity<List<SoldProductResponseDTO>> getAll() {
        return new ResponseEntity<>(soldProductService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldProductResponseDTO> getSoldProductById(@PathVariable UUID id) {
        return new ResponseEntity<>(soldProductService.getById(id), HttpStatus.OK);
    }
}
