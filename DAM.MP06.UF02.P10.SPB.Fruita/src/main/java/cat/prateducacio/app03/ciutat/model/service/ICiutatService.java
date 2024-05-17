package cat.prateducacio.app03.ciutat.model.service;

public interface ICiutatService {
    List<Ciutat> findAll();
    Ciutat findById(int id);
    Ciutat save(Ciutat ciutat);
    void delete(int id);
}
