package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.dto.barcode.BarcodeResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.BarCodeMapper;
import ws.peoplefirst.point_of_sell.repository.BarCodeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BarCodeService {

    private final BarCodeRepository barCodeRepository;

    @Autowired
    public BarCodeService(BarCodeRepository barCodeRepository) {
        this.barCodeRepository = barCodeRepository;
    }

    public List<BarcodeResponseDTO> getAll() {
        return barCodeRepository.findAll().stream().map(BarCodeMapper::toResponseDTO).toList();
    }

    public BarcodeResponseDTO getById(UUID id) {
        return BarCodeMapper.toResponseDTO(barCodeRepository.getReferenceById(id));
    }
}
