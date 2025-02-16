package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.model.BarCode;
import ws.peoplefirst.point_of_sell.service.BarCodeService;

import java.util.List;

@RestController
public class BarCodeController {

    private BarCodeService barCodeService;

    @Autowired
    public BarCodeController(BarCodeService barCodeService) {
        this.barCodeService = barCodeService;
    }

    @GetMapping("/barcodes")
    public ResponseEntity getAll() {
        List<BarCode> barCodes = barCodeService.getAll();
        return new ResponseEntity(barCodes, HttpStatus.OK);
    }
}
