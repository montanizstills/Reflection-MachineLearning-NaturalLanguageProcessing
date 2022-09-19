package com.github.nez.myobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.iexapi.IEX;
import com.github.nez.iexapi.IEXBuilder;

import java.beans.ConstructorProperties;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FinancialObject<generic_financial_object extends FinancialObject> extends IEX{
    private String json;
    private String ticker;
    private String type;

//    @ConstructorProperties({"ticker"})
    public FinancialObject(String ticker, String type) {
        super(ticker,type);
        this.ticker = ticker;
        this.type = type;
    }

    public FinancialObject(String ticker) {
        new FinancialObject(ticker, this.getType());
        populateFields();
        createPopulatedObject();
    }

    public FinancialObject() {
    }


    public String toString(){
        return "Type: "+this.getType()+"\n Ticker: "+this.getTicker();
    }
    public generic_financial_object populateFields() {
        try {
//            this = (T) new ObjectMapper().readValue(this.getJson(),this.getClass());
            return (generic_financial_object) new ObjectMapper().readValue(this.getJson(), this.getClass());
        } catch (IOException e) {
            throw new Error(e);
        }
    }


    public generic_financial_object createPopulatedObject() {

        //         create the empty financialObject
        generic_financial_object genericFinancialObject = (generic_financial_object) new FinancialObject();


        genericFinancialObject.populateFields();

        //         create the json
        IEX iex = new IEXBuilder()
                .setTicker(genericFinancialObject.getTicker())
                .setType(genericFinancialObject.getType())
                .createIEX();
        iex.connect();

        //        set the object's json
        genericFinancialObject.setJson(iex.getJson());

        return null ;
    }

    public String getResultOfMethod(String subclassMethod) {
        try {
            Method method = this.getClass().getMethod("get" + subclassMethod);
            return method.invoke(this, null).toString();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new Error(e);
        }

    }

///////////////////////////////////////////////////////////////////
// Getters and Setters
/////////////////////////////////////////////////////////////////////

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getTicker() {
        return ticker;
    }

//    public FinancialObject setTicker(String ticker) {
//        this.ticker = ticker;
//        return this;
//    }

//    public String getType() {
//        return type;
//    }
//
//    public FinancialObject setType(String type) {
//        this.type = type;
//        return this;
//    }
}
