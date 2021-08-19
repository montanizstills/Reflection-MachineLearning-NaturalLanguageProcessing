package com.github.nez.myobject.financialobjects;

import com.github.nez.iexapi.IEX;

public class UpcomingEvent {

    private String TICKER;
    private String result;

    public UpcomingEvent(String ticker) {
        this.TICKER = ticker;
        this.result = new IEX().getJson(this.TICKER, "upcoming-events");
    }

    public String getTICKER() {
        return TICKER;
    }

    public void setTICKER(String TICKER) {
        this.TICKER = TICKER;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
