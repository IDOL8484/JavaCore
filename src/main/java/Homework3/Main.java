package Homework3;

public class Main {

    public static void main(String[] args) {
//        Задание 1:
        Massive m = new Massive();
        m.mass();
        System.out.println();
//        Меняем местами Mother[0] и Father[1].

//        Задание 2:
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        System.out.println("Вес коробки с яблоками №1: " + appleBox1.getWeight() + " кг.");

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());
        System.out.println("Вес коробки с апельсинами №1: " + orangeBox1.getWeight() + " кг.");

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        System.out.println("Вес коробки с яблоками №2: " + appleBox2.getWeight() + " кг.");

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        System.out.println("Вес коробки с апельсинами №2: " + orangeBox2.getWeight() + " кг.");

//        Сравненваем коробки по весу (true or false).

        System.out.println("\nСравнение по весу разных коробок: " + appleBox1.compare(orangeBox1));
        System.out.println("Сравнение по весу разных коробок: " + appleBox2.compare(appleBox1));

//        Пересыпаем фрукты из коробки в коробку.

        System.out.println();
        appleBox1.dropToBox(appleBox2);
        System.out.println(appleBox2);

        System.out.println(orangeBox2);
        orangeBox2.dropToBox(orangeBox1);
        System.out.println(orangeBox1);


    }
}
