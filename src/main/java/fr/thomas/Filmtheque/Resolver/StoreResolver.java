package fr.thomas.Filmtheque.Resolver;


import fr.thomas.Filmtheque.Entity.Film;
import fr.thomas.Filmtheque.Entity.Inventory;
import fr.thomas.Filmtheque.Entity.Store;
import fr.thomas.Filmtheque.Repository.FilmRepository;
import fr.thomas.Filmtheque.Repository.InventoryRepository;
import fr.thomas.Filmtheque.Repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Controller
public class StoreResolver {
    public final FilmRepository filmRepository;
    public final StoreRepository storeRepository;
    public final InventoryRepository inventoryRepository;

    @QueryMapping
    public List<Store> StoreGettingFilm (@Argument Long idFilm){
        Film film = filmRepository.findById(idFilm).orElse(null);
        List<Inventory> inventories = inventoryRepository.findByFilm(film);
        return inventories.stream().map(Inventory::getStore).toList();
    }
}
