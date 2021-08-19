package com.github.nez.myobject.financialobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.nez.myobject.FinancialObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Earnings extends FinancialObject {
    private String symbol;
    private String actualEPS;
    private String consensusEPS;
    private String announceTime;
    private String numberOfEstimates;
    private String EPSSurpriseDollar;
    private String EPSReportDate;
    private String fiscalPeriod;
    private String fiscalEndDate;
    private String yearAgo;
    private String yearAgoChangePercent;

    public Earnings(){}

    public Earnings(String symbol, String actualEPS, String consensusEPS, String announceTime, String numberOfEstimates, String EPSSurpriseDollar, String EPSReportDate, String fiscalPeriod, String fiscalEndDate, String yearAgo, String yearAgoChangePercent) {
        this.symbol = symbol;
        this.actualEPS = actualEPS;
        this.consensusEPS = consensusEPS;
        this.announceTime = announceTime;
        this.numberOfEstimates = numberOfEstimates;
        this.EPSSurpriseDollar = EPSSurpriseDollar;
        this.EPSReportDate = EPSReportDate;
        this.fiscalPeriod = fiscalPeriod;
        this.fiscalEndDate = fiscalEndDate;
        this.yearAgo = yearAgo;
        this.yearAgoChangePercent = yearAgoChangePercent;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getActualEPS() {
        return actualEPS;
    }

    public void setActualEPS(String actualEPS) {
        this.actualEPS = actualEPS;
    }

    public String getConsensusEPS() {
        return consensusEPS;
    }

    public void setConsensusEPS(String consensusEPS) {
        this.consensusEPS = consensusEPS;
    }

    public String getAnnounceTime() {
        return announceTime;
    }

    public void setAnnounceTime(String announceTime) {
        this.announceTime = announceTime;
    }

    public String getNumberOfEstimates() {
        return numberOfEstimates;
    }

    public void setNumberOfEstimates(String numberOfEstimates) {
        this.numberOfEstimates = numberOfEstimates;
    }

    public String getEPSSurpriseDollar() {
        return EPSSurpriseDollar;
    }

    public void setEPSSurpriseDollar(String EPSSurpriseDollar) {
        this.EPSSurpriseDollar = EPSSurpriseDollar;
    }

    public String getEPSReportDate() {
        return EPSReportDate;
    }

    public void setEPSReportDate(String EPSReportDate) {
        this.EPSReportDate = EPSReportDate;
    }

    public String getFiscalPeriod() {
        return fiscalPeriod;
    }

    public void setFiscalPeriod(String fiscalPeriod) {
        this.fiscalPeriod = fiscalPeriod;
    }

    public String getFiscalEndDate() {
        return fiscalEndDate;
    }

    public void setFiscalEndDate(String fiscalEndDate) {
        this.fiscalEndDate = fiscalEndDate;
    }

    public String getYearAgo() {
        return yearAgo;
    }

    public void setYearAgo(String yearAgo) {
        this.yearAgo = yearAgo;
    }

    public String getYearAgoChangePercent() {
        return yearAgoChangePercent;
    }

    public void setYearAgoChangePercent(String yearAgoChangePercent) {
        this.yearAgoChangePercent = yearAgoChangePercent;
    }
}
