package es.curso.miproyecto.repository.search;
import es.curso.miproyecto.domain.Pelicula;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link Pelicula} entity.
 */
public interface PeliculaSearchRepository extends ElasticsearchRepository<Pelicula, Long> {
}
