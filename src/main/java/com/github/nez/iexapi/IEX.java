package com.github.nez.iexapi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IEX {
    private String type;
    private String ticker;
    private InputStream response;
    private String json;
    //"https://cloud.iexapis.com/v1/stock/"
    private String uncleanURL="https://sandbox.iexapis.com/v1/stock/";
    private URL cleanURL;
    private URLConnection connection;

    public IEX(){}

    public IEX(String ticker, String type){
        this.ticker = ticker;
        this.type = type;
    }

    public void createURL(){
        setUncleanURL(this.uncleanURL+this.getTicker()+"/"+this.getType()+"?token="+System.getenv("SANDBOX_TOKEN"));
        try {
            this.cleanURL = new URL(this.getUncleanURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void establishConnection(){
        try {
            this.connection = this.cleanURL.openConnection();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void catchResponse(){
        try {
            this.response = this.connection.getInputStream();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String convertConnectionStreamResponseToString(){
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        StringBuffer sb = new StringBuffer();
        try{
            while((json = br.readLine())!=null){sb.append(json);}
        } catch(Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void connect(){
        createURL();
        establishConnection();
        catchResponse();
        this.json = convertConnectionStreamResponseToString();
    }

    public String getJson(String ticker, String service){
        this.ticker=ticker;
        this.type =service;
        this.connect();
        return this.json;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
    // default getters and setters
////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getType() {
        return type.toLowerCase();
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public InputStream getResponse() {
        return response;
    }

    public void setResponse(InputStream response) {
        this.response = response;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getUncleanURL() {
        return uncleanURL;
    }

    public void setUncleanURL(String uncleanURL) {
        this.uncleanURL = uncleanURL;
    }

    public URL getCleanURL() {
        return cleanURL;
    }

    public void setCleanURL(URL cleanURL) {
        this.cleanURL = cleanURL;
    }

    public URLConnection getConnection() {
        return connection;
    }

    public void setConnection(URLConnection connection) {
        this.connection = connection;
    }
}


