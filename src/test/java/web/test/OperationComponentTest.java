package test.java.web.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class OperationComponentTest {

    @Test
    public void add() {

//        RandomNumberComponent component = new RandomNumberComponent() {
//            @Override
//            public int getRandom() {
//                return 5;
//            }
//        };

        RandomNumberComponent component = Mockito.mock(RandomNumberComponent.class);
        DataStore dataStore = new DataStore();

        Mockito.when(component.getRandom(5)).thenReturn(5);
        Mockito.when(component.getRandom(3)).thenReturn(1);
        //Mockito.when(component.getRandom(Mockito.anyInt())).thenReturn(5);

        OperationComponent oc = new OperationComponent(component, dataStore);

        int param1 = 1;
        int param2 = 2;
        int expected = 11;  // a = 1, b = 5, getRandom() = 5
        Assert.assertEquals(expected, oc.add(param1, param2));

        param1 = 5;
        param2 = 3;
        expected = 9;   // a = 5, b = 3, getRandom() = 1
        Assert.assertEquals(expected, oc.add(param1, param2));

        Mockito.verify(component, Mockito.times(2)).getRandom(Mockito.anyInt());

    }
}