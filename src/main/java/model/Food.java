package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name= "food")
public class Food extends FoodBaseEntity{

    @Column(name = "food", length = 50, nullable = false)
    private String food;

    @Column(name = "weight", nullable = false)
    private int weight;

    protected Food() {
        super();
    }

    public Food(String food, int weight, UUID personId, ZonedDateTime datetime) {
        super(personId, datetime);
        this.food = food;
        this.weight = weight;
    }
}
