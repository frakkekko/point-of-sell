package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.selledProduct.SelledProductResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.SelledProductMapper;
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

    public List<SelledProductResponseDTO> getAll() {
        return selledProductRepository.findAll().stream().map(selledProduct -> SelledProductMapper.toResponseDTO(selledProduct)).toList();
    }

    public SelledProductResponseDTO getById(UUID id) {
        return SelledProductMapper.toResponseDTO(selledProductRepository.getReferenceById(id));
    }
}
