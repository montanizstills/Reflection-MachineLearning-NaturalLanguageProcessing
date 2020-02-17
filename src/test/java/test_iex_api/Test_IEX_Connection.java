package test_iex_api;

import com.github.nez.iexapi.IEX;
import com.github.nez.iexapi.IEXBuilder;
import org.junit.Test;

public class Test_IEX_Connection {

    @Test
    public void Test0(){
        //given
        String test_company = "aapl";
        String test_type="quote";

        //when
        IEX connection = new IEXBuilder().setTicker(test_company).setType(test_type).createIEX();

        //then

    }
}
