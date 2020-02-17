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

    public <T extends MyObject> T populateFields() {
        try {
         return (T) new ObjectMapper().readValue(this.getJson(),this.getClass());
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public String getResultOfMethod(String Method){
        try{
            Method method = this.getClass().getMethod("get"+Method);
            return  method.invoke(this,null).toString();
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
