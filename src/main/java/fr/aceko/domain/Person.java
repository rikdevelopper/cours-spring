package fr.aceko.domain;

public class Person {
    private static Long ID_COUNT = 1L;
    private final Long id;
    private String lastName;
    private String firstName;
    private String address;

    public Person(String firstName, String lastName) {
        this.id = ID_COUNT++;
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    protected void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("The firstname can not be null or empty.");
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("The lastname can not be null or empty.");
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }
}
