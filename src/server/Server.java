package server;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends JFrame {

    private int port = 7777;

    private static JTextArea chatWindow;
    private ArrayList<String> connectionList = new ArrayList<String>();
    private ServerSocket serverSocket;

    public Server() throws HeadlessException, IOException {
        super("Серверная часть.");
        JPanel mainPanel = new JPanel();
        setSize(new Dimension(300, 600));
        chatWindow = new JTextArea();
        // Параметры переноса слов
        chatWindow.setLineWrap(true);
        chatWindow.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(chatWindow);
        sp.createVerticalScrollBar();
        mainPanel.add(sp, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port, 100);
            //получить Соединение с юзером когда оно появится
            Socket socketConnection = waitForConnection();

            // проверить есть ли уже такой ip сокета в connectionList, если нет, тогда добавляем в connectionList и создаем новый поток-подключение userConnection
            if (!connectionList.contains(socketConnection.getInetAddress().getHostAddress())) {
                //Добавим подключение пользователя,если его еще нет в массиве (mb HashSet ?)
                addUserList(socketConnection.getInetAddress().getHostAddress());
                showMessage("\nСоединен с " + socketConnection.getInetAddress().getHostAddress());

                //новый поток. Подключение одного пользователя держим в отдельном потоке
                Connection userConnection = new Connection(socketConnection);
                userConnection.start();
                // в start получение данных ?...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public synchronized static void showMessage(final String message) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
                chatWindow.append("\n" + message);
//            }
//        })
        ;

    }

    private void addUserList(String socketConnectionAddress) {
        connectionList.add(socketConnectionAddress);
    }

    // ожидание соединения и отображение информации о подключении
    private Socket waitForConnection() throws IOException {
        Server.showMessage("\nОжидание подключения клиентов...");
        Socket socketConnection = serverSocket.accept();

        Server.showMessage("\nСоединен с " + socketConnection.getInetAddress().getAddress());
        return socketConnection;
    }

}
