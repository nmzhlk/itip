package lab6;

public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new IllegalStateException("Стек заполнен");
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        size--;
        T element = data[size];
        data[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        return data[size - 1];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Размер стека: " + stack.size() + "\n");

        System.out.println("Удалим крайний элемент: " + stack.pop());
        System.out.println("Размер стека (после удаления): " + stack.size() + "\n");
        System.out.println("Посмотрим крайний элемент: " + stack.peek());
        System.out.println("Размер стека (не меняется): " + stack.size() + "\n");

        stack.push(4);
        System.out.println("Размер стека (добавили элемент 4): " + stack.size() + "\n");
        System.out.println("Удалим крайний элемент: " + stack.pop());
        System.out.println("Размер стека (после удаления): " + stack.size() + "\n");

        System.out.println("Удалим крайний элемент: " + stack.pop());
        System.out.println("Размер стека (после удаления): " + stack.size() + "\n");

        System.out.println("Посмотрим крайний элемент: " + stack.peek());
        System.out.println("Размер стека (не меняется): " + stack.size() + "\n");

        System.out.println("Удалим крайний элемент: " + stack.pop());
        System.out.println("Размер стека (пустой): " + stack.size() + "\n");
    }
}