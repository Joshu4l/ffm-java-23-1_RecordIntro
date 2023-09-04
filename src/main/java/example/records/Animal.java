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

    #Bonus-Aufgabe1 (With-Methoden)
    - Schreibe with-Methoden ('wither', so wie bei den Recherche-Fragen) für alle Eigenschaften des `Animal`-Records.

    #Bonus-Aufgabe2 (Zoo)
    - Implementiere einen "Zoo"-Record, der eine Liste aller Animals hat und den Gesamtfutterbedarf aller Tiere im Zoo berechnen kann.
 */

public record Animal(
        String id,
        String name,
        Species species,
        int age,
        Owner owner
) {

    // WITH-METHODEN
    public Animal withId(String newId) {
        // EXAMPLE SYNTAX EXPLANATION:
        // Simply take in what shall be changed as an argument, ...
        // ... then instantiate a new object with as we would've done normally, ...
        // ... but use the new Argument at the respective argument position:
        return new Animal(newId, name, species, age, owner);
    }

    public Animal withName(String newName) {

        return new Animal(id, newName, species, age, owner);
    }

    public Animal withSpecies(Species newSpecies) {

        return new Animal(id, name, newSpecies, age, owner);
    }

    public Animal withAge(int newAge) {

        return new Animal(id, name, species, newAge, owner);
    }

    public Animal withOwner(Owner newOwner) {

        return new Animal(id, name, species, age, newOwner);
    }

}