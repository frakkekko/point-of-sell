package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.dto.barcode.BarcodeResponseDTO;
import ws.peoplefirst.point_of_sell.service.BarCodeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/barcodes")
public class BarCodeController {

    private final BarCodeService barCodeService;

    @Autowired
    public BarCodeController(BarCodeService barCodeService) {
        this.barCodeService = barCodeService;
    }

    @GetMapping
    public ResponseEntity<List<BarcodeResponseDTO>> getAll() {
        return new ResponseEntity<>(barCodeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarcodeResponseDTO> getBarcodeById(@PathVariable UUID id) {
        return new ResponseEntity<>(barCodeService.getById(id), HttpStatus.OK);
    }
}
