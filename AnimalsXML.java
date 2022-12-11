package main.java;

import javax.xml.bind.annotation.*;
import java.util.*;
import javax.xml.bind.*;
import java.io.*;

@XmlType
@XmlRootElement
public class AnimalsXML {

    @XmlElementWrapper
    @XmlElement
    public List<Object> allAnimals = new ArrayList<>();

    @Override
    public String toString() {
        return "AnimalsXML{" + "allAnimals=" + allAnimals + '}';
    }
}
