package com.github.nez;

import com.github.nez.myobject.MyObject;



public class MainApplication {

public String interpretMessage(String message){
    String response="";

    //clean word
    for (String word:message.split(" ")) {
     if(word.startsWith("$")){
//         if(word.endsWith(".")){
//             int lastDesiredIndex = word.length();
//             word=word.substring(1,lastDesiredIndex);
//         }
         word=word.substring(1);
         System.out.println(word);

         //prep and create myObject
         try{
             String ticker = word.split("[.]")[0];
             String type = word.split("[.]")[1];
             String method = word.split("[.]")[2];
             word = new MyObject<>().createSubclassOfType(ticker,type).getResultOfMethod(method);
             response+=word+" ";
         } catch (Exception e) {
             response+=word+" ";
         }
     }
        //add word to response
        response+=word+" ";
    }
    return response;
}

    public static void main(String[] args){
        System.out.println(new MainApplication().interpretMessage("fee fi fo fum $this word starts containing $aapl.Quote.CompanyName"));
//  yo did you see $aapl.Quote.CompanyName latest stock price? Its $aapl.Quote.LatestPrice.
//  Its a shame $aapl.Quote.CompanyName is only traded on $aapl.Quote.getExchange
    }
}
