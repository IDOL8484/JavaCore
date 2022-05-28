package Homework4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MassiveWords mw = new MassiveWords();
        mw.bikeBrands();
        System.out.println();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Petrov", "+79213456788");
        phoneBook.add("Ivanov", "+79239997575");
        phoneBook.add("Petrov", "+79313575551");
        phoneBook.add("Grigoryan", "+79312323223");
        phoneBook.add("Ivanov", "+79113987721");
        phoneBook.add("Kachanov", "+79326723223");
        phoneBook.add("Dalmatov", "+79113987002");


        System.out.println(phoneBook);

        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("Ivanov"));
    }
}
