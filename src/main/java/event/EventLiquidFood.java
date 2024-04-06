package event;

// https://github.com/alves-dev/life/blob/main/events/README.md#alimenta%C3%A7%C3%A3o-routing_key---food-1
public class EventLiquidFood extends EventBase {
    private String liquid;
    private int amount;

    public String getLiquid() {
        return liquid;
    }

    public int getAmount() {
        return amount;
    }

    protected void setLiquid(String liquid) {
        this.liquid = liquid;
    }

    protected void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + " | " +
                "EventLiquidFood{" +
                "liquid='" + liquid + '\'' +
                ", amount=" + amount +
                '}';
    }
}
