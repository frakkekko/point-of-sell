package ws.peoplefirst.point_of_sell.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.dto.soldProduct.SoldProductResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.SoldProductMapper;
import ws.peoplefirst.point_of_sell.repository.SoldProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class SoldProductService {

    private final SoldProductRepository soldProductRepository;

    public SoldProductService(SoldProductRepository soldProductRepository) {
        this.soldProductRepository = soldProductRepository;
    }

    public List<SoldProductResponseDTO> getAll() {
        return soldProductRepository.findAll().stream().map(SoldProductMapper::toResponseDTO).toList();
    }

    public SoldProductResponseDTO getById(UUID id) {
        return SoldProductMapper.toResponseDTO(soldProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Sold product with id '%s' not found", id))));
    }
}
