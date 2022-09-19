package com.github.nez;

import com.github.nez.myobject.financialobjects.Fundamentals;
import com.github.nez.myobject.financialobjects.UpcomingEvent;


public class MainApplication{
    public static void main(String[] args) {

//        SpringApplication.run(MainApplication.class,args);

//        IEX iex = new IEX("WMT","upcoming-events");
//        iex.connect();
//        System.out.println(iex.getJson());

        UpcomingEvent wmt = new UpcomingEvent("wmt");
        Fundamentals tgt = new Fundamentals("tgt");
        System.out.println(tgt.toString());
//        System.out.println(tgt.getTicker()+" "+tgt.getType());
        tgt.createPopulatedObject();
        System.out.println(tgt.getJson());



    }
}
