package cli;

import app.Gamer;
import entities.Inventory;
import entities.State;
import entities.character.Warrior;
import entities.items.DamageBoostItem;
import entities.monsters.Dragon;

import java.util.Scanner;


public class GameCli {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Добро пожаловать в игру! ===");
        System.out.print("Введи имя своего воина: ");
        String name = readLine().trim();
        if (name.isEmpty()) {
            name = "Varvik";
        }

        Gamer gamer = new Gamer();
        gamer.setCharacter(new Warrior(
                name, 100, State.doesNothing,
                new Inventory(new DamageBoostItem(), new DamageBoostItem())
        ));

        mainMenu(gamer);
        System.out.println("Пока!");
    }

    //Главное меню

    private static void mainMenu(Gamer gamer) {
        Warrior hero = (Warrior) gamer.getCharacter();

        while (true) {
            if (hero.getState() == State.dead) {
                System.out.println("\nТвой персонаж мёртв. Игра окончена.");
                return;
            }

            System.out.println("\n===== ГЛАВНОЕ МЕНЮ =====");
            System.out.println("1. Информация о персонаже");
            System.out.println("2. Открыть инвентарь");
            System.out.println("3. Использовать предмет");
            System.out.println("4. Сразиться с драконом");
            System.out.println("0. Выход");

            switch (readInt("Выбор: ")) {
                case 1 -> hero.info();
                case 2 -> showInventory(hero);
                case 3 -> useItem(hero);
                case 4 -> battle(hero);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Нет такого пункта.");
            }
        }
    }

    //Инвентарь

    private static void showInventory(Warrior hero) {
        System.out.println("\n--- Инвентарь ---");
        hero.openInventory();

    }

    private static void useItem(Warrior hero) {
        showInventory(hero);
        System.out.println("Предметы выбираются по порядку в списке: 1, 2, 3...");
        int number = readInt("Номер предмета (0 - отмена): ");
        if (number == 0) {
            return;
        }

        try {
            hero.useItemFromInventory(number);
            System.out.println("Предмет использован!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Предмета с таким номером нет.");
        }
    }

    // ---------- Бой ----------

    private static void battle(Warrior hero) {
        Dragon dragon = new Dragon("Дракон", 150, State.doesNothing);
        hero.chalangeToDuel(dragon);
        System.out.println("\n!!! Ты вступил в бой с драконом !!!");

        while (true) {
            System.out.printf("%n%s: %.1f HP | %s: %.1f HP%n",
                    hero.getName(), hero.getHealth(), dragon.getName(), dragon.getHealth());
            System.out.println("1. Атаковать");
            System.out.println("2. Открыть инвентарь");
            System.out.println("3. Использовать предмет");
            System.out.println("4. Информация о драконе");
            System.out.println("0. Сбежать");

            switch (readInt("Действие: ")) {
                case 1 -> {
                    hero.atackEntity(dragon);
                    if (dragon.getHealth() <= 0) {
                        dragon.setState(State.dead);
                        hero.setState(State.doesNothing);
                        System.out.println("\nТы победил дракона! Победа!");
                        return;
                    }

                    dragon.atackEntity(hero);
                    System.out.printf("%s атаковал %s!%n", dragon.getName(), hero.getName());
                    if (hero.getHealth() <= 0) {
                        hero.setState(State.dead);
                        System.out.println("\nДракон победил тебя...");
                        return;
                    }
                }
                case 2 -> showInventory(hero);
                case 3 -> useItem(hero);
                case 4 -> dragon.info();
                case 0 -> {
                    hero.setState(State.doesNothing);
                    System.out.println("Ты сбежал с поля боя.");
                    return;
                }
                default -> System.out.println("Нет такого действия.");
            }
        }
    }

    // ---------- Ввод ----------

    private static String readLine() {
        if (!scanner.hasNextLine()) {
            System.exit(0);
        }
        return scanner.nextLine();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число!");
            }
        }
    }
}