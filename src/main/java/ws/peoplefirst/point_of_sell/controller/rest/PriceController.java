package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.model.Price;
import ws.peoplefirst.point_of_sell.service.PriceService;

import java.util.List;

@RestController
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/prices")
    public ResponseEntity getAll() {
        List<Price> prices = priceService.getAll();
        return new ResponseEntity(prices, HttpStatus.OK);
    }
}
