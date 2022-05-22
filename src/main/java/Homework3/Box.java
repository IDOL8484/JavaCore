package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit>{
    private List<T> box = new ArrayList<>();
    public Box() {
    }

    public List<T> getBox() {
        return box;
    }

    public void setBox(List<T> box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "Фрукты в коробке: " + box;
    }
    public void addFruit(T fruit) {
//        Метод добавления фруктов в коробку
        box.add(fruit);
    }

    public float getWeight () {
//        Метод взвешивает коробки.
        float weight = 0.0f;
        if(box.size() > 0) {
           weight = box.size() * box.get(0).getWeight();
        }
            return weight;
        }

    public boolean compare(Box b) {
//        Метод сравнивает коробки по весу.
        if(getWeight() == b.getWeight()) {
          return true;
        }
        return false;
    }
    public void dropToBox(Box<T> b) {
//         Метод добавляет фрукты из одной коробки в другую (только одинаковые фрукты).
       b.getBox().addAll(box);
       box.clear();
    }
}
