package fr.thomas.Filmtheque.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "film_text")
public class FilmText {
    @Id
    @Column(name = "film_id", nullable = false)
    private Short id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

}