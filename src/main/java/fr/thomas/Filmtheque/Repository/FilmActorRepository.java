package fr.thomas.Filmtheque.Repository;

import fr.thomas.Filmtheque.Entity.Film;
import fr.thomas.Filmtheque.Entity.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor,Long> {
    List<FilmActor> findByFilm (Film film);
}
