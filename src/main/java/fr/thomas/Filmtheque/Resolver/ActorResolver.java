package fr.thomas.Filmtheque.Resolver;

import fr.thomas.Filmtheque.Entity.Actor;
import fr.thomas.Filmtheque.Repository.ActorRepository;
import fr.thomas.Filmtheque.Repository.FilmActorRepository;
import fr.thomas.Filmtheque.Repository.FilmRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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
    public List<Actor> getActors() {
        return actorRepository.findAll();
    }

    @QueryMapping
    public Actor getActor(@Argument Long id) {
        return actorRepository.findById(id).orElse(null);
    }



}
