package fr.aceko.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {


    @Test
    void whenCreatingPerson_withoutFirstName_throwException() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, "LASTNAME"));
        assertThrows(IllegalArgumentException.class, () -> new Person("", "LASTNAME"));
    }

    @Test
    void whenCreatingPerson_withoutLastName_throwException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Steeve", ""));
        assertThrows(IllegalArgumentException.class, () -> new Person("Steeve", null));
    }
}