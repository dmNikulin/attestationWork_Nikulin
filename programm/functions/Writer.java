package programm.functions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import programm.elements.Animal;

public class Writer {

    public void save (Animal animal, String type) {
        try {
            FileWriter writer = new FileWriter("programm\\data\\animals.txt", true);
            writer.write(type + ": " + animal.toString() + "\n");
            writer.close();
        } 
        catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }

    public void NewList (List<String> animalList) {
        try {
            FileWriter writer = new FileWriter("programm\\data\\animals.txt");
            for (String i : animalList) {
                writer.write(i + "\n");
            }
            
            writer.close();
        } 
        catch (IOException e) {
            System.out.println("Ошибка при записи");
            e.printStackTrace();
        }
    }
}
