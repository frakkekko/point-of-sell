package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.DTO.receipt.ReceiptResponseDTO;
import ws.peoplefirst.point_of_sell.mapper.ReceiptMapper;
import ws.peoplefirst.point_of_sell.repository.ReceiptRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public List<ReceiptResponseDTO> getAll() {
        return receiptRepository.findAll().stream().map(receipt -> ReceiptMapper.toResponseDTO(receipt)).toList();
    }

    public ReceiptResponseDTO getById(UUID id) {
        return ReceiptMapper.toResponseDTO(receiptRepository.getReferenceById(id));
    }
}
