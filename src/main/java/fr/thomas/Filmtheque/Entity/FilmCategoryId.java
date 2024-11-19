package fr.thomas.Filmtheque.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class FilmCategoryId implements java.io.Serializable {
    private static final long serialVersionUID = -3806615613224977697L;
    @Column(name = "film_id", nullable = false)
    private Short filmId;

    @Column(name = "category_id", nullable = false)
    private Byte categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmCategoryId entity = (FilmCategoryId) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.categoryId, entity.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }

}