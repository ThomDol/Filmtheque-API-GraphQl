package fr.thomas.Filmtheque.Resolver;

import fr.thomas.Filmtheque.Entity.*;
import fr.thomas.Filmtheque.Repository.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Controller
public class FilmResolver {

    private final FilmRepository filmRepository;
    private final FilmActorRepository filmActorRepository;
    private final FilmCategoryRepository filmCategoryRepository;
    private final CategoryRepository categoryRepository;
    public final InventoryRepository inventoryRepository;
    public final StoreRepository storeRepository;


    @QueryMapping
    public List<Film> Films() {
        return filmRepository.findAll();
    }

    @QueryMapping
    public Film Film(@Argument Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Film> FilmsByCategory(@Argument Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        List<FilmCategory> filmCategories =  filmCategoryRepository.findByCategory(category);
        return filmCategories.stream().map(FilmCategory::getFilm).toList();
    }

    @QueryMapping
    public List<Film> FilmsByStore (@Argument Long id){
        Store store = storeRepository.findById(id).orElse(null);
        if(store == null) return null;
        List<Inventory> inventories = inventoryRepository.findByStore(store);
        return inventories.stream().map(Inventory::getFilm).toList();
    }

    // Résolveur pour le champ "actors" du type Film
    @SchemaMapping(typeName = "Film", field = "actors")
    public List<Actor> getActorsForFilm(Film film) {
        List<FilmActor> filmActors=filmActorRepository.findByFilm(film);
        List<Actor> actors = filmActors.stream().map(FilmActor::getActor).toList();
        return actors;
    }
}




