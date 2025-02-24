package ws.peoplefirst.point_of_sell.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.dto.price.PriceResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.PriceMapper;
import ws.peoplefirst.point_of_sell.repository.PriceRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<PriceResponseDTO> getAll() {
        return priceRepository.findAll().stream().map(PriceMapper::toResponseDTO).toList();
    }

    public PriceResponseDTO getById(UUID id) {
        return PriceMapper.toResponseDTO(priceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Price with id '%s' not found", id))));
    }
}
