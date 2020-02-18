package com.github.nez;

import com.github.nez.iexapi.IEX;
import com.github.nez.iexapi.IEXBuilder;
import com.github.nez.myobject.MyObject;
import com.github.nez.myobject.financialobjects.Quote;

public class MainApplication<T extends MyObject> {

    public <T extends MyObject> T create(String ticker, String type){

        //         create the empty financialObject
        T myObject = (T) new MyObject<>().createSubclassOfType(ticker,type);

        //         create the json
        IEX iex = new IEXBuilder()
                .setTicker(myObject.getTicker())
                .setType(myObject.getType())
                .createIEX();
        iex.connect();

        //        set the object's json
        myObject.setJson(iex.getJson());

        //     use json to fill in the financialObject's fields
       myObject = (T) myObject.populateFields();

        return myObject;
    }

    public static void main(String[] args){
        MainApplication ma = new MainApplication();
        MyObject myObject = ma.create("aapl","Quote");


        System.out.println(myObject.getResultOfMethod("CompanyName"));

//        decipherMessage("Hello, $aapl.Earnings.Actual");

    }
}
