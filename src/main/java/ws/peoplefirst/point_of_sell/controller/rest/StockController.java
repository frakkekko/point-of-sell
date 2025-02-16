package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.model.Stock;
import ws.peoplefirst.point_of_sell.service.StockService;

import java.util.List;

@RestController
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public ResponseEntity getAll() {
        List<Stock> stocks = stockService.getAll();
        return new ResponseEntity(stocks, HttpStatus.OK);
    }
}
