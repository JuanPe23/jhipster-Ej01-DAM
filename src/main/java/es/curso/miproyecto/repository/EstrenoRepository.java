package es.curso.miproyecto.repository;
import es.curso.miproyecto.domain.Estreno;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Estreno entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EstrenoRepository extends JpaRepository<Estreno, Long> {

}
