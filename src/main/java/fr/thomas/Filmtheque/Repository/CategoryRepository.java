package fr.thomas.Filmtheque.Repository;

import fr.thomas.Filmtheque.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
