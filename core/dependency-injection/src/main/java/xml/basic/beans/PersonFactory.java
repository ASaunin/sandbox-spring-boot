package xml.basic.beans;

public class PersonFactory {

    public Person createPerson(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, age);
    }

}
