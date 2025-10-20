package lab2;

import java.util.Scanner;

abstract class Book {
    String title;
    String author;
    int year;
    static int objectCount = 0;

    public Book() {
        objectCount++;
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        objectCount++;
    }

    public abstract void displayInfo();

    public abstract void play();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int getObjectCount() {
        return objectCount;
    }
}

class AudioBook extends Book {
    private String narrator;
    private int duration;

    public AudioBook() {
        super();
    }

    public AudioBook(String title, String author, int year, String narrator, int duration) {
        super(title, author, year);
        this.narrator = narrator;
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        System.out.println("Аудиокнига: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Год выпуска: " + year);
        System.out.println("Чтец: " + narrator);
        System.out.println("Длительность: " + duration + " минут");
    }

    @Override
    public void play() {
        System.out.println("Воспроизведение аудиокниги: " + title + ", автор: " + author);
    }

    public void pause() {
        System.out.println("Воспроизведение аудиокниги " + title + " на паузе");
    }

    public void stop() {
        System.out.println("Воспроизведение аудиокниги " + title + " остановлено");
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

class Movie extends AudioBook {
    private String director;
    private String genre;
    private double rating;

    public Movie() {
        super();
    }

    public Movie(String title, String author, int year, String narrator, int duration, String director, String genre,
            double rating) {
        super(title, author, year, narrator, duration);
        this.director = director;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public void displayInfo() {
        System.out.println("Фильм: " + title);
        System.out.println("Сценарист: " + author);
        System.out.println("Год выпуска: " + year);
        System.out.println("Режиссер: " + director);
        System.out.println("Жанр: " + genre);
        System.out.println("Рейтинг: " + rating + "/10");
        System.out.println("Длительность: " + getDuration() + " минут");
    }

    @Override
    public void play() {
        System.out.println("Запуск фильма: " + title + " режиссера " + director);
    }

    public void play(String quality) {
        System.out.println("Запуск фильма: " + title + " в качестве " + quality);
    }

    public void addToFavorites() {
        System.out.println("Фильм " + title + " добавлен в избранное");
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

class Musical extends AudioBook {
    private String composer;
    private int songCount;
    private String mainActor;

    public Musical() {
        super();
    }

    public Musical(String title, String author, int year, String narrator, int duration, String composer, int songCount,
            String mainActor) {
        super(title, author, year, narrator, duration);
        this.composer = composer;
        this.songCount = songCount;
        this.mainActor = mainActor;
    }

    @Override
    public void displayInfo() {
        System.out.println("Мюзикл: " + title);
        System.out.println("Автор либретто: " + author);
        System.out.println("Год выпуска: " + year);
        System.out.println("Композитор: " + composer);
        System.out.println("Количество песен: " + songCount);
        System.out.println("Главный актер: " + mainActor);
        System.out.println("Длительность: " + getDuration() + " минут");
    }

    @Override
    public void play() {
        System.out.println("Начало мюзикла: " + title + " с участием " + mainActor);
    }

    public void singSong(String songName) {
        System.out.println("Исполнение песни: " + songName + " из мюзикла " + title);
    }

    public void showCast() {
        System.out.println("Актерский состав мюзикла " + title + ": " + mainActor + " и другие");
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }
}

public class Library {
    private static void demonstrateDynamicPolymorphism(Book[] library) {
        System.out.println("1. Динамический полиморфизм - переопределение методов");
        for (Book item : library) {
            item.displayInfo();
            item.play();
            System.out.println("-----");
        }
    }

    private static void demonstrateStaticPolymorphism(Movie movie) {
        System.out.println("2. Статический полиморфизм - методы с одинаковыми именами, но разными параметрами");
        movie.play();
        movie.play("4K Ultra HD");
        System.out.println("-----");
    }

    private static void demonstrateEncapsulation(Movie movie) {
        System.out.println("3. Инкапсуляция через специальные методы: геттеры и сеттеры");
        System.out.println("Название фильма сейчас: " + movie.getTitle());
        movie.setTitle("Minions");
        System.out.println("Новое название фильма: " + movie.getTitle());
        System.out.println("-----");
    }

    private static void demonstrateInheritance(Musical musical) {
        System.out.println("4. Наследование классов");
        musical.displayInfo();
        musical.singSong("City of Stars");
        System.out.println("-----");
    }

    private static void demonstrateObjectCount() {
        System.out.println("5. Счетчик объектов");
        System.out.println("Всего объектов Book и его наследников: " + Book.getObjectCount());
    }

    private static void demonstrateUserInput(Scanner scanner) {
        System.out.println("6. Ввод данных пользователем");
        System.out.print("Введите название новой аудиокниги: ");
        String userTitle = scanner.nextLine();
        System.out.print("Введите автора: ");
        String userAuthor = scanner.nextLine();
        System.out.print("Введите год выпуска: ");
        int userYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите чтеца: ");
        String userNarrator = scanner.nextLine();
        System.out.print("Введите длительность (в минутах): ");
        int userDuration = Integer.parseInt(scanner.nextLine());

        AudioBook userBook = new AudioBook(userTitle, userAuthor, userYear, userNarrator, userDuration);

        System.out.println("-----");
        System.out.println("Созданная аудиокнига:");
        userBook.displayInfo();
    }

    public static void main(String[] args) {
        AudioBook audioBook = new AudioBook("1984", "George Orwell", 1949,
                "Ivan Ivanov", 720);

        Movie movie = new Movie("Despicable Me 4", "Mike White", 2024, "",
                94, "Chris Renaud", "Comedy", 6.2);

        Musical musical = new Musical("La La Land", "Damien Chazelle", 2016, "",
                128, "Justin Hurwitz", 44, "Ryan Gosling");

        Book[] library = { audioBook, movie, musical };

        demonstrateDynamicPolymorphism(library);
        demonstrateStaticPolymorphism(movie);
        demonstrateEncapsulation(movie);
        demonstrateInheritance(musical);
        demonstrateObjectCount();

        // AudioBook demoAudioBook = new AudioBook("Война и мир", "Лев Толстой", 1867, "Петр Петров", 4500);
        // System.out.println("После создания новой аудиокниги: " + AudioBook.getObjectCount());
        // System.out.println("-----");

        Scanner scanner = new Scanner(System.in, "UTF-8");
        demonstrateUserInput(scanner);
        scanner.close();

        System.out.println("-----");

        System.out.println("Итого объектов: " + Book.getObjectCount());
    }
}