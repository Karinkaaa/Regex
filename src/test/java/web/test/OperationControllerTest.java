package test.java.web.test;

import main.java.web.components.OperationComponent;
import org.junit.Assert;
import org.junit.Test;

public class OperationControllerTest {

    @Test
    public void testAdd() {
        OperationComponent oc = new OperationComponent();
        int param1 = 1;
        int param2 = 2;
        int expect = 3;
        Assert.assertEquals(expect, oc.add(param1, param2));
    }
}