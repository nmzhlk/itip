package lab6;

import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f руб.", name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product product = (Product) obj;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class SalesManager {
    private ArrayList<Product> soldProducts;

    public SalesManager() {
        soldProducts = new ArrayList<>();
    }

    public void addSoldProduct(Product product) {
        soldProducts.add(product);
        System.out.println("Добавлен товар: " + product.getName() + "\n");
    }

    public void displaySoldProducts() {
        if (soldProducts.isEmpty()) {
            System.out.println("Нет данных о продажах.\n");
            return;
        }

        System.out.println("Список проданных товаров");
        for (int i = 0; i < soldProducts.size(); i++) {
            System.out.println((i + 1) + ". " + soldProducts.get(i));
        }
        System.out.println();
    }

    public double calculateTotalSales() {
        double total = 0;
        for (Product product : soldProducts) {
            total += product.getPrice();
        }
        return total;
    }

    public void findMostPopularProduct() {
        if (soldProducts.isEmpty()) {
            System.out.println("Нет данных о продажах.\n");
            return;
        }

        Map<String, Integer> productCount = new HashMap<>();
        Map<String, Double> productTotal = new HashMap<>();

        for (Product product : soldProducts) {
            String productName = product.getName();
            productCount.put(productName, productCount.getOrDefault(productName, 0) + 1);
            productTotal.put(productName, productTotal.getOrDefault(productName, 0.0) + product.getPrice());
        }

        String mostPopular = null;
        int maxCount = 0;
        double totalRevenue = 0;

        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
                totalRevenue = productTotal.get(mostPopular);
            }
        }

        System.out.printf("Самый популярный товар: '%s'%n", mostPopular);
        System.out.printf("Количество продаж: %d раз%n", maxCount);
        System.out.printf("Общая выручка по товару: %.2f руб.%n", totalRevenue);
    }

    public void displaySalesStatistics() {
        if (soldProducts.isEmpty()) {
            System.out.println("Нет данных о продажах.\n");
            return;
        }

        Map<String, Integer> productCount = new HashMap<>();
        Map<String, Double> productTotal = new HashMap<>();

        for (Product product : soldProducts) {
            String productName = product.getName();
            productCount.put(productName, productCount.getOrDefault(productName, 0) + 1);
            productTotal.put(productName, productTotal.getOrDefault(productName, 0.0) + product.getPrice());
        }

        System.out.println("Статистика продаж");
        for (String productName : productCount.keySet()) {
            int count = productCount.get(productName);
            double total = productTotal.get(productName);
            System.out.printf("%s: %d продаж, выручка: %.2f руб.%n",
                    productName, count, total);
        }
        System.out.println();
    }

    public int getTotalProductsSold() {
        return soldProducts.size();
    }
}

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesManager salesManager = new SalesManager();

        Product[] availableProducts = {
                new Product("Хлеб", 50.0),
                new Product("Молоко", 80.0),
                new Product("Сыр", 200.0),
                new Product("Бананы", 150.0),
                new Product("Пельмени", 300.0),
        };

        while (true) {
            System.out.println(" 1. Добавить проданный товар");
            System.out.println(" 2. Показать все проданные товары");
            System.out.println(" 3. Общая сумма продаж");
            System.out.println(" 4. Самый популярный товар");
            System.out.println(" 5. Статистика продаж");
            System.out.println(" 6. Выход");
            System.out.print("Выберите действие -> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nДоступные товары:");
                    for (int i = 0; i < availableProducts.length; i++) {
                        System.out.println((i + 1) + ". " + availableProducts[i]);
                    }
                    System.out.print("Выберите товар (1-" + availableProducts.length + "): ");
                    int productChoice = scanner.nextInt() - 1;

                    if (productChoice >= 0 && productChoice < availableProducts.length) {
                        salesManager.addSoldProduct(availableProducts[productChoice]);
                    } else {
                        System.out.println("Неверный выбор товара!");
                    }
                    break;

                case 2:
                    salesManager.displaySoldProducts();
                    break;

                case 3:
                    double total = salesManager.calculateTotalSales();
                    System.out.printf("Общая сумма продаж: %.2f руб.%n", total);
                    System.out.printf("Количество проданных товаров: %d%n",
                            salesManager.getTotalProductsSold());
                    System.out.println();
                    break;

                case 4:
                    salesManager.findMostPopularProduct();
                    break;

                case 5:
                    salesManager.displaySalesStatistics();
                    break;

                case 6:
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверно выбрано действие!");
            }
        }
    }
}