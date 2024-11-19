package fr.thomas.Filmtheque.Entity;

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
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_id", nullable = false)
    private Short id;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @ColumnDefault("current_timestamp()")
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}