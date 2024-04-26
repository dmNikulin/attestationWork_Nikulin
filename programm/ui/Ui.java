package programm.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import programm.elements.Camel;
import programm.elements.Cat;
import programm.elements.Dog;
import programm.elements.Donkey;
import programm.elements.Hamster;
import programm.elements.Horse;
import programm.functions.AnimalsReader;
import programm.functions.Writer;

public class Ui {
    public void run() {
        int cmd = -5;
        String animalName;
        String animalDate;
        String animalCommand;
        String type;

        Writer writer = new Writer();
        AnimalsReader reader = new AnimalsReader();

        try (Scanner scanner = new Scanner(System.in)) {
            while (cmd != 0) {
                System.out.println("Введите команду: ");
                System.out.println("1.Завести новое животное \n2.Список животных \n0.Выход \n");
                cmd = Integer.parseInt(scanner.nextLine());

                switch (cmd) {
                    case 1:
                        while (cmd != -1) {
                            if (cmd == 0) break;

                            System.out.println("Выберите тип: ");
                            System.out.println("1.Въючное \n2.Домашнее \n3.Меню \n0.Выход\n");
                            cmd = Integer.parseInt(scanner.nextLine());
                            
                            switch (cmd) {
                                case 1:
                                    while (cmd != -2) {
                                        if (cmd == 0) break;

                                        System.out.println("Выберите животное: ");
                                        System.out.println("1.Конь \n2.Верблюд \n3.Осёл \n4.Назад \n0.Выход\n");
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

                                            case 2:
                                                type = "Верблюд";

                                                System.out.println("Введите имя: ");
                                                animalName = scanner.nextLine();
                                                System.out.println("Введите дату рождения: ");
                                                animalDate = scanner.nextLine();
                                                System.out.println("Введите команды: ");
                                                animalCommand = scanner.nextLine();

                                                Camel camel = new Camel(animalName, animalDate, animalCommand);

                                                writer.save(camel, type);

                                                break;

                                            case 3:
                                                type = "Осёл";

                                                System.out.println("Введите имя: ");
                                                animalName = scanner.nextLine();
                                                System.out.println("Введите дату рождения: ");
                                                animalDate = scanner.nextLine();
                                                System.out.println("Введите команды: ");
                                                animalCommand = scanner.nextLine();

                                                Donkey donkey = new Donkey(animalName, animalDate, animalCommand);

                                                writer.save(donkey, type);

                                                break;
                                            case 4:
                                                cmd = -2;
                                                break;

                                            default:
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    while (cmd != -2) {
                                        if (cmd == 0) break;

                                        System.out.println("Выберите животное: ");
                                        System.out.println("1.Собака \n2.Кошка \n3.Хомяк \n4.Назад \n0.Выход\n");
                                        cmd = Integer.parseInt(scanner.nextLine());

                                        switch (cmd) {
                                            case 1:
                                                type = "Собака";

                                                System.out.println("Введите имя: ");
                                                animalName = scanner.nextLine();
                                                System.out.println("Введите дату рождения: ");
                                                animalDate = scanner.nextLine();
                                                System.out.println("Введите команды: ");
                                                animalCommand = scanner.nextLine();

                                                Dog dog = new Dog(animalName, animalDate, animalCommand);

                                                writer.save(dog, type);

                                                break;

                                            case 2:
                                                type = "Кошка";

                                                System.out.println("Введите имя: ");
                                                animalName = scanner.nextLine();
                                                System.out.println("Введите дату рождения: ");
                                                animalDate = scanner.nextLine();
                                                System.out.println("Введите команды: ");
                                                animalCommand = scanner.nextLine();

                                                Cat cat = new Cat(animalName, animalDate, animalCommand);

                                                writer.save(cat, type);

                                                break;

                                            case 3:
                                                type = "Хомяк";

                                                System.out.println("Введите имя: ");
                                                animalName = scanner.nextLine();
                                                System.out.println("Введите дату рождения: ");
                                                animalDate = scanner.nextLine();
                                                System.out.println("Введите команды: ");
                                                animalCommand = scanner.nextLine();

                                                Hamster hamster = new Hamster(animalName, animalDate, animalCommand);

                                                writer.save(hamster, type);
                                                break;
                                            case 4:
                                                cmd = -2;
                                                break;

                                            default:
                                                break;
                                        }
                                    }
                                    break;
                                case 3: 
                                    cmd = -1;
                                
                                default:
                                    break;
                            }
                        }
                        break;

                    case 2:
                        reader.read();
                        List<String> animalList = reader.get();

                        while (cmd != 0) {
                            System.out.println("Введите номер животного для редактирования или 0 для выхода: ");
                            cmd = Integer.parseInt(scanner.nextLine());

                            if (cmd == 0) break;

                            String oldAnimal = animalList.get(cmd - 1);
                            animalList.remove(cmd - 1);

                            System.out.println("Введите команды для добавления: ");
                            String newCommand = scanner.nextLine();

                            animalList.add(cmd - 1, oldAnimal + " ," + newCommand);
                            writer.NewList(animalList);
                        }
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
