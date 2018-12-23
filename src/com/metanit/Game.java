package com.metanit;

import java.util.Objects;

public class Game {
    Game() {}
    static int num = 0;
    final int speed = 10;
    private int weight;
    private int size;


    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSize(int size) {
        this.size = size;
    }


    void addGame(String name, int weight, int size) {
        Animal animal = new Animal(name) {
            public void throwStick() {
                System.out.println(name + " присоединился к игре ");
            }
        };
        num++;
        this.setWeight(weight);
        this.setSize(size);
        animal.throwStick();
    }

    void ready () throws ZeroMembersException {
        if (num==0) throw new ZeroMembersException("Никто не играет в игру", num);
        class InformBeforeGame {
            private int numOfMembers;
            private void inform() {
                this.numOfMembers = num;
                System.out.println("Количество игроков = " + numOfMembers);
                System.out.println("Скорость течения реки = " + speed);
            }
        }
        InformBeforeGame ready = new InformBeforeGame();
        ready.inform();
    }

    class ChanceToWin {
        int chance;
        void knowChance() throws ZeroSizeException {
            try {
                if (size == 0)
                {
                    throw new ZeroSizeException("Палочка не существует", size);
                }
                else{
                    System.out.println("Палочка подходит для игры");
                }
                this.chance = (size + (weight/(size*4) + speed)*3);
            }
            catch (ZeroSizeException e) {
                System.out.println("Возникло исключение, " + e.getNum());
            }
            System.out.println("Коэффициент победы = " + this.chance);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (o.getClass() != this.getClass())
            return false;
        Game game = (Game) o;
        return this.weight == game.weight
                && size == game.size;
    }

    @Override
    public String toString() {
        return "Game name - Пустяки ";
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, size);
    }

}
