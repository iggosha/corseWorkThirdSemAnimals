package main.java;

import javax.xml.bind.annotation.*;
import java.util.*;
import javax.xml.bind.*;
import java.io.*;


import static javax.xml.bind.JAXBContext.newInstance;

@XmlRootElement
public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Животный мир. Пользовательское меню");
        doAnimals menu = new doAnimals();
        menu.showMenu();


    }

    static public void writeToXML() {
        AnimalsXML animalsXML = new AnimalsXML();
        animalsXML.allAnimals.addAll(Bird.birds);
        animalsXML.allAnimals.addAll(Mammal.mammals);
        animalsXML.allAnimals.addAll(Reptile.reptiles);
        animalsXML.allAnimals.addAll(Amphibian.amphibians);
        animalsXML.allAnimals.addAll(Fish.fish);
        String filePath = "infoXMl.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Main.class, Bird.class, Mammal.class, Reptile.class, Amphibian.class, Fish.class, AnimalsXML.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(animalsXML, new File(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("Данные сохранены в XML");
    }

    static public void readFromXML() {
        AnimalsXML animalsXML;
        String filePath = "infoXMl.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Main.class, Bird.class, Mammal.class, Reptile.class, Amphibian.class, Fish.class, AnimalsXML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            animalsXML = (AnimalsXML) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        for (Object obj : animalsXML.allAnimals) {
            if (obj instanceof Bird) {
                Bird.birds.add((Bird) obj);
            }
            if (obj instanceof Mammal) {
                Mammal.mammals.add((Mammal) obj);
            }
            if (obj instanceof Reptile) {
                Reptile.reptiles.add((Reptile) obj);
            }
            if (obj instanceof Amphibian) {
                Amphibian.amphibians.add((Amphibian) obj);
            }
            if (obj instanceof Fish) {
                Fish.fish.add((Fish) obj);
            }

        }

        System.out.println("Получены данные из XML-файла");
        System.out.println("Используейте функцию №4 для вывода");
    }
}
