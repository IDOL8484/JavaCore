package Homework4;

//2. Написать простой класс «Телефонный Справочник»,
// который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи,
// а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

import java.util.*;

import static java.lang.System.out;

public class PhoneBook{
    protected Map<String, List<String>> pb = new HashMap<>();
    protected List<String> numbersList;

    public void add(String surName, String phoneNumber) {

        if (pb.containsKey(surName)) {
            numbersList = pb.get(surName);
        } else {
            numbersList = new ArrayList<>();
        }
        numbersList.add(phoneNumber);
        pb.put(surName, numbersList);
    }

    public List<String> get (String surName) {
        System.out.print(surName + ": ");
        return pb.get(surName);
    }

    @Override
    public String toString() {
        return "\nТелефонный справочник:" + pb;
    }
}
