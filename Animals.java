package main.java;

import java.util.*;

//Абстрактный класс животные
public abstract class Animals {
    static Scanner read = new Scanner(System.in);
    private String name;
    private double sizeCentimeter;
    private boolean predatory;
    private String $predatory;

    //Конструктор c параметрами
    public Animals(String name, double sizeCentimeter, String $predatory) {
        this.name = name;
        this.sizeCentimeter = sizeCentimeter;
        this.$predatory = $predatory;
        try {
            if ($predatory.equals("Да") || $predatory.equals("да")) this.predatory = true;
            else if ($predatory.equals("Нет")|| $predatory.equals("нет")) this.predatory = false;
            else throw new IllegalArgumentException("Неправильно введено хищничество");
        }
        catch (IllegalArgumentException e){
            System.out.println("Введённый параметр хищничества не соответствует да/нет");
            System.out.println("Измените параметр с помощью команды меню №3");
        }
    }

    //Конструктор без параметров
    public Animals() {
        this.name = "";
        this.sizeCentimeter = 0.0;
        this.predatory = false;
        this.$predatory = "Нет";
    }

    //Питаться, для травоядных (без требуемого объекта)
    public void eat() {
        if (getPredatory()) {
            System.out.println("Для хищного животного требуется другое животное");
        } else {
            System.out.println("Животное ест растение...");
        }
    }

    //Питаться, для хищных
    //Проверка на вид(свой-чужой), размер
    public void eat(Animals animal) {
        if (getPredatory()) {
            System.out.println("Животное ест: " + animal.getName() + "...");
        } else {
            System.out.println("Текущее животное не хищное");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getSizeCentimeter() {
        return sizeCentimeter;
    }

    public void setSizeCentimeter(double sizeCentimeter) {
        this.sizeCentimeter = sizeCentimeter;
    }

    public boolean getPredatory() {
        return predatory;
    }

    public void setPredatory(boolean predatory) {
        this.predatory = predatory;
    }

    public String get$predatory(){return $predatory;}
    public void set$predatory(String $predatory) throws IllegalArgumentException{
        try {
            if ($predatory.equals("Да") || $predatory.equals("да")) {
                this.$predatory = $predatory;
                this.predatory = true;
            }
            else if ($predatory.equals("Нет") || $predatory.equals("нет")) {
                this.$predatory = $predatory;
                this.predatory = false;
            }
            else
                throw new IllegalArgumentException("Введён неправильный аргумент хищничества");

        }
        catch (IllegalArgumentException e){
            System.out.println("Введён неправильный аргумент хищничества");
            System.out.println("Введите хищничество заново (да/нет)");
            set$predatory(read.nextLine());
        }

    }


    @Override
    public String toString() {
        return "Название: " + name + " Размер животного, см: " + sizeCentimeter + " Хищное: " + $predatory;
    }
}


//Птицы
class Bird extends Animals {

    public static List<Bird> birds = new ArrayList<>();

    //Конструктор с параметрами
    public Bird(String name, double sizeCentimeter, String $predatory) {
        super(name, sizeCentimeter, $predatory);
        try {
            if (sizeCentimeter < 5.7 || sizeCentimeter > 363.0) {
                throw new IllegalArgumentException("Введён неправильный размер");
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Введённый размер не соответствует размеру настоящей птицы");
            System.out.println("Измените размер с помощью команды меню №3");

        }
    }

    //Конструктор без параметров
    public Bird() {
        super("", 0, "Нет");
    }
}

//Млекопитающие
class Mammal extends Animals {
    public static List<Mammal> mammals = new ArrayList<>();
    //Конструктор c параметрами
    public Mammal(String name, double sizeCentimeter, String $predatory) throws IllegalArgumentException {
        super(name, sizeCentimeter, $predatory);
        if (sizeCentimeter < 3.8 || sizeCentimeter > 2450.0) {
            throw new IllegalArgumentException("Введён неправильный размер");
        }
    }

    //Конструктор без параметров
    public Mammal() {
        super("", 0, "Нет");
    }
}

//Пресмыкающиеся
class Reptile extends Animals {
    public static List<Reptile> reptiles = new ArrayList<>();
    //Конструктор c параметрами
    public Reptile(String name, double sizeCentimeter, String $predatory) throws IllegalArgumentException {
        super(name, sizeCentimeter, $predatory);
        if (sizeCentimeter < 1.8 || sizeCentimeter > 600.0) {
            throw new IllegalArgumentException("Введён неправильный размер");
        }
    }

    //Конструктор без параметров
    public Reptile() {
        super("", 0, "Нет");
    }
}

//Земноводные
class Amphibian extends Animals {
    public static List<Amphibian> amphibians = new ArrayList<>();

    //Конструктор c параметрами
    public Amphibian(String name, double sizeCentimeter, String $predatory) throws IllegalArgumentException {
        super(name, sizeCentimeter, $predatory);
        if (sizeCentimeter < 0.8 || sizeCentimeter > 180.0) {
            throw new IllegalArgumentException("Введён неправильный размер");
        }
    }

    //Конструктор без параметров
    public Amphibian() {
        super("", 0, "Нет");
    }

}

//Рыбы
class Fish extends Animals {
    public static List<Fish> fish = new ArrayList<>();
    //Конструктор c параметрами
    public Fish(String name, double sizeCentimeter, String $predatory) throws IllegalArgumentException {
        super(name, sizeCentimeter, $predatory);
        if (sizeCentimeter < 0.79 || sizeCentimeter > 2000.0) {
            throw new IllegalArgumentException("Введён неправильный размер");
        }
    }

    //Конструктор без параметров
    public Fish() {
        super("", 0, "Нет");
    }

}