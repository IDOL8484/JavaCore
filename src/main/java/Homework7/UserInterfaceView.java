package Homework7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города:");
            String city = scanner.next();

            System.out.println("Введите: \n1 - для получения прогноза на сегодня; " +
                    "\n5 - для прогноза на 5 дней; \n0 - для выхода.");

            String command = scanner.next();
            System.out.println("Погода для города: " + city);

            if(command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
            }
        }
    }
}
