package com.github.nez.myobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.iexapi.IEX;
import com.github.nez.iexapi.IEXBuilder;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MyObject<T extends MyObject> {
    private String json;
    private String ticker;
    private String type;

    public MyObject(){}
    public MyObject(String ticker,String type){
        this.ticker=ticker;
        this.type=type;
    }

    public T createSubclassOfType(String ticker, String type){
        try {
            Class clazz = Class.forName("com.github.nez.myobject.financialobjects."+type);
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            T newInstance = constructor.newInstance();
            newInstance.setTicker(ticker);
            newInstance.setType(type);
            return newInstance;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new Error(e);
        }
    }

    public T populateFields() {
        try {
           String json = this.getJson();
           Class clazz = this.getClass();
            System.out.println(json);
            System.out.println(clazz);

         return (T) new ObjectMapper().readValue(json,clazz);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public String getResultOfMethod(String subclassMethod){
        try{
            Method method = this.getClass().getMethod("get"+subclassMethod);
            Object x = method.invoke(this,null);
            return  (String)x;
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

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
