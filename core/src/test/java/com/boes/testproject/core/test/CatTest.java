package com.boes.testproject.core.test;

import com.boes.testproject.core.Cat;

import org.junit.Test;
import static org.junit.Assert.*;

public class CatTest {

    @Test public void catColorShouldBeOrange() {
        Cat aCat = new Cat("Orange");
        assertEquals("Orange", aCat.sendColor());
    }

}
