package bai2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        File file = new File("path");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        Scanner sc = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        File file2 = new File("copy");
        copyFileCharacter("path", "copy");
        List<String> list = readStudent("copy");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("so byte cua copy file la : " + file2.length());
    }

    public static List<String> readStudent(String path) {
        List<String> list = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            while (true) {
                String student = (String) ois.readObject();
                list.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }


    public static boolean copyFileCharacter(String input, String output) {
        File inputFile = new File(input);
        File outputFile = new File(output);
        if (!inputFile.exists()) {
            throw new RuntimeException("file ko ton khai");
        }
        BufferedReader bfr = null;
        BufferedWriter bfw = null;
        try {
            bfr = new BufferedReader(new FileReader(inputFile));
            bfw = new BufferedWriter(new FileWriter(outputFile));

            int c;
            while ((c = bfr.read()) != -1) {
                bfw.write(c);
            }
            bfw.flush(); // day tu buffer ra file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bfw != null) {
                try {
                    bfw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }
}
