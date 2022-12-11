package main.java;

import javax.xml.bind.annotation.*;
import java.util.*;

//Абстрактный класс животные
@XmlRootElement
public abstract class Animals {
    static Scanner read = new Scanner(System.in);
    private String name;
    private double sizeCentimeter;
    public boolean predatory;
    private String predatoryYN;

    //Конструктор c параметрами
    public Animals(String name, double sizeCentimeter, String predatoryYN) {
        this.name = name;
        this.sizeCentimeter = sizeCentimeter;
        this.predatoryYN = predatoryYN;
        try {
            if (predatoryYN.equals("Да") || predatoryYN.equals("да")) this.predatory = true;
            else if (predatoryYN.equals("Нет") || predatoryYN.equals("нет")) this.predatory = false;
            else throw new IllegalArgumentException("Неправильно введено хищничество");
        } catch (IllegalArgumentException e) {
            System.out.println("Введённый параметр хищничества не соответствует да/нет");
            System.out.println("Измените параметр с помощью команды меню №3");
        }
    }

    //Конструктор без параметров
    public Animals() {
        this.name = "";
        this.sizeCentimeter = 0.0;
        this.predatory = false;
        this.predatoryYN = "Нет";
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @XmlElement
    public double getSizeCentimeter() {
        return sizeCentimeter;
    }

    public void setSizeCentimeter(double sizeCentimeter) {
        this.sizeCentimeter = sizeCentimeter;
    }

    @XmlElement
    public String getPredatoryYN() {
        return predatoryYN;
    }

    public void setPredatoryYN(String predatoryYN) throws IllegalArgumentException {
        try {
            if (predatoryYN.equals("Да") || predatoryYN.equals("да")) {
                this.predatoryYN = predatoryYN;
                this.predatory = true;
            } else if (predatoryYN.equals("Нет") || predatoryYN.equals("нет")) {
                this.predatoryYN = predatoryYN;
                this.predatory = false;
            } else throw new IllegalArgumentException("Введён неправильный аргумент хищничества");

        } catch (IllegalArgumentException e) {
            System.out.println("Введён неправильный аргумент хищничества");
            System.out.println("Введите хищничество заново (да/нет)");
            setPredatoryYN(read.nextLine());
        }

    }


    @Override
    public String toString() {
        return "Название: " + name + ", Размер животного, см: " + sizeCentimeter + ", Хищное: " + predatoryYN;
    }
}


//Птицы
@XmlRootElement
class Bird extends Animals {

    public static List<Bird> birds = new ArrayList<>();

    //Конструктор с параметрами
    public Bird(String name, double sizeCentimeter, String predatoryYN) {
        super(name, sizeCentimeter, predatoryYN);
        try {
            if (sizeCentimeter < 5.7 || sizeCentimeter > 363.0) {
                throw new IllegalArgumentException("Введён неправильный размер");
            }
        } catch (IllegalArgumentException e) {
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
@XmlRootElement
class Mammal extends Animals {
    public static List<Mammal> mammals = new ArrayList<>();

    //Конструктор c параметрами
    public Mammal(String name, double sizeCentimeter, String predatoryYN) throws IllegalArgumentException {
        super(name, sizeCentimeter, predatoryYN);
        try {
            if (sizeCentimeter < 3.8 || sizeCentimeter > 2450.0) {
                throw new IllegalArgumentException("Введён неправильный размер");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Введённый размер не соответствует размеру настоящего млекопитающего");
            System.out.println("Измените размер с помощью команды меню №3");
        }
    }

    //Конструктор без параметров
    public Mammal() {
        super("", 0, "Нет");
    }
}

//Пресмыкающиеся
@XmlRootElement
class Reptile extends Animals {
    public static List<Reptile> reptiles = new ArrayList<>();

    //Конструктор c параметрами
    public Reptile(String name, double sizeCentimeter, String predatoryYN) throws IllegalArgumentException {
        super(name, sizeCentimeter, predatoryYN);
        try {
            if (sizeCentimeter < 1.8 || sizeCentimeter > 600.0) {
                throw new IllegalArgumentException("Введён неправильный размер");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Введённый размер не соответствует размеру настоящего пресмыкающегося (рептилии)");
            System.out.println("Измените размер с помощью команды меню №3");

        }
    }

    //Конструктор без параметров
    public Reptile() {
        super("", 0, "Нет");
    }
}

//Земноводные
@XmlRootElement
class Amphibian extends Animals {
    public static List<Amphibian> amphibians = new ArrayList<>();

    //Конструктор c параметрами
    public Amphibian(String name, double sizeCentimeter, String predatoryYN) throws IllegalArgumentException {
        super(name, sizeCentimeter, predatoryYN);
        try {
            if (sizeCentimeter < 0.8 || sizeCentimeter > 180.0) {
                throw new IllegalArgumentException("Введён неправильный размер");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Введённый размер не соответствует размеру настоящего земноводного (амфибии)");
            System.out.println("Измените размер с помощью команды меню №3");

        }
    }

    //Конструктор без параметров
    public Amphibian() {
        super("", 0, "Нет");
    }

}

//Рыбы
@XmlRootElement
class Fish extends Animals {
    public static List<Fish> fish = new ArrayList<>();

    //Конструктор c параметрами
    public Fish(String name, double sizeCentimeter, String predatoryYN) throws IllegalArgumentException {
        super(name, sizeCentimeter, predatoryYN);
        try {
            if (sizeCentimeter < 0.79 || sizeCentimeter > 2000.0) {
                throw new IllegalArgumentException("Введён неправильный размер");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Введённый размер не соответствует размеру настоящей рыбы");
            System.out.println("Измените размер с помощью команды меню №3");

        }
    }

    //Конструктор без параметров
    public Fish() {
        super("", 0, "Нет");
    }

}