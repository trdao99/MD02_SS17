import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        File file = new File("bai3text.txt");
        FileOutputStream fileOut = null;
        ObjectOutputStream fileObject = null;
        Scanner sc = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        try {
            fileOut = new FileOutputStream("bai3text.txt", true);
            fileObject = new ObjectOutputStream(fileOut);
            for (int i = 0; i < 2; i++) {
                String s = sc.nextLine();
                stringList.add(s);
                fileObject.writeObject(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String inputString = readFile("bai3text.txt");// lấy dữ liệu từ file
        String[] arrStr = inputString.split(" ");// từ string thành mảng các string
        System.out.println(Arrays.toString(arrStr));// in mảng
        System.out.println("Số lượng ptu: "+ arrStr.length);// in số ptu
        ////////////////bai 3
        List<String> list = new ArrayList<>();// tạo list
        String maxLength = arrStr[0];//maxlength = ptu đầu của mảng
        list.add(maxLength);
        for (int i = 1; i < arrStr.length; i++) {
            if (arrStr[i].length()==maxLength.length()){//ptu có length = maxlength thì thêm vào lít
                list.add(arrStr[i]);
            } else if (arrStr[i].length()>maxLength.length()) {// ptu có length lớn hơn thì xóa líst vào thêm ptu mới vào
                list.clear();
                maxLength = arrStr[i];
                list.add(arrStr[i]);
            }
        }
        System.out.println(list);
    }
    // đọc file
    public static String readFile(String path) {
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder inputString = new StringBuilder();
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line;
            // đọc file theo dòng và ghi lại vào string builder
            while ((line = br.readLine())!=null){
                inputString.append(line).append("\n");
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return inputString.toString();
    }
}

