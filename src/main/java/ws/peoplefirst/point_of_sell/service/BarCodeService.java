package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.model.BarCode;
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

    public List<BarCode> getAll() {
        return barCodeRepository.findAll();
    }

    public void deleteById(UUID id) {
        barCodeRepository.deleteById(id);
    }
}
