package test_iex_api;

import com.github.nez.iexapi.IEX;
import com.github.nez.iexapi.IEXBuilder;
import org.junit.Assert;
import org.junit.Test;

public class Test_IEX_Connection_Response {

    @Test
    public void Test0(){
        //given
        String response = null;
        IEX myConnection = new IEXBuilder().setTicker("aapl").setType("quote").createIEX();

        //when
        myConnection.connect();
        response = myConnection.getJson();

        //then
        Assert.assertNotEquals(null,response);
    }
}
