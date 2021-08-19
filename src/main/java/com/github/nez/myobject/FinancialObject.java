package com.github.nez.myobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.iexapi.IEX;
import com.github.nez.iexapi.IEXBuilder;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FinancialObject<T extends FinancialObject> {
    private String json;
    private String ticker;
    private String type;


    public FinancialObject(){}
    public FinancialObject(String ticker, String type){
        this.ticker=ticker;
        this.type=type;
    }

    public T createSubclassOfType(){
        try {
            Class clazz = Class.forName("com.github.nez.myobject.financialobjects."+this.type);
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            T newInstance = constructor.newInstance();
            newInstance.setTicker(this.ticker);
            newInstance.setType(this.type);
            return newInstance;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new Error(e);
        }
    }


    public T populateFields() {
        try {
//            this = (T) new ObjectMapper().readValue(this.getJson(),this.getClass());
         return (T) new ObjectMapper().readValue(this.getJson(),this.getClass());
        } catch (IOException e) {
            throw new Error(e);
        }
    }


    public T createPopulatedObject(){

        //         create the empty financialObject
        T myObject = (T) new FinancialObject<>().createSubclassOfType();

        //         create the json
        IEX iex = new IEXBuilder()
                .setTicker(myObject.getTicker())
                .setType(myObject.getType())
                .createIEX();
        iex.connect();

        //        set the object's json
        myObject.setJson(iex.getJson());

        //     use json to fill in the financialObject's fields
        return (T) myObject.populateFields();
    }

    public String getResultOfMethod(String subclassMethod){
        try{
            Method method = this.getClass().getMethod("get"+subclassMethod);
            return method.invoke(this,null).toString();
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

    public FinancialObject setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public String getType() {
        return type;
    }

    public FinancialObject setType(String type) {
        this.type = type;
        return this;
    }
}
