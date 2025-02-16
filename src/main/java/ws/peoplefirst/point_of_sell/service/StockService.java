package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.model.Stock;
import ws.peoplefirst.point_of_sell.repository.StockRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    public void deleteById(UUID id) {
        stockRepository.deleteById(id);
    }
}
