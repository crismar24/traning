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
        try {
            setupStreams();
            whileChatting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // обработка данных во время обращения
    private void whileChatting() throws IOException {
        String message = "Подключен пользователь "+socket.getInetAddress().getHostAddress();
        sendMessage(message);
        do {
            try {
                message = (String) inputStream.readObject();
                Server.showMessage("\n" + message);
            } catch (ClassNotFoundException classNotFoundException) {
                Server.showMessage("\nНе пойму что за хрень отправил пользователь !");
            }
        } while (!message.equals("КЛИЕНТ - *"));
    }
    // отправка сообщений клиенту
    private void sendMessage(String message) {
        try {
            outputStream.writeObject(message);
            outputStream.flush();
            Server.showMessage("\n"+message);
        } catch (IOException e) {
            Server.showMessage("\nОШИБКА: ЧУВАК, Я НЕ МОГУ ЭТО ИСПРАВИТЬ!!!");
            //e.printStackTrace();
        }
    }

    // закрываем сокеты и потоки когда пользователь начатился
    private void closeConnection(){
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
