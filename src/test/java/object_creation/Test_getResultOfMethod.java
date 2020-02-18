package object_creation;

import com.github.nez.myobject.MyObject;
import org.junit.Assert;
import org.junit.Test;

public class Test_getResultOfMethod {
    @Test
    public void Test0(){
        //given
        String expected = "Apple, Inc.";
        //when
        MyObject myObject = new MyObject().createSubclassOfType("aapl","quote");
        String actual = myObject.getResultOfMethod("CompanyName");
        //then
        Assert.assertEquals(actual,expected);
    }
}
