package ru.job4j.oop;

public class Shop {
    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            }
        }
    }

    public static int indexOfNull(Product[] products) {
        int num = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null){
                num = i;
                break;
            }else {
                num = -1;
            }
        }
        return num;
    }
}
