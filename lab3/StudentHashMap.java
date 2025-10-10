package lab3;

import java.util.*;

public class StudentHashMap<K, V> {
    private HashMap<K, V> students;

    public StudentHashMap() {
        this.students = new HashMap<K, V>();
    }

    public boolean addStudent(K recordNumber, V student) {
        if (students.containsKey(recordNumber) || recordNumber == null || student == null) {
            return false;
        }
        students.put(recordNumber, student);
        return true;
    }

    public V findStudent(K recordNumber) {
        return students.get(recordNumber);
    }

    public boolean removeStudent(K recordNumber) {
        return students.remove(recordNumber) != null;
    }

    public int size() {
        return students.size();
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Хэш-таблица пустая");
            return;
        }

        System.out.println("Список всех студентов");
        for (Map.Entry<K, V> entry : students.entrySet()) {
            System.out.println("Зачетка: " + entry.getKey() + " --> " + entry.getValue());
        }
    }

    public void clear() {
        students.clear();
    }

    public static void main(String[] args) {
        StudentHashMap<Integer, Student> studentMap = new StudentHashMap<>();

        Student student1 = new Student("Иван", "Иванов", 20, 4.5);
        Student student2 = new Student("Петр", "Петров", 21, 4.2);
        Student student3 = new Student("Мария", "Сидорова", 19, 4.8);
        Student student4 = new Student("Анна", "Кузнецова", 22, 4.1);

        System.out.println("Добавление студентов / addStudent()");
        System.out.println("Студент 1: " + studentMap.addStudent(1, student1));
        System.out.println("Студент 2: " + studentMap.addStudent(2, student2));
        System.out.println("Студент 3: " + studentMap.addStudent(3, student3));
        System.out.println("Повторное добавление студента 1: " + studentMap.addStudent(1, student4));
        System.out.println();

        System.out.println("Поиск студента / findStudent()");
        Student found = studentMap.findStudent(2);
        System.out.println("Найден студент 2: " + found);
        Student foundTest = studentMap.findStudent(9);
        System.out.println("Найден студент 9: " + foundTest);
        System.out.println();

        System.out.println("Все студенты / displayAllStudents()");
        studentMap.displayAllStudents();
        System.out.println();

        System.out.println("Удаление студентов / removeStudent()");
        System.out.println("Удаление студента 3: " + studentMap.removeStudent(3));
        System.out.println("Удаление несуществующего студента 9: " + studentMap.removeStudent(9));
        System.out.println();

        studentMap.displayAllStudents();
        System.out.println("Количество студентов: " + studentMap.size());
        System.out.println("Пустая ли таблица? - " + studentMap.isEmpty());
        System.out.println();
    }
}