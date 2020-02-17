package com.github.nez.iexapi;

public class IEXBuilder {
    private String ticker;
    private String type;

    public IEXBuilder setTicker(String ticker) {
        this.ticker = ticker.toLowerCase();
        return this;
    }

    public IEXBuilder setType(String type) {
        this.type = type.toLowerCase();
        return this;
    }

    public IEX createIEX() {
        return new IEX(ticker, type);
    }
}