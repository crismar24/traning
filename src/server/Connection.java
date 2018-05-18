package server;

import java.io.*;
import java.net.Socket;

public class Connection extends Thread {
    private OutputStream outputStream;
    private InputStream inputStream;
    private Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void openStreams() {

    }

    @Override
    public void run() {

    }
}
