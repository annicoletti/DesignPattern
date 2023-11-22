package br.com.nicoletti.udemy.reflection.class3;

import java.net.InetSocketAddress;

/**
 *
 * @author nicoletti
 */
public class ServerConfiguration {

    private static ServerConfiguration serverConfigurationInstance;

    private final InetSocketAddress serverAddress;
    private final String greetingMeddage;

    private ServerConfiguration(int port, String greetingMeddage) {
        this.greetingMeddage = greetingMeddage;
        this.serverAddress = new InetSocketAddress("localhost", port);

        if (serverConfigurationInstance == null) {
            serverConfigurationInstance = this;
        }
    }

    public static ServerConfiguration getInstance() {
        return serverConfigurationInstance;
    }

    public InetSocketAddress getServerAddress() {
        return this.serverAddress;
    }

    public String getGreetingMessage() {
        return this.greetingMeddage;
    }

}
