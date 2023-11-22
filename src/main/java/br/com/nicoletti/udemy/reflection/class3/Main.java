package br.com.nicoletti.udemy.reflection.class3;

import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) throws IOException {
        initConfiguration();
        WebServer webServer = new WebServer();
        webServer.startServer();

    }

    public static void initConfiguration() {

        try {
            Constructor<ServerConfiguration> constructor = ServerConfiguration.class.getDeclaredConstructor(int.class, String.class);

            //It is making a private constructor be accessible
            constructor.setAccessible(true);
            constructor.newInstance(8099, "Good Day");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
