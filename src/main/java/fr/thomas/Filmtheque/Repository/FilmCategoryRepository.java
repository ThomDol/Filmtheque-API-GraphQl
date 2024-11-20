package fr.thomas.Filmtheque.Repository;

import fr.thomas.Filmtheque.Entity.Category;
import fr.thomas.Filmtheque.Entity.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory,Long> {
    List<FilmCategory> findByCategory (Category category);
}
