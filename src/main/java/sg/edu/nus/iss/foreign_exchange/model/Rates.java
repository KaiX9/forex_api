package sg.edu.nus.iss.foreign_exchange.model;

import jakarta.json.JsonObject;


public class Rates {
    
    private String sgd;

    private String usd;

    private String aud;

    private String cny;

    private String jpy;

    private String krw;

    private String myr;

    private String thb;

    private String twd;

    public String getSgd() {
        return sgd;
    }

    public void setSgd(String sgd) {
        this.sgd = sgd;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getCny() {
        return cny;
    }

    public void setCny(String cny) {
        this.cny = cny;
    }

    public String getJpy() {
        return jpy;
    }

    public void setJpy(String jpy) {
        this.jpy = jpy;
    }

    public String getKrw() {
        return krw;
    }

    public void setKrw(String krw) {
        this.krw = krw;
    }

    public String getMyr() {
        return myr;
    }

    public void setMyr(String myr) {
        this.myr = myr;
    }

    public String getThb() {
        return thb;
    }

    public void setThb(String thb) {
        this.thb = thb;
    }

    public String getTwd() {
        return twd;
    }

    public void setTwd(String twd) {
        this.twd = twd;
    }

    public static Rates createFromJSON(JsonObject o) {
        Rates rates = new Rates();
        rates.setAud(o.getJsonNumber("AUD").toString());
        rates.setCny(o.getJsonNumber("CNY").toString());
        rates.setJpy(o.getJsonNumber("JPY").toString());
        rates.setKrw(o.getJsonNumber("KRW").toString());
        rates.setMyr(o.getJsonNumber("MYR").toString());
        rates.setSgd(o.getJsonNumber("SGD").toString());
        rates.setThb(o.getJsonNumber("THB").toString());
        rates.setTwd(o.getJsonNumber("TWD").toString());
        rates.setUsd(o.getJsonNumber("USD").toString());

        return rates;
    }
}
