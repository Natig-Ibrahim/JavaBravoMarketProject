/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Hp electron
 */
public class MenuUtil {

    public static void menuProcessor() {

        while (true) {

            int menu = InputUtil.requireNumber("""
                               What do you want to do?
                               1.Add Product
                               2.Show All Product
                               3.Find Product
                               4.Update Product
                               5.Delete                
                               6.Exit
                               """);
            switch (menu) {
                case 1:
                    ProductUtil.addProduct();
                    break;
                case 2:
                    ProductUtil.showAllProducts();
                    break;
                case 3:
                    ProductUtil.findAndPrintProduct();
                    break;
                case 4:
                    ProductUtil.updateProduct();
                    break;
                case 5:
                    ProductUtil.deleteProduct();
                    break;
                case 6:
                    System.exit(0);
                default:
                    break;
            }

        }
    }
}
