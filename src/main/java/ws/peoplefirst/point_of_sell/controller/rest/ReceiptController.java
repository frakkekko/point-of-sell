package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.model.Receipt;
import ws.peoplefirst.point_of_sell.service.ReceiptService;

import java.util.List;

@RestController
public class ReceiptController {

    private ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/receipts")
    public ResponseEntity getAll() {
        List<Receipt> receipts = receiptService.getAll();
        return new ResponseEntity(receipts, HttpStatus.OK);
    }
}
