package model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@MappedSuperclass
abstract class BaseEntity extends PanacheEntityBase {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "CHAR(36) NOT NULL")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    protected BaseEntity() {
        this.id = UUID.randomUUID();
    }
}
