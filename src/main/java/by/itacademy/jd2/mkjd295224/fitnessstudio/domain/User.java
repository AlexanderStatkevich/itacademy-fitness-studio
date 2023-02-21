package by.itacademy.jd2.mkjd295224.fitnessstudio.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID uuid;
    private LocalDateTime dt_create;
    private LocalDateTime dt_update;
    private String mail;
    private String fio;
    private UserRole role;
    private UserStatus status;

    public User() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }

    public void setDt_create(LocalDateTime dt_create) {
        this.dt_create = dt_create;
    }

    public LocalDateTime getDt_update() {
        return dt_update;
    }

    public void setDt_update(LocalDateTime dt_update) {
        this.dt_update = dt_update;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uuid, user.uuid) && Objects.equals(dt_create, user.dt_create) && Objects.equals(dt_update, user.dt_update) && Objects.equals(mail, user.mail) && Objects.equals(fio, user.fio) && role == user.role && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, dt_create, dt_update, mail, fio, role, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", dt_create=" + dt_create +
                ", dt_update=" + dt_update +
                ", mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
