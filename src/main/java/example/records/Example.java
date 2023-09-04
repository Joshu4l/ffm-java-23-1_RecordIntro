package example.records;

import javax.management.Descriptor;
import java.util.ArrayList;
import java.util.List;

public class Example {

    private String name;
    private String description;
    private List<String> myList;


    public Example (String name, String description) {
        this.name = name;
        this.description = description;
        this.myList = new ArrayList<>();
    }
}
