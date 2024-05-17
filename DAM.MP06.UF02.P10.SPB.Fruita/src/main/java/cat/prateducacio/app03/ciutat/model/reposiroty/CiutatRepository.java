package cat.prateducacio.app03.ciutat.model.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.prateducacio.app03.ciutat.model.domain.Ciutat;

@Repository
public interface CiutatRepository extends JpaRepository<Ciutat, Integer> {
    // Aquí puedes agregar métodos personalizados para realizar consultas específicas,
    // por ejemplo, buscar ciudades por nombre o prefijo telefónico, aunque estos métodos no son necesarios para operaciones CRUD básicas.
}
