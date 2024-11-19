package fr.thomas.Filmtheque.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    private Short id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ColumnDefault("1")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @ColumnDefault("current_timestamp()")
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}