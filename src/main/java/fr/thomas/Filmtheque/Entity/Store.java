package fr.thomas.Filmtheque.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "store")
public class Store {
    @Id
    @Column(name = "store_id", nullable = false)
    private Byte id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private Staff managerStaff;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ColumnDefault("current_timestamp()")
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}