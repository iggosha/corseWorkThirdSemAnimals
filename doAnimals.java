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
            //Добавление
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
            //Удаление
            case 2:
                break;
            //Изменение параметров
            case 3:
                break;
            //Показать животных
            case 4:
                break;
            //Сохранить в XML
            case 5:
                break;
            //Прочитать XML
            case 6:
                break;
            //Завершить программу
            case 7:
                break;
            //Неправильный ввод
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
        Bird bird = new Bird(name, size, $predatory);
        Bird.birds.add(bird);
        System.out.println("Добавлена птица с параметрами:\n"  + bird);
    }

    public void addMammal() {
        read.nextLine();
        System.out.println("Введите название млекопитающего: ");
        String name = read.nextLine();
        System.out.println("Введите размер млекопитающего в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность млекопитающего (да/нет): ");
        String $predatory = read.nextLine();
        Mammal mammal = new Mammal(name, size, $predatory);
        Mammal.mammals.add(mammal);
        System.out.println("Добавлено млекопитающее с параметрами:\n" + mammal);
    }

    public void addReptile() {
        read.nextLine();
        System.out.println("Введите название пресмыкающегося (рептилии): ");
        String name = read.nextLine();
        System.out.println("Введите размер пресмыкающегося(рептилии) в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность пресмыкающегося (рептилии) (да/нет): ");
        String $predatory = read.nextLine();
        Reptile reptile = new Reptile(name, size, $predatory);
        Reptile.reptiles.add(reptile);
        System.out.println("Добавлено пресмыкающееся(рептилия) с параметрами:\n" + reptile);
    }

    public void addAmphibian() {
        read.nextLine();
        System.out.println("Введите название земноводного (амфибии): ");
        String name = read.nextLine();
        System.out.println("Введите размер земноводного (амфибии) в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность земноводного (амфибии) (да/нет): ");
        String $predatory = read.nextLine();
        Amphibian amphibian = new Amphibian(name, size, $predatory);
        Amphibian.amphibians.add(amphibian);
        System.out.println("Добавлено земноводное (амфибия) с параметрами:\n" + amphibian);
    }

    public void addFish() {
        read.nextLine();
        System.out.println("Введите название рыбы: ");
        String name = read.nextLine();
        System.out.println("Введите размер рыбы в сантиметрах: ");
        double size = inputNumDouble();
        System.out.println("Введите хищность рыбы (да/нет): ");
        String $predatory = read.nextLine();
        Fish fish = (new Fish(name, size, $predatory));
        Fish.fish.add(fish);
        System.out.println("Добавлена рыба с параметрами:\n" + fish);
    }
    public static double inputNumDouble(){
        double numDouble;
        try {
            if (read.hasNextDouble()){
                numDouble = read.nextDouble();
                read.nextLine();
            }
            else throw new InputMismatchException("!!! Неправильный ввод числа !!!");
        } catch (InputMismatchException e) {
            read.nextLine();
            System.out.println("!!! Неправильный ввод числа !!!");
            System.out.println("Введите заново: ");
            read.nextLine();
            numDouble = inputNumDouble();
        }
        return numDouble;
    }

    public static int inputNumInt(){
        int numInt;
        try {
            numInt = read.nextInt();
            if(read.hasNextLine()){
                read.skip("");
            }
        } catch (InputMismatchException e) {
            read.nextLine();
            System.out.println("!!! Неправильный ввод числа !!!");
            System.out.println("Введите заново: ");
            numInt = inputNumInt();
        }
        return numInt;
    }
}
