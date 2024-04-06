package event;

// https://github.com/alves-dev/life/blob/main/events/README.md#alimenta%C3%A7%C3%A3o-routing_key---food
public class EventFood extends EventBase {
    private String food;
    private int weight;

    public String getFood() {
        return food;
    }

    public int getWeight() {
        return weight;
    }

    protected void setFood(String food) {
        this.food = food;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + " | " +
                "EventFood{" +
                "food='" + food + '\'' +
                ", weight=" + weight +
                '}';
    }
}
