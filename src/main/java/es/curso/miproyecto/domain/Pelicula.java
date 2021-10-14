package es.curso.miproyecto.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Pelicula.
 */
@Entity
@Table(name = "pelicula")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "pelicula")
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    private Long id;

    @NotNull
    @Size(min = 4, max = 50)
    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "fecha_estreno")
    private Instant fechaEstreno;

    @Size(min = 20, max = 500)
    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "en_cines")
    private Boolean enCines;

    @OneToOne(mappedBy = "pelicula")
    @JsonIgnore
    private Estreno estreno;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Pelicula titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Instant getFechaEstreno() {
        return fechaEstreno;
    }

    public Pelicula fechaEstreno(Instant fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
        return this;
    }

    public void setFechaEstreno(Instant fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Pelicula descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean isEnCines() {
        return enCines;
    }

    public Pelicula enCines(Boolean enCines) {
        this.enCines = enCines;
        return this;
    }

    public void setEnCines(Boolean enCines) {
        this.enCines = enCines;
    }

    public Estreno getEstreno() {
        return estreno;
    }

    public Pelicula estreno(Estreno estreno) {
        this.estreno = estreno;
        return this;
    }

    public void setEstreno(Estreno estreno) {
        this.estreno = estreno;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pelicula)) {
            return false;
        }
        return id != null && id.equals(((Pelicula) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
            "id=" + getId() +
            ", titulo='" + getTitulo() + "'" +
            ", fechaEstreno='" + getFechaEstreno() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", enCines='" + isEnCines() + "'" +
            "}";
    }
}
