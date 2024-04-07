package bai8;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("bai8.txt");
        FileOutputStream fos ;
        ObjectOutputStream oos;
        List<Product> products = new ArrayList<>();
        out:
        while (true) {
            Product product = new Product();
            System.out.println("1. add\n2.display\n3.search\n");
            System.out.print("choose: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("input id");
                    product.setId(sc.nextInt());
                    System.out.println("input name");
                    product.setName(sc.nextLine());
                    System.out.println("input brand");
                    product.setBrand(sc.nextLine());
                    System.out.println("input description");
                    product.setDescription(sc.nextLine());
                    System.out.println("input price");
                    product.setPrice(sc.nextInt());
                    try {
                        fos = new FileOutputStream(file, true);
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(product);
                        oos.flush();
                        oos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    FileInputStream fis ;
                    ObjectInputStream ois;
                    try {
                        fis = new FileInputStream(file);
                        ois = new ObjectInputStream(fis);
                        while (fis.available() > 0) {
                            Product product1 = (Product) ois.readObject();
                            products.add(product1);
                        }
                    } catch (ClassNotFoundException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    for (Product p : products) {
                        System.out.println(p.toString());
                    }
                    break;
                case 3:
                    System.out.println("find by ID");
                    int id = Integer.parseInt(sc.nextLine());
                    products.stream().filter(p -> p.getId() == id).findFirst().ifPresent(System.out::println);
                    break;
                case 4:
                    break out;
            }
        }
    }
}
