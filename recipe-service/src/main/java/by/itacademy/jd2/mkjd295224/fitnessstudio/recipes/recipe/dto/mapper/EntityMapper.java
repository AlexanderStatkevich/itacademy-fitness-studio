package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;

import java.util.UUID;

@Mapper
public abstract class EntityMapper {

    @PersistenceContext
    private EntityManager entityManager;

    public <T extends BaseEntity> T getEntity(UUID id, @TargetType Class<T> clazz) {
        return entityManager.getReference(clazz, id);
    }

    public <T extends BaseEntity> UUID getId(T entity) {
        return entity.getUuid();
    }
}
