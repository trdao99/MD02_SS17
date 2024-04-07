package bai5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        National national = new National();
        System.out.println("Input ID:");
        national.setNationalID(Integer.parseInt(sc.nextLine()));
        System.out.println("Input code:");
        national.setNationalCode(sc.nextLine());
        System.out.println("Input name:");
        national.setNationalName(sc.nextLine());

        File file = new File("file5.txt");

        // Write object to file
        try (FileOutputStream fos = new FileOutputStream(file, true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(national);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read objects from file
        List<National> nationals = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                National national1 = (National) ois.readObject();
                nationals.add(national1);
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        // Print the objects
        for (National s : nationals) {
            System.out.println(s.toString());
        }
    }
}