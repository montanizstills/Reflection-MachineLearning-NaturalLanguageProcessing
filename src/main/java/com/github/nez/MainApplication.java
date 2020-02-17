package com.github.nez;

import com.github.nez.iexapi.IEX;
import com.github.nez.iexapi.IEXBuilder;
import com.github.nez.myobject.MyObject;
import com.github.nez.myobject.MyObjectBuilder;

public class MainApplication {

    public  <T extends MyObject> T create(){

        //         create the empty financialObject
        T myObject = (T) new MyObjectBuilder<>().createSubclassOfType("Quote");

        myObject.setTicker("aapl");
        myObject.setType("quote");

        System.out.println("Ticker is: "+myObject.getTicker());
        System.out.println("Type is: "+myObject.getType());

        //         create the json
        IEX iex = new IEXBuilder()
                .setTicker(myObject.getTicker())
                .setType(myObject.getType())
                .createIEX();
        iex.connect();
        System.out.println(iex.getJson());

        //        set the object's json
        myObject.setJson(iex.getJson());
        System.out.println(myObject.getJson());

        //     use json to fill in the finanicalObject's fields
        myObject.populateFields();
        myObject.getResultOfMethod("CompanyName");
        return myObject;
    }

    public static void main(String[] args) {
        Object obj = new MainApplication().create();
        //        decipherMessage("Hello, $aapl.Earnings.Actual");

    }
}
