package com.metanit;



public class Main {
    public static void main(String[] args) {
        Animal Pooh = new Animal("Винни");
        Animal Ia = new Animal("Иа");
        Animal Tiger = new Animal("Тигруля");
        Pooh.move(Location.FIELD);
        Pooh.ask("Как тебя зовут?");
        System.out.println(Ia.answer("Меня зовут..."));
        Tiger.move(Location.REEDS);
        Person Chris = new Person("Кристофер Робин");
        Chris.move(Location.PATH);
        Chris.mood();
        Chris.think();
        Chris.move(Location.BRIDGE);
        Chris.think();
        Chris.know();


        Game game = new Game();
        Game.ChanceToWin chance = game.new ChanceToWin();
        game.addGame("Пух", 10, 0);
        chance.knowChance();
        game.addGame("Тигруля", 30, 20);
        chance.knowChance();


        try {
            game.ready();
        }
        catch (ZeroMembersException e) {
            System.out.println(e.getNum());
        }

    }

}
