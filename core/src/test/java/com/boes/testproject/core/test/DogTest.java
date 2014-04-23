package com.boes.testproject.core.test;

import com.boes.testproject.core.Dog;

import org.junit.Test;
import static org.junit.Assert.*;

public class DogTest {

    @Test public void twoDogsShouldBeEqual() {
        Dog aDog = new Dog("Bucky", true);
        Dog anotherDog = new Dog(0, "Bucky", true);
        assertEquals(anotherDog, aDog);
    }

}
