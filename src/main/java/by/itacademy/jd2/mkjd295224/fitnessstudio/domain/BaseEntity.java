package by.itacademy.jd2.mkjd295224.fitnessstudio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "uuid", unique = true)
    private UUID uuid;

    public BaseEntity() {
    }

    public BaseEntity(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
