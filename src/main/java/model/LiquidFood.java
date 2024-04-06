package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name= "liquid_food")
public class LiquidFood extends FoodBaseEntity{

    @Column(name = "liquid", length = 50, nullable = false)
    private String liquid;

    @Column(name = "amount", nullable = false)
    private int amount;

    protected LiquidFood() {
        super();
    }

    public LiquidFood(String liquid, int amount, UUID personId, ZonedDateTime datetime) {
        super(personId, datetime);
        this.liquid = liquid;
        this.amount = amount;
    }
}
