package bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        File file = new File("path");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        Scanner sc = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        try {
            fos = new FileOutputStream("path",true);
            if (file.exists() && file.length()>0){
                oos = new iofile.AppendObjectOutputStream(fos);
            }else {
                oos = new ObjectOutputStream(fos);
            } for (int i = 0; i < 2; i++) {
                String s = sc.nextLine();
                stringList.add(s);
                oos.writeObject(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        List<String> list = readStudent("path");
        for (String s : list) {
            System.out.println(s);
        }
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
        }catch (EOFException e) {

        }catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois!=null){
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }
}
