package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.soldProduct.SoldProductResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.SoldProductMapper;
import ws.peoplefirst.point_of_sell.repository.SoldProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class SoldProductService {

    private final SoldProductRepository soldProductRepository;

    @Autowired
    public SoldProductService(SoldProductRepository soldProductRepository) {
        this.soldProductRepository = soldProductRepository;
    }

    public List<SoldProductResponseDTO> getAll() {
        return soldProductRepository.findAll().stream().map(soldProduct -> SoldProductMapper.toResponseDTO(soldProduct)).toList();
    }

    public SoldProductResponseDTO getById(UUID id) {
        return SoldProductMapper.toResponseDTO(soldProductRepository.getReferenceById(id));
    }
}
