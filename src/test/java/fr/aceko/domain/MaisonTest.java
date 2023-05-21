package fr.aceko.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MaisonTest {

    @Test
    void whenCreateMaisonWithNomEmptyOrNull_thenThrowException(){
        assertThrows(IllegalArgumentException.class, () -> new Maison("", 2000, "ADRESSE"));
        assertThrows(IllegalArgumentException.class, () -> new Maison(null, 2000, "ADRESSE"));
    }

    @Test
    void whenCreateMaisonWithPrixLessThan0_thenThrowException(){
        assertThrows(IllegalArgumentException.class, () -> new Maison("NOM", -2000, "ADRESSE"));
    }

}