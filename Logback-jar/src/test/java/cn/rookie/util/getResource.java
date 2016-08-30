package cn.rookie.util;

import ch.qos.logback.core.util.Loader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Rookie on 2016/8/20.
 * Package_name is cn.rookie.util
 * Description:
 */
public class getResource {

    @Test
    public void getXML() throws IOException {
        ClassLoader myClassLoader = Loader.getClassLoaderOfObject(this);
        URL url = Loader.getResource("logback.xml", myClassLoader);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setUseCaches(false);
        InputStream in = urlConnection.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buff = new BufferedReader(reader);
        String temp;
        while ((temp = buff.readLine()) != null) {
            System.out.println(temp);
        }
    }
}
