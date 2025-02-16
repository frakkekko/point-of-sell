package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.model.SelledProduct;
import ws.peoplefirst.point_of_sell.repository.SelledProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class SelledProductService {

    private final SelledProductRepository selledProductRepository;

    @Autowired
    public SelledProductService(SelledProductRepository selledProductRepository) {
        this.selledProductRepository = selledProductRepository;
    }

    public List<SelledProduct> getAll() {
        return selledProductRepository.findAll();
    }

    public void deleteById(UUID id) {
        selledProductRepository.deleteById(id);
    }
}
