package by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntityWithDateTime {

    @Id
    @Column(name = "uuid", updatable = false)
    private UUID uuid;
    @Column(name = "date_time_create")
    private LocalDateTime dateTimeCreate;
    @Version
    @Column(name = "date_time_update")
    private LocalDateTime dateTimeUpdate;

    public BaseEntityWithDateTime() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public LocalDateTime getDateTimeUpdate() {
        return dateTimeUpdate;
    }

    public void setDateTimeUpdate(LocalDateTime dateTimeUpdate) {
        this.dateTimeUpdate = dateTimeUpdate;
    }

    @PrePersist
    void initDateCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.dateTimeCreate = now;
        this.dateTimeUpdate = now;
    }

    @PreUpdate
    void updateDateTimeUpdate() {
        this.dateTimeUpdate = LocalDateTime.now();
    }
}
