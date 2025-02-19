package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.DTO.price.PriceResponseDTO;
import ws.peoplefirst.point_of_sell.service.PriceService;

import java.util.List;
import java.util.UUID;

@RestController
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/prices")
    public ResponseEntity<List<PriceResponseDTO>> getAll() {
        return new ResponseEntity(priceService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<PriceResponseDTO> getPriceById(@PathVariable UUID id) {
        return new ResponseEntity(priceService.getById(id), HttpStatus.OK);
    }
}
