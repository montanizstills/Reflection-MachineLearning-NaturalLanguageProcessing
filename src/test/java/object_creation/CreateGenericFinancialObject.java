package object_creation;

import com.github.nez.myobject.FinancialObject;
import com.github.nez.myobject.financialobjects.Quote;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;

public class CreateGenericFinancialObject<T extends FinancialObject> {

    @Test
    public void Test0(){
        //given
        String type = "Quote";

        //when
        T myGenericObject = (T) new FinancialObject<>(null,type);

        //then
        Assert.assertThat(myGenericObject, isA(Quote.class));
    }
}
