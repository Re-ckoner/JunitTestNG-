package ru.task1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Andy on 25.06.2017.
 */
public class TestNGMock {
    @Test(groups = "positive")
    public void positiveMock(){
        assert(true);
    }
    @Test(groups = "negative")
    public void negativeMock(){
        Integer n = 1;
        Assert.assertTrue(!(n.getClass().isPrimitive()));
    }
}
