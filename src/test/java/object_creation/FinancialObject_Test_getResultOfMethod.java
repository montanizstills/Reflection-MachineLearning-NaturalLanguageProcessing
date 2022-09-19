package object_creation;

import com.github.nez.myobject.FinancialObject;
import org.junit.Assert;
import org.junit.Test;

public class FinancialObject_Test_getResultOfMethod {
    @Test
    public void Test0(){
        //given
        String ticker = "AAPL";
        String type = "quote";
        String expected = "Apple, Inc.";
        //when
        FinancialObject myObject = new FinancialObject().setTicker(ticker).setType(type);
        String actual = myObject.getResultOfMethod("CompanyName");
        //then
        Assert.assertEquals(actual,expected);
    }
}
