package bai4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("bai4.txt");
        FileWriter fw = null;

        try {
            fw = new FileWriter("bai4.txt", true);
            for (int i = 0; i < 2; i++) {
                String s = sc.nextLine();
                fw.write(s);
                fw.write(" ");// tạo khoảng cách cho mỗi ptu
                fw.flush();
            }
            fw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String listSS = getStringBuilder(file);
        String[] arrStr = listSS.split(" ");// từ string thành mảng các string
        File copy = new File("bai4copy.txt");
        try {
            FileWriter fw2 = new FileWriter(copy);
            for (int i = arrStr.length-1; i >= 0 ; i--) {
                fw2.write(arrStr[i]);
                fw2.write(" ");// tạo khoảng cách cho mỗi ptu
                fw2.flush();
            }
            fw2.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String listSS2 = getStringBuilder(copy);
        String[] arrStr2 = listSS2.split(" ");// từ string thành mảng các string
        System.out.println(Arrays.toString(arrStr2));
    }

    private static String getStringBuilder(File sourceFile) {
        StringBuilder inputString = new StringBuilder();// tạo stringbuilder
        FileReader fr = null;
        BufferedReader br = null;
        try {//đọc file và cho stringbuilder lấy string theo dòng
            fr = new FileReader(sourceFile);
            br = new BufferedReader(fr);
            String c;
            while ((c = br.readLine()) != null) {
                inputString.append(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return inputString.toString();
    }
}
