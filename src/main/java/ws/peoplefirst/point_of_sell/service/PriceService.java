package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.model.Price;
import ws.peoplefirst.point_of_sell.repository.PriceRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAll() {
        return priceRepository.findAll();
    }

    public void deleteById(UUID id) {
        priceRepository.deleteById(id);
    }
}
