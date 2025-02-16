package ws.peoplefirst.point_of_sell.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.peoplefirst.point_of_sell.model.SelledProduct;
import ws.peoplefirst.point_of_sell.service.SelledProductService;

import java.util.List;

@RestController
public class SelledProductController {

    private SelledProductService selledProductService;

    @Autowired
    public SelledProductController(SelledProductService selledProductService) {
        this.selledProductService = selledProductService;
    }

    @GetMapping("/selled-products")
    public ResponseEntity getAll() {
        List<SelledProduct> selledProducts = selledProductService.getAll();
        return new ResponseEntity(selledProducts, HttpStatus.OK);
    }
}
