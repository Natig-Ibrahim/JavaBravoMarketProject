/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import beans.Product;
import main.Config;

/**
 *
 * @author Hp electron
 */
public class ProductUtil {

    public static Product fillProduct() {

        int id = InputUtil.requireNumber("enter id");
        String name = InputUtil.requireText("enter name");
        double price = InputUtil.requireDouble("enter price");
        String category = InputUtil.requireText("enter category");
        //burada melumatlari alib constructor vasitesile yeni obyekte yaradiriq
        Product p = new Product(id, name, price, category);
        return p;
    }

    public static void addProduct() {

        int count = InputUtil.requireNumber("How many product do you want to add?");
        Config.product = new Product[count];
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + ". Product");

            //bu yaranmis obyektleri bir yere yigib yaddashda saxlamaq ucun Config class yaradiriq
            Config.product[i] = ProductUtil.fillProduct();

        }
    }

    //bu metod void oldugu ucun ekrana yalniz yazi yazdirir
    public static void showAllProducts() {

        //bu sert deyer duzgun verilmedikde yazilir ve hemin metodu yeniden basladir 
        if(Config.product==null) {
            return;
        }
        
        for (int i = 0; i < Config.product.length; i++) {
            System.out.println(i + 1 + ". " + Config.product[i]);
        }

    }

    public static void findAndPrintProduct() {

        String text = InputUtil.requireText("Enter name | category");
        for (int i = 0; i < Config.product.length; i++) {
            if (Config.product[i].getName().contains(text)
                    || Config.product[i].getCategory().contains(text)
                    || String.valueOf(Config.product[i].getId()).contains(text)) {

                System.out.println(Config.product[i]);
            }
        }
    }

    public static void updateProduct() {

        int num = InputUtil.requireNumber("Enter which product do you want to update: ");

        //bu kod produktun butun melumatlarin deyisir
        //Config.product[num-1] = ProductUtil.fillProduct();
        String params = InputUtil.requireText("id, name, price, category");
        Product p = Config.product[num - 1];

        if (params.contains("id")) {

            p.setId(InputUtil.requireNumber("Enter new id: "));
        }
        if (params.contains("name")) {

            p.setName(InputUtil.requireText("Enter new name"));
        }
        if (params.contains("price")) {

            p.setPrice(InputUtil.requireDouble("Enter new price"));
        }
        if (params.contains("category")) {

            p.setName(InputUtil.requireText("Enter new category"));
        }
    }
    
    public static void deleteProduct() {
    
        int num = InputUtil.requireNumber("Enter which product do you want to delete: ");
        String params = InputUtil.requireText("name: ");
        if(params.contains("name")) {
            Config.product[num-1] = null;
        }else {
            System.out.println("Enter right name");
            ProductUtil.deleteProduct();
        }
    }
}
