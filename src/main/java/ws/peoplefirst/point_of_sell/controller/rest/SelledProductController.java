package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.DTO.selledProduct.SelledProductResponseDTO;
import ws.peoplefirst.point_of_sell.service.SelledProductService;

import java.util.List;
import java.util.UUID;

@RestController
public class SelledProductController {

    private SelledProductService selledProductService;

    @Autowired
    public SelledProductController(SelledProductService selledProductService) {
        this.selledProductService = selledProductService;
    }

    @GetMapping("/selled-products")
    public ResponseEntity<List<SelledProductResponseDTO>> getAll() {
        return new ResponseEntity(selledProductService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/selled-product/{id}")
    public ResponseEntity<SelledProductResponseDTO> getSelledProductById(@PathVariable UUID id) {
        return new ResponseEntity(selledProductService.getById(id), HttpStatus.OK);
    }
}
