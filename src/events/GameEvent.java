package events;

public interface GameEvent {
    record Attack(String Attack, String target, float damage, float targetHealthLeft) implements GameEvent{}
    record Death(String name) implements GameEvent{}
    record ItemUsed(String owner, String itemName) implements GameEvent{}
}

