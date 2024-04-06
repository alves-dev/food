package model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.ZonedDateTime;
import java.util.UUID;

@MappedSuperclass
abstract class FoodBaseEntity extends BaseEntity {

    @Column(name = "person_id", nullable = false, columnDefinition = "CHAR(36) NOT NULL")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID personId;

    @Column(name = "datetime", nullable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private ZonedDateTime datetime;

    protected FoodBaseEntity() {
    }

    protected FoodBaseEntity(UUID personId, ZonedDateTime datetime) {
        this.personId = personId;
        this.datetime = datetime;
    }
}
