package fr.thomas.Filmtheque.Repository;

import fr.thomas.Filmtheque.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmRepository extends JpaRepository <Film,Long> {
}
