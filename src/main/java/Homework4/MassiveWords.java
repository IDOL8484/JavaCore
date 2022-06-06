package Homework4;

import java.util.*;

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.

public class MassiveWords {
    public void bikeBrands() {

        List<String> brandNames = new ArrayList<>(Arrays.asList(
                "Author", "Trek", "Cube", "Electra", "Merida", "Forward",
                "Stels", "Strida", "Cube", "Author", "Trek",
                "Cube", "Stels", "Stels", "Merida", "Forward" ));

        System.out.println("Все названия, подряд: " + brandNames);

        HashSet<String> uniqueBrands = new HashSet<>(brandNames);
        System.out.println("Уникальные названия: " + uniqueBrands);
        System.out.println("\nУникальные названия и количество повторений:");

        for(String brand : uniqueBrands) {
            System.out.print(brand
                   + ": " + Collections.frequency(brandNames, brand) + "; ");
        }
    }
}
