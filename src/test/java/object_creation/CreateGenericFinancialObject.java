package object_creation;

import com.github.nez.myobject.MyObject;
import com.github.nez.myobject.MyObjectBuilder;
import com.github.nez.myobject.financialobjects.Quote;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;

public class CreateGenericFinancialObject<T extends MyObject> {

    @Test
    public void Test0(){
        //given
        String type = "Quote";
        Quote myNonGenericExample = new Quote();

        //when
        T myGenericObject = (T) new MyObjectBuilder<>().setTicker(null).createSubclassOfType(type);

        //then
        Assert.assertThat(myGenericObject, isA(myNonGenericExample.getClass()));
    }
}
