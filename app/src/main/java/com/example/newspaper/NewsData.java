package com.example.newspaper;


import java.security.PrivateKey;
import java.util.Collection;

public class NewsData {

    private String itmeName;
    private String itmeDescription;
    private String itmeView;
    private int itmeImage;

    public NewsData(String itmeName, String itmeDescription, String itmeView, int itmeImage) {
        this.itmeName = itmeName;
        this.itmeDescription = itmeDescription;
        this.itmeView = itmeView;
        this.itmeImage = itmeImage;
    }

    public String getItmeName() {
        return itmeName;
    }

    public String getItmeDescription() {
        return itmeDescription;
    }

    public String getItmeView() {
        return itmeView;
    }

    public int getItmeImage() {
        return itmeImage;
    }


}

