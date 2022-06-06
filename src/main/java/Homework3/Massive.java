package Homework3;

import java.util.Arrays;

public class Massive {

    public void mass() {
//           Массив и вывод информации о нем.
        String[] mass = new String[] {"Mother", "Father", "Brother", "Sister", "GrandPa", "GroundMa"};
        System.out.println(Arrays.toString(mass));
        changeMassive(mass);
        System.out.println(Arrays.toString(mass));
    }
    public void changeMassive(String[] mass) {
//         Метод меняющий 0 и 1 элементы массива.
        String str = mass[0];
        mass[0] = mass[1];
        mass[1] = str;
    }
}
