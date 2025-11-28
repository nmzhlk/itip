package lab7;

import java.util.concurrent.atomic.AtomicInteger;

class Product {
    private int weight;

    public Product(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class Warehouse {
    private Product[] products;
    private AtomicInteger index = new AtomicInteger(0);

    public Warehouse(Product[] products) {
        this.products = products;
    }

    public Product getNextProduct() {
        int i = index.getAndIncrement();
        if (i < products.length) {
            return products[i];
        }
        return null;
    }
}

class Loader extends Thread {
    private Warehouse warehouse;
    private static final int MAX_WEIGHT = 150;
    private static AtomicInteger currentWeight = new AtomicInteger(0);
    private static Object lock = new Object();

    public Loader(String name, Warehouse warehouse) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            Product p = warehouse.getNextProduct();
            if (p == null) {
                synchronized (lock) {
                    if (currentWeight.get() > 0) {
                        System.out.println(getName() + " отвозит последние товары на другой склад (вес: "
                                + currentWeight + " кг)");
                        currentWeight.set(0);
                    }
                }
                break;
            }

            synchronized (lock) {
                int newWeight = currentWeight.get() + p.getWeight();
                if (newWeight <= MAX_WEIGHT) {
                    currentWeight.set(newWeight);
                    System.out.println(getName() + " взял товар весом " + p.getWeight() + " кг. Текущий вес партии: "
                            + currentWeight);
                } else {
                    System.out.println(getName() + " отвозит товары на другой склад (вес: " + currentWeight + " кг)");
                    currentWeight.set(p.getWeight());
                    System.out.println(getName() + " начинает новую партию с товаром весом " + p.getWeight() + " кг");
                }
            }
        }
    }
}

public class WarehouseDemo {
    public static void main(String[] args) {
        Product[] products = {
                new Product(30), new Product(40), new Product(50),
                new Product(20), new Product(60), new Product(70),
                new Product(80), new Product(90)
        };

        Warehouse warehouse = new Warehouse(products);

        Loader loader1 = new Loader("Грузчик 1", warehouse);
        Loader loader2 = new Loader("Грузчик 2", warehouse);
        Loader loader3 = new Loader("Грузчик 3", warehouse);

        loader1.start();
        loader2.start();
        loader3.start();

        try {
            loader1.join();
            loader2.join();
            loader3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все товары перенесены.");
    }
}