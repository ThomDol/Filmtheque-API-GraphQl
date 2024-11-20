package fr.thomas.Filmtheque.Resolver;

import fr.thomas.Filmtheque.Entity.*;
import fr.thomas.Filmtheque.Repository.CategoryRepository;
import fr.thomas.Filmtheque.Repository.FilmActorRepository;
import fr.thomas.Filmtheque.Repository.FilmCategoryRepository;
import fr.thomas.Filmtheque.Repository.FilmRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class FilmResolver {

    private final FilmRepository filmRepository;
    private final FilmActorRepository filmActorRepository;
    private final FilmCategoryRepository filmCategoryRepository;
    private final CategoryRepository categoryRepository;

    public FilmResolver(FilmRepository filmRepository, FilmActorRepository filmActorRepository, FilmCategoryRepository filmCategoryRepository,CategoryRepository categoryRepository) {
        this.filmRepository = filmRepository;
        this.filmActorRepository = filmActorRepository;
        this.filmCategoryRepository = filmCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @QueryMapping
    public List<Film> films() {
        return filmRepository.findAll();
    }

    @QueryMapping
    public Film film(@Argument Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Film> filmsByCategory(@Argument String name) {
        Category category = categoryRepository.findByName(name);
        List<FilmCategory> filmCategories =  filmCategoryRepository.findByCategory(category);
        return filmCategories.stream().map(FilmCategory::getFilm).toList();
    }

    // Résolveur pour le champ "actors" du type Film
    @SchemaMapping(typeName = "Film", field = "actors")
    public List<Actor> getActorsForFilm(Film film) {
        List<FilmActor> filmActors=filmActorRepository.findByFilm(film);
        List<Actor> actors = filmActors.stream().map(FilmActor::getActor).toList();
        return actors;
    }
}




