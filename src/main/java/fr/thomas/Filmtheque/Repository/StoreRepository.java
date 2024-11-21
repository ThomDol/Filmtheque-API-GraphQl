package fr.thomas.Filmtheque.Repository;

import fr.thomas.Filmtheque.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
