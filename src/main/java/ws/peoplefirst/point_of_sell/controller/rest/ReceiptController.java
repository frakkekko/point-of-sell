package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.peoplefirst.point_of_sell.dto.receipt.ReceiptRequestDTO;
import ws.peoplefirst.point_of_sell.dto.receipt.ReceiptResponseDTO;
import ws.peoplefirst.point_of_sell.service.ReceiptService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public ResponseEntity<List<ReceiptResponseDTO>> getAll() {
        return new ResponseEntity<>(receiptService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptResponseDTO> getReceiptById(@PathVariable UUID id) {
        return new ResponseEntity<>(receiptService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReceiptResponseDTO> createNewReceipt(@RequestBody ReceiptRequestDTO receiptRequestDTO) {
        return new ResponseEntity<>(receiptService.createNewReceipt(receiptRequestDTO),  HttpStatus.CREATED);
    }
}
