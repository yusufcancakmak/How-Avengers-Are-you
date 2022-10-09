package com.info.avengersuygulamas;

public class Avengers {
    private int avengers_id;
    private String avengers_ad;
    private String avengers_resim;

    public Avengers() {
    }

    public Avengers(int avengers_id, String avengers_ad, String avengers_resim) {
        this.avengers_id = avengers_id;
        this.avengers_ad = avengers_ad;
        this.avengers_resim = avengers_resim;
    }

    public int getAvengers_id() {
        return avengers_id;
    }

    public void setAvengers_id(int avengers_id) {
        this.avengers_id = avengers_id;
    }

    public String getAvengers_ad() {
        return avengers_ad;
    }

    public void setAvengers_ad(String avengers_ad) {
        this.avengers_ad = avengers_ad;
    }

    public String getAvengers_resim() {
        return avengers_resim;
    }

    public void setAvengers_resim(String avengers_resim) {
        this.avengers_resim = avengers_resim;
    }
}
