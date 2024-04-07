package bai6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class Bai6 {
    public static void main(String[] args) {
        File file = new File("file6.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        Scanner scan = new Scanner(System.in);
        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(scan.nextLine());
            bw.close(); // Đóng BufferedWriter sau khi ghi
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HashMap<String, Integer> map = new HashMap<>();
        try {
            String content = Files.readString(file.toPath(), StandardCharsets.UTF_8);
            List<String> list = Arrays.asList(content.split(" "));
            for (String word : list) {
                int count = map.getOrDefault(word, 0);
                map.put(word, count + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(map);
    }
}