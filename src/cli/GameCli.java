package cli;

import events.GameEvent;
import events.GameListener;

public class GameCli implements GameListener {

    @Override
    public void onEvent(GameEvent e) {
        switch (e){
            case GameEvent.Attack a -> System.out.printf("%s атаковал %s: -%.0f HP%n", a.attacker(), a.target(), a.damage());
            case GameEvent.Death d -> System.out.printf("%s погиб!%n", d.name());
            case GameEvent.ItemUsed i -> System.out.printf("%s использовал «%s»%n", i.owner(), i.itemName());
            default -> {}
        }
    }
}