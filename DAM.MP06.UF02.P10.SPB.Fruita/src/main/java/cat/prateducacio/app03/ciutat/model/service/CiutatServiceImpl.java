package cat.prateducacio.app03.ciutat.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import cat.prateducacio.app03.ciutat.model.domain.Ciutat;
import cat.prateducacio.app03.ciutat.model.repository.CiutatRepository;

@Service
public class CiutatServiceImpl implements ICiutatService {

    @Autowired
    private CiutatRepository ciutatRepository;

    @Override
    public List<Ciutat> findAll() {
        return ciutatRepository.findAll();
    }

    @Override
    public Ciutat findById(int id) {
        return ciutatRepository.findById(id).orElse(null);
    }

    @Override
    public Ciutat save(Ciutat ciutat) {
        return ciutatRepository.save(ciutat);
    }

    @Override
    public void delete(int id) {
        ciutatRepository.deleteById(id);
    }
}
