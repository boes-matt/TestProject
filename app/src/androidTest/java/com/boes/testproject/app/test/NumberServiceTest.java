package com.boes.testproject.app.test;

import android.content.Intent;
import android.test.ServiceTestCase;

import com.boes.testproject.app.NumberService;

public class NumberServiceTest extends ServiceTestCase<NumberService> {

    public NumberServiceTest() {
        super(NumberService.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        assertNull(getService());

        Intent intent = new Intent(getSystemContext(), NumberService.class);
        bindService(intent);
    }

    public void testStartedService() {
        assertNotNull(getService());
    }

    public void testNextNumber() {
        NumberService service = getService();
        assertNotNull(service);

        assertEquals("Wrong number", 1, service.sendNextNumber());
        assertEquals("Wrong number", 2, service.sendNextNumber());
    }

}
