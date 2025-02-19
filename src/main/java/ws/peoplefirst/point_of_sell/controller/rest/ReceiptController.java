package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.DTO.receipt.ReceiptResponseDTO;
import ws.peoplefirst.point_of_sell.service.ReceiptService;

import java.util.List;
import java.util.UUID;

@RestController
public class ReceiptController {

    private ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/receipts")
    public ResponseEntity<List<ReceiptResponseDTO>> getAll() {
        return new ResponseEntity(receiptService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/receipt/{id}")
    public ResponseEntity<ReceiptResponseDTO> getReceiptById(@PathVariable UUID id) {
        return new ResponseEntity(receiptService.getById(id), HttpStatus.OK);
    }
}
