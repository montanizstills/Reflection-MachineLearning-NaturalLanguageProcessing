package test_iex_api;

import com.github.nez.iexapi.IEX;
import com.github.nez.iexapi.IEXBuilder;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.Assert;

public class Test_IEXBuilder {

    @Test
    public void Test0(){
        //given
        IEX iexObjectUsingClassConstructor;
        IEX iexObjectUsingBuilder;

        //when
        iexObjectUsingClassConstructor = new IEX();
        iexObjectUsingBuilder = new IEXBuilder().createIEX();

        //then
        Assert.assertThat(iexObjectUsingBuilder, Is.isA(iexObjectUsingBuilder.getClass()));
    }
}
