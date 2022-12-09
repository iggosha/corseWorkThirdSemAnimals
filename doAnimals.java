package main.java;

import java.util.*;

public class doAnimals {

    static Scanner read = new Scanner(System.in);
    int numChoiceMenu, numChoiceGroup;

    public void showMenu() {
        System.out.println("Введите команду: ");
        System.out.println("1. Добавить животное");
        System.out.println("2. Удалить животное");
        System.out.println("3. Изменить параметры животного");
        System.out.println("4. Выбрать группу животных для отображения");
        System.out.println("5. Сохранить в XML");
        System.out.println("6. Читать XML");
        System.out.println("7. Завершить работу программы");
        numChoiceMenu = inputNumInt();
        switch (numChoiceMenu) {
            case 1:
                System.out.println("Выберите группу животных для добавления: ");
                System.out.println("1. Птицы");
                System.out.println("2. Млекопитающие");
                System.out.println("3. Пресмыкающиеся");
                System.out.println("4. Земноводные");
                System.out.println("5. Рыбы");
                numChoiceGroup = inputNumInt();
                switch (numChoiceGroup) {
                    case 1: {
                        addBird();
                        break;
                    }
                    case 2: {
                        addMammal();
                        break;
                    }
                    case 3: {
                        addReptile();
                        break;
                    }
                    case 4: {
                        addAmphibian();
                        break;
                    }
                    case 5: {
                        addFish();
                        break;
                    }
                    default: {
                        break;
                    }
                }
                showMenu();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default: {
                showMenu();
                break;
            }
        }
    }

    public void addBird() {
        read.nextLine();
        System.out.println("Введите название птицы: ");
        String name = read.nextLine();
        System.out.println("Введите размер птицы в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность птицы (да/нет): ");
        String $predatory = read.nextLine();
        Bird.birds.add(new Bird(name, size, $predatory));
        System.out.println("Добавлена птица с параметрами: " + name + " " + size + " " + $predatory);
    }

    public void addMammal() {
        read.nextLine();
        System.out.println("Введите название млекопитающего: ");
        String name = read.nextLine();
        System.out.println("Введите размер млекопитающего в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность млекопитающего (да/нет): ");
        String $predatory = read.nextLine();
        Mammal.mammals.add(new Mammal(name, size, $predatory));
        System.out.println("Добавлено млекопитающее с параметрами: " + name + " " + size + " " + $predatory);
    }

    public void addReptile() {
        read.nextLine();
        System.out.println("Введите название пресмыкающегося (рептилии): ");
        String name = read.nextLine();
        System.out.println("Введите размер пресмыкающегося(рептилии) в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность пресмыкающегося (рептилии) (да/нет): ");
        String $predatory = read.nextLine();
        Reptile.reptiles.add(new Reptile(name, size, $predatory));
        System.out.println("Добавлено пресмыкающееся(рептилия) с параметрами:" + name + " " + size + " " + $predatory);
    }

    public void addAmphibian() {
        read.nextLine();
        System.out.println("Введите название земноводного (амфибии): ");
        String name = read.nextLine();
        System.out.println("Введите размер земноводного (амфибии) в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность земноводного (амфибии) (да/нет): ");
        String $predatory = read.nextLine();
        Amphibian.amphibians.add(new Amphibian(name, size, $predatory));
        System.out.println("Добавлено земноводного (амфибия) с параметрами: " + name + " " + size + " " + $predatory);
    }

    public void addFish() {
        read.nextLine();
        System.out.println("Введите название рыбы: ");
        String name = read.nextLine();
        System.out.println("Введите размер рыбы в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность рыбы (да/нет): ");
        String $predatory = read.nextLine();
        Fish.fish.add(new Fish(name, size, $predatory));
        System.out.println("Добавлена рыбы с параметрами: " + name + " " + size + " " + $predatory);
    }

    public double inputNumDouble(){
        double size;
        try {
            if (read.hasNextDouble()){
                size = read.nextDouble();
                read.nextLine();
            }
            else throw new InputMismatchException("!!! Неправильный ввод числа !!!");
        } catch (InputMismatchException e) {
            read.nextLine();
            System.out.println("!!! Неправильный ввод числа !!!");
            return 0;
        }
        return size;
    }

    public int inputNumInt(){
        int numInt;
        try {
            if (read.hasNextInt()){
                numInt = read.nextInt();
            }
            else throw new InputMismatchException("!!! Неправильный ввод числа !!!");
        } catch (InputMismatchException e) {
            read.nextLine();
            System.out.println("!!! Неправильный ввод числа !!!");
            System.out.println("Введите заново: ");
            numInt = inputNumInt();
        }
        return numInt;
    }
}
