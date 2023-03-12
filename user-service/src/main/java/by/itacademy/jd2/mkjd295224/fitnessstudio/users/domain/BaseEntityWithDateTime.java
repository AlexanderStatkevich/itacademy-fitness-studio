package by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntityWithDateTime extends BaseEntity {

    @Column(name = "date_time_create")
    private LocalDateTime dateTimeCreate;
    @Version
    @Column(name = "date_time_update")
    private LocalDateTime dateTimeUpdate;

    public BaseEntityWithDateTime() {
    }

    public BaseEntityWithDateTime(UUID uuid, LocalDateTime dateTimeUpdate) {
        super(uuid);
        this.dateTimeUpdate = dateTimeUpdate;
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
