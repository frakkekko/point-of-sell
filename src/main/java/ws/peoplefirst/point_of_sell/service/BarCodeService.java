package ws.peoplefirst.point_of_sell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.peoplefirst.point_of_sell.repository.BarCodeRepository;

@Service
public class BarCodeService {

    private final BarCodeRepository barCodeRepository;

    @Autowired
    public BarCodeService(BarCodeRepository barCodeRepository) {
        this.barCodeRepository = barCodeRepository;
    }
}
