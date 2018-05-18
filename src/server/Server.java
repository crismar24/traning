package server;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends JFrame implements Runnable {

    private int port = 7777;
    private JTextArea chatWindow;
    private ArrayList<Connection> connectionList = new ArrayList<Connection>();
    private ServerSocket serverSocket;

    public Server() throws HeadlessException, IOException {
        serverSocket = new ServerSocket(port);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(300, 600));

        chatWindow = new JTextArea();

        setVisible(true);
    }

    public void run() {
        Socket socketConnection = waitForConnection(serverSocket);

        Connection userConnection = new Connection(socketConnection);
        addUserList(userConnection);
        /// userConnection.start(); - нужен ли ? userConnection по идеи а так как Thread ?
        userConnection.openStreams();
        userConnection


    }

    private synchronized void addUserList(Connection userConnection) {
        connectionList.add(userConnection);
    }

}
