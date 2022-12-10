package main.java;

import java.util.*;
import javax.xml.bind.*;
import java.io.*;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Животный мир. Пользовательское меню");
        doAnimals menu = new doAnimals();
        menu.showMenu();

    }
}

