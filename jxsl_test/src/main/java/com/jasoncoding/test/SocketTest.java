package com.jasoncoding.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class SocketTest {

    private final static String excelUrl = "http://ou3k7hg80.bkt.clouddn.com/testExcel.xlsx";
    public static void main(String[] arg) throws IOException {
        URL url = new URL(excelUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream input = new DataInputStream(conn.getInputStream());

    }
}
