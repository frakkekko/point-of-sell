package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.dto.stock.StockResponseDTO;
import ws.peoplefirst.point_of_sell.service.StockService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> getAll() {
        return new ResponseEntity<>(stockService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponseDTO> getStockById(@PathVariable UUID id) {
        return new ResponseEntity<>(stockService.getById(id), HttpStatus.OK);
    }
}
