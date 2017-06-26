package ru.task1;

import org.apache.xalan.xsltc.compiler.util.Type;
import org.apache.xpath.operations.String;
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
        assert(!(n.getClass().isPrimitive()));
    }
}
