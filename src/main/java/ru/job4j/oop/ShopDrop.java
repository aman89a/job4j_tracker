package ru.job4j.oop;

public class ShopDrop {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.getName());
        }
        products[1] = products[2];
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
    public static Product[] leftShift(Product[] products, int index) {
        Product temp;
            if (index == products.length - 1) {
                products[index] = null;
            } else if (index != products.length - 1) {
                products[index] = null;
                for (int i = 0; i < products.length; i++) {
                    if (index < i){
                        temp = products[i];
                        products[i] = products[index];
                        products[index] = temp;
                    }
                }
            }
        return products;
    }
}
