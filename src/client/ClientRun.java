package client;

import javax.swing.*;

public class ClientRun {
    public static void main(String[] args) {
        Client yury;
        yury = new Client("192.168.0.7");
        yury.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        yury.start();
    }
}
