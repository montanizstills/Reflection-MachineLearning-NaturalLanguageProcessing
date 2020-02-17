package com.github.nez.myobject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyObjectBuilder<T extends MyObject> {
    private String ticker;
    private String type;

    public T createSubclassOfType(String financialObjectType){
        try {
            Class clazz = Class.forName("com.github.nez.myobject.financialobjects."+financialObjectType);
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new Error(e);
        }
    }

    public MyObject createMyObject() {
        return new MyObject(ticker, type);
    }

//////////////////////////////////////////////////////////////////
//    Getter and Setters
////////////////////////////////////////////////////////////////

    public MyObjectBuilder setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public MyObjectBuilder setType(String type) {
        this.type = type;
        return this;
    }
}