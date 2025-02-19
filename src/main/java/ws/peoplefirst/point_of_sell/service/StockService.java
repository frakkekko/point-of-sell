package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.stock.StockResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.StockMapper;
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

    public List<StockResponseDTO> getAll() {
        return stockRepository.findAll().stream().map(stock -> StockMapper.toResponseDTO(stock)).toList();
    }

    public void deleteById(UUID id) {
        stockRepository.deleteById(id);
    }
}
