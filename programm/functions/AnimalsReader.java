package programm.functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalsReader {

    public List<String> get() {
        System.out.println();

        List<String> animalList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("programm\\data\\animals.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                animalList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        return animalList;
    }

    public void read() {
        System.out.println();

        List<String> animalList = new ArrayList<>();
        int counter = 1;


        try (BufferedReader reader = new BufferedReader(new FileReader("programm\\data\\animals.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                animalList.add(counter + ". "+ line);
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String i : animalList) {
            System.out.println(i);
        }

        System.out.println();
    }
}
