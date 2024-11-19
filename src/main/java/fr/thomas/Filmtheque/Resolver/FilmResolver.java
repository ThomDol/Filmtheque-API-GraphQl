package fr.thomas.Filmtheque.Resolver;

import fr.thomas.Filmtheque.Entity.Actor;
import fr.thomas.Filmtheque.Entity.Film;
import fr.thomas.Filmtheque.Entity.FilmActor;
import fr.thomas.Filmtheque.Repository.FilmActorRepository;
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

    public FilmResolver(FilmRepository filmRepository, FilmActorRepository filmActorRepository) {
        this.filmRepository = filmRepository;
        this.filmActorRepository = filmActorRepository;
    }

    @QueryMapping
    public List<Film> films() {
        return filmRepository.findAll();
    }

    @QueryMapping
    public Film film(@Argument Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    // Résolveur pour le champ "actors" du type Film
    @SchemaMapping(typeName = "Film", field = "actors")
    public List<Actor> getActorsForFilm(Film film) {
        List<FilmActor> filmActors=filmActorRepository.findByFilm(film);
        List<Actor> actors = filmActors.stream().map(FilmActor::getActor).toList();
        return actors;
    }
}




