package ws.peoplefirst.point_of_sell.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.dto.stock.StockResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.StockMapper;
import ws.peoplefirst.point_of_sell.repository.StockRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<StockResponseDTO> getAll() {
        return stockRepository.findAll().stream().map(StockMapper::toResponseDTO).toList();
    }

    public StockResponseDTO getById(UUID id) {
        return StockMapper.toResponseDTO(stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Stock with id '%s' not found", id))));
    }
}
