package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.DTO.stock.StockResponseDTO;
import ws.peoplefirst.point_of_sell.service.StockService;

import java.util.List;
import java.util.UUID;

@RestController
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<StockResponseDTO>> getAll() {
        return new ResponseEntity(stockService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<StockResponseDTO> getStockById(@PathVariable UUID id) {
        return new ResponseEntity(stockService.getById(id), HttpStatus.OK);
    }
}
