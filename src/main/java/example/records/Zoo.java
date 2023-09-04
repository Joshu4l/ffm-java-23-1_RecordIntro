package example.records;

/*
    Erstellt ein neues Projekt in IntelliJ und legt damit den Grundstein für das Java-Record Zoo Projekt:
    - Lege eine Java-Record-Klasse "Animal" an, die geeignete Felder für die Eigenschaften
      ID, Name, Art und Alter haben soll.

    #Record-Methoden aufrufen (automatisch generierte Methoden prüfen)
    - Erstellt mehrere Animals in einer main-Methode.
    - Ruft die automatisch im Record generierten Methoden auf
      und prüft, ob sie das tun, was ihr erwartet (equals, toString).

    #Verschachtelung (einen Record als Attribut eines anderen Records verwenden).
    - Legt nun einen `Owner`-Record an, der einige Eigenschaften eines Tierbesitzers speichert
      (Name, Alter, Adresse).
    - Lasst jedes `Animal` einen `Owner` haben.

    #Verschachtelung & Wiederverwendung (Einen Record in mehreren anderen Records verwenden).
    - Erstellt einen `Species`-Record, der die Eigenschaften einer Tierart speichert (Name, Futterbedarf in Gramm pro Tag).
    - Lasst jedes `Animal` eine `Species` haben.
    - In Eurer main-Methode, lasst mehrere `Animal`-Objekte die gleiche `Species` haben.

    #Bonus-Aufgabe (With-Methoden)
    - Schreibe with-Methoden ('wither', so wie bei den Recherche-Fragen) für alle Eigenschaften des `Animal`-Records.

    #Bonus-Aufgabe (Zoo)
    - Implementiere einen "Zoo"-Record, der eine Liste aller Animals hat und den Gesamtfutterbedarf aller Tiere im Zoo berechnen kann.
 */

import java.util.ArrayList;
import java.util.List;

public record Zoo(

    String name,
    List<Animal> animals

) {

    //CONSTRUCTORS
    public Zoo(String name) {
        // Assignment is BASED ON THE ORDER of the attributes above

        // TODO: warum funktioniert folgendes...
        this(name, new ArrayList<>());

        //TODO: ...aber folgendes nicht:
        //this.name = name;
        //this.animals = new ArrayList<>();


    }
    public Zoo(String name, List<Animal> animals) {
        this.name = name;
        this.animals = animals;
    }

    // METHOD FOR ADDING ANIMALS TO THE ZOO
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public int calculateTotalFoodAmount() {

        int foodAmount = 0;
        for (Animal animal : animals) {
             foodAmount +=animal.species().foodRationPerDayInGrams();
        }
        return foodAmount;
    }

}
