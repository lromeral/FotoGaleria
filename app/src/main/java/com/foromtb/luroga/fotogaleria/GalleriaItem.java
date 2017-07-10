package com.foromtb.luroga.fotogaleria;

/**
 * Created by LuisR on 10/07/2017.
 */

public class GalleriaItem {
    private String mEtiqueta;
    private String mId;
    private String mUrl;

    @Override
    public String toString(){
        return mEtiqueta;
    }

    public String getEtiqueta() {
        return mEtiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        mEtiqueta = etiqueta;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
