package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.repository.SelledProductRepository;

@Service
public class SelledProductService {

    private final SelledProductRepository selledProductRepository;

    @Autowired
    public SelledProductService(SelledProductRepository selledProductRepository) {
        this.selledProductRepository = selledProductRepository;
    }
}
