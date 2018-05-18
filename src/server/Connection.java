package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection extends Thread {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void setupStreams() throws IOException {

        outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.flush();
        inputStream = new ObjectInputStream(socket.getInputStream());
        Server.showMessage("\nПоток установлен !!!");

    }

    @Override
    public void run() {
        setupStreams();
        whileChatting();
    }

}
