package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.model.Receipt;
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

    public List<Receipt> getAll() {
        return receiptRepository.findAll();
    }

    public void deleteById(UUID id) {
        receiptRepository.deleteById(id);
    }
}
