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

public class Main {
    public static void main(String[] args) {

        // Instantiate a few species using the Species-record
        Species my1stSpecies = new Species("Tasmanian Tiger", 666);
        Species my2ndSpecies = new Species("Mouse Lemur", 200);
        Species my3rdSpecies = new Species("Penguin", 420);

        //Instantiate a few owners using the Owner-record
        Owner my1stOwner = new Owner("Herr Tierlieb", 62, "Am Tierpark 1");
        Owner my2ndOwner = new Owner("Rubeus Hagrid", 46, "Hüttenweg 3");

        // Instantiate a few animals using the Animal-record
        Animal my1stAnimal = new Animal("A-0001", "George", my1stSpecies, 5, my1stOwner);
        Animal my2ndAnimal = new Animal("A-0002", "Morty", my2ndSpecies, 3, my1stOwner);
        Animal my3rdAnimal = new Animal("A-0003", "Kowalski", my3rdSpecies, 6, my2ndOwner);
        Animal my4thAnimal = new Animal("A-0004", "Rico", my3rdSpecies, 4, my2ndOwner);
        // Intentionally create an object that has the same credentials as one other object
        Animal my5thAnimal = new Animal("A-0004", "Rico", my3rdSpecies, 4, my2ndOwner);


        // Try out some functionalities / record methods of the resulting instances,
        // in the following case: single attributes as well as toString...
        System.out.println("ID " + my1stAnimal.id() + " is assigned to: " + my1stAnimal);
        System.out.println("ID " + my2ndAnimal.id() + " is assigned to: " + my2ndAnimal);
        System.out.println("ID " + my3rdAnimal.id() + " is assigned to: " + my3rdAnimal);
        System.out.println("ID " + my4thAnimal.id() + " is assigned to: " + my4thAnimal);

        // Try out the equals method for both the 3rd and 4th animal object
        System.out.println("\nDespite having 2 separate objects, the 'equals'-evaluation for object 4 and 5 results in:");
        System.out.println(my4thAnimal.equals(my5thAnimal));

        // Besides that, try out some of the with-methods on the (so far equal) 5th animal
        Animal my5thAnimal_CorrectedID = my5thAnimal.withId("A-0005");
        System.out.println("\nAfter having the Id of the 5th animal corrected:");
        System.out.println(my5thAnimal_CorrectedID);
        System.out.println("New result of the 'equals'-evaluation for object 4 and 5:");
        System.out.println(my4thAnimal.equals(my5thAnimal_CorrectedID));

        Zoo my1stZoo = new Zoo("Zoomania");

    }
}