package fr.thomas.Filmtheque.Repository;

import fr.thomas.Filmtheque.Entity.Film;
import fr.thomas.Filmtheque.Entity.Inventory;
import fr.thomas.Filmtheque.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByStore(Store store);
    List<Inventory> findByFilm(Film film);
}
