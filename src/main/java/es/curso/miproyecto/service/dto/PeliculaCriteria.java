package es.curso.miproyecto.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.InstantFilter;

/**
 * Criteria class for the {@link es.curso.miproyecto.domain.Pelicula} entity. This class is used
 * in {@link es.curso.miproyecto.web.rest.PeliculaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /peliculas?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PeliculaCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter titulo;

    private InstantFilter fechaEstreno;

    private StringFilter descripcion;

    private BooleanFilter enCines;

    private LongFilter estrenoId;

    public PeliculaCriteria(){
    }

    public PeliculaCriteria(PeliculaCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.titulo = other.titulo == null ? null : other.titulo.copy();
        this.fechaEstreno = other.fechaEstreno == null ? null : other.fechaEstreno.copy();
        this.descripcion = other.descripcion == null ? null : other.descripcion.copy();
        this.enCines = other.enCines == null ? null : other.enCines.copy();
        this.estrenoId = other.estrenoId == null ? null : other.estrenoId.copy();
    }

    @Override
    public PeliculaCriteria copy() {
        return new PeliculaCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getTitulo() {
        return titulo;
    }

    public void setTitulo(StringFilter titulo) {
        this.titulo = titulo;
    }

    public InstantFilter getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(InstantFilter fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public StringFilter getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(StringFilter descripcion) {
        this.descripcion = descripcion;
    }

    public BooleanFilter getEnCines() {
        return enCines;
    }

    public void setEnCines(BooleanFilter enCines) {
        this.enCines = enCines;
    }

    public LongFilter getEstrenoId() {
        return estrenoId;
    }

    public void setEstrenoId(LongFilter estrenoId) {
        this.estrenoId = estrenoId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PeliculaCriteria that = (PeliculaCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(titulo, that.titulo) &&
            Objects.equals(fechaEstreno, that.fechaEstreno) &&
            Objects.equals(descripcion, that.descripcion) &&
            Objects.equals(enCines, that.enCines) &&
            Objects.equals(estrenoId, that.estrenoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        titulo,
        fechaEstreno,
        descripcion,
        enCines,
        estrenoId
        );
    }

    @Override
    public String toString() {
        return "PeliculaCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (titulo != null ? "titulo=" + titulo + ", " : "") +
                (fechaEstreno != null ? "fechaEstreno=" + fechaEstreno + ", " : "") +
                (descripcion != null ? "descripcion=" + descripcion + ", " : "") +
                (enCines != null ? "enCines=" + enCines + ", " : "") +
                (estrenoId != null ? "estrenoId=" + estrenoId + ", " : "") +
            "}";
    }

}
