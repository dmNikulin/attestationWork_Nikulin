package programm.ui;

import java.util.Scanner;

import programm.elements.Horse;
import programm.functions.Writer;

public class Ui {
    public void run() {
        int cmd = -1;
        String animalName = "";
        String animalDate = "";
        String animalCommand = "";
        String type = "";

        Writer writer = new Writer();

        try (Scanner scanner = new Scanner(System.in)) {
            while (cmd != 0) {
                System.out.println("Введите команду: ");
                System.out.println("1.Завести новое животное \n2.Просмотреть животное \n0.Выход \n");
                cmd = Integer.parseInt(scanner.nextLine());

                switch (cmd) {
                    case 1:
                        while (cmd != 0) {
                            System.out.println("Введите команду: ");
                            System.out.println("1.Въючное \n2.Домашнее \n0.Выход");
                            cmd = Integer.parseInt(scanner.nextLine());
                            switch (cmd) {
                                case 1:
                                    while (cmd != 0) {
                                        System.out.println("Выберите животное: ");
                                        System.out.println("1.Конь \n2.Верблюд \n3.Осёл .\n0.Выход");
                                        cmd = Integer.parseInt(scanner.nextLine());
                                        switch (cmd) {
                                            case 1:
                                                type = "Конь";

                                                System.out.println("Введите имя: ");
                                                animalName = scanner.nextLine();
                                                System.out.println("Введите дату рождения: ");
                                                animalDate = scanner.nextLine();
                                                System.out.println("Введите команды: ");
                                                animalCommand = scanner.nextLine();

                                                Horse horse = new Horse(animalName, animalDate, animalCommand);

                                                writer.save(horse, type);
                                                break;

                                            default:
                                                break;
                                        }
                                    }
                                    break;

                                default:
                                    break;
                            }
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
