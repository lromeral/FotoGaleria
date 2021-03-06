package com.foromtb.luroga.fotogaleria;

import android.net.Uri;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LuisR on 10/07/2017.
 */

public class FlickrFetchr {

    private static final String API_KEY="8acfb5b32c4b3fd5ed3c64ac94e91e76";
    private static final String TAG="FlickrFetchr";

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

    public void fetchItems (){
        try{
            String url = Uri.parse("https://api.flickr.com/services/rest/")
                    .buildUpon()
                    .appendQueryParameter("method","flickr.photos.getRecent")
                    .appendQueryParameter("api_key",API_KEY)
                    .appendQueryParameter("format","json")
                    .appendQueryParameter("nojsoncallback","1")
                    .appendQueryParameter("extras","url_s")
                    .build().toString();

            Log.d ("URL->", getUrlString(url));

            String jsonString = getUrlString(url);

        } catch (IOException e) {
            Log.e("Error", e.toString());
        }
    }
}
