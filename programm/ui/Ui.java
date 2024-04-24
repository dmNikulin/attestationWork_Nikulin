package programm.ui;

import java.util.Scanner;

public class Ui {
    public void run() {
        int cmd = -1;

        try (Scanner scanner = new Scanner(System.in)) {
            while (cmd != 0) {
                System.out.println("Введите команду: ");
                System.out.println("1.Завести новое животное \n2.Просмотреть животное \n0.Выход \n");
                cmd = Integer.parseInt(scanner.nextLine());

                switch (cmd) {
                    case 1:
                        while (cmd != 3) {
                            System.out.println("Введите команду: ");
                            System.out.println("1.Въючное \n2.Домашнее \n3.Назад \n4.Выход");
                            cmd = Integer.parseInt(scanner.nextLine());
                        }
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
