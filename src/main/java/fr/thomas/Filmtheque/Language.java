package fr.thomas.Filmtheque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "language")
public class Language {
    @Id
    @Column(name = "language_id", nullable = false)
    private Byte id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ColumnDefault("current_timestamp()")
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}