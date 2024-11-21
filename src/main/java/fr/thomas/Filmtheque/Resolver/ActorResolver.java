package fr.thomas.Filmtheque.Resolver;

import fr.thomas.Filmtheque.Entity.Actor;
import fr.thomas.Filmtheque.Entity.Film;
import fr.thomas.Filmtheque.Entity.FilmActor;
import fr.thomas.Filmtheque.Repository.ActorRepository;
import fr.thomas.Filmtheque.Repository.FilmActorRepository;
import fr.thomas.Filmtheque.Repository.FilmRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@Getter @Setter
public class ActorResolver {
    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;
    private final FilmActorRepository filmActorRepository;

    @QueryMapping
    public List<Actor> Actors() {
        return actorRepository.findAll();
    }

    @QueryMapping
    public Actor Actor(@Argument Long id) {
        return actorRepository.findById(id).orElse(null);
    }



    @SchemaMapping(typeName = "Actor",field="films")
    public List<Film>  getFilmsByActor(Actor actor) {
        List<FilmActor> filmActors = filmActorRepository.findByActor(actor);
        List<Film> films = filmActors.stream().map(FilmActor::getFilm).toList();
        return films;
    }
}
