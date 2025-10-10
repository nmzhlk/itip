package lab3;

import java.util.*;

public class HashTable<K, V> {
    private List<Map.Entry<K, V>>[] table;
    private int size;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        size = 0;
    }

    public int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Map.Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new AbstractMap.SimpleEntry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Map.Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            Iterator<Map.Entry<K, V>> iterator = table[index].iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getKey().equals(key)) {
                    iterator.remove();
                    size--;
                    if (table[index].isEmpty()) {
                        table[index] = null;
                    }
                    return;
                }
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>(10);

        System.out.println("Создали хэш-таблицу с емкостью 10");
        System.out.println();

        System.out.println("Сейчас таблица пустая. Проверим isEmpty() и size()");
        System.out.println("size(): " + hashTable.size());
        System.out.println("isEmpty(): " + hashTable.isEmpty());
        System.out.println();

        System.out.println("Теперь добавим три элемента / put()");
        hashTable.put("фильм", "Гадкий я 4");
        hashTable.put("музыка", "Тема Грю");
        hashTable.put("миньон", "Стюарт");
        System.out.println("size(): " + hashTable.size());
        System.out.println("isEmpty(): " + hashTable.isEmpty());
        System.out.println();

        System.out.println("Протестируем метод get()");
        System.out.println("фильм: " + hashTable.get("фильм"));
        System.out.println("музыка: " + hashTable.get("музыка"));
        System.out.println("миньон: " + hashTable.get("миньон"));
        System.out.println();

        System.out.println("Протестируем метод put()");
        System.out.println("Миньон раньше: " + hashTable.get("миньон"));
        hashTable.put("миньон", "Кевин");
        System.out.println("Миньон сейчас: " + hashTable.get("миньон"));
        System.out.println("Размер таблицы не меняется: " + hashTable.size());
        System.out.println();

        System.out.println("Протестируем обработку коллизий");
        hashTable.put("тест", "тестовая строка 1");
        hashTable.put("сетт", "тестовая строка 2");
        System.out.println("Добавлены 'тест' и 'сетт'");
        System.out.println("тест: " + hashTable.get("тест") + " - хэш этой строки: " + hashTable.hash("тест"));
        System.out.println("сетт: " + hashTable.get("сетт") + " - хэш этой строки: " + hashTable.hash("сетт"));
        System.out.println("Размер таблицы увеличился: " + hashTable.size());
        System.out.println();

        System.out.println("Проверим get() для несуществующего ключа");
        System.out.println("песня: " + hashTable.get("песня"));
        System.out.println();

        System.out.println("Протестируем метод delete()");
        System.out.println("Удалим 'музыку': " + hashTable.get("музыка"));
        hashTable.remove("музыка");
        System.out.println("После удаления: " + hashTable.get("музыка"));
        System.out.println("Размер таблицы уменьшился: " + hashTable.size());
        System.out.println();

        System.out.println("Проверим remove() для несуществующего ключа");
        hashTable.remove("песня");
        System.out.println("Размер таблицы тот же: " + hashTable.size());
        System.out.println();

        System.out.println("Итоговая таблица");
        System.out.println("фильм: " + hashTable.get("фильм"));
        System.out.println("музыка: " + hashTable.get("музыка"));
        System.out.println("миньон: " + hashTable.get("миньон"));
        System.out.println("тест: " + hashTable.get("тест"));
        System.out.println("сетт: " + hashTable.get("сетт"));
        System.out.println("size(): " + hashTable.size());
        System.out.println("isEmpty(): " + hashTable.isEmpty());
        System.out.println();

        System.out.println("Очистим таблицу и проверим методы");
        hashTable.remove("фильм");
        hashTable.remove("музыка");
        hashTable.remove("миньон");
        hashTable.remove("тест");
        hashTable.remove("сетт");
        System.out.println("size(): " + hashTable.size());
        System.out.println("isEmpty(): " + hashTable.isEmpty());
        System.out.println();
    }
}
