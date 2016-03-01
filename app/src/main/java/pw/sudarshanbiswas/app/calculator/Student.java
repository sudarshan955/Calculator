package pw.sudarshanbiswas.app.calculator;

import java.io.Serializable;

/**
 * Created by Sudarshan Biswas on 3/2/2016.
 */
public class Student implements Serializable {

    private String id, firstName, lastName;

    public void addStudent(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
