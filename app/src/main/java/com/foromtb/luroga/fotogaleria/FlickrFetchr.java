package com.foromtb.luroga.fotogaleria;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LuisR on 10/07/2017.
 */

public class FlickrFetchr {

    public byte[] getUrlBytes (String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            InputStream inputStream = connection.getInputStream();

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                throw new IOException(connection.getResponseMessage());
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024] ;

            while((bytesRead = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,bytesRead);
            }
            outputStream.close();
            return outputStream.toByteArray();

        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString (String urlSpec) throws IOException{
        return new String (getUrlBytes(urlSpec));
    }
}
