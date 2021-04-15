package com.example.solarautoswitcher;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

// this class is for the connection for the esp12e and how to send data to esp8266-12e
public class Connection extends AsyncTask <String,Void,String>

{
    Socket socket;
    int port=80;
    String msgToServer="";
    String Response="";
    Context context;



    public Connection(String message) {
        this.msgToServer=message;
    }

    @Override
    protected String doInBackground(String... strings) {
        DataOutputStream dataOutputStream=null;
        DataInputStream dataInputStream=null;
        try {
            socket = new Socket("192.168.1.117", 8089);
            // check the state of the connection if it is okay then send data
            if (socket.isConnected()) {
                //-> Write Message to ESP
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
                dataOut.writeBytes(msgToServer);
                dataOut.flush();
                Log.w("Data Write: ", msgToServer);
            }
            //-> Read Message for Esp
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Response = bufferedReader.readLine();
            if (!Response.isEmpty()) {
                Log.w("Data Read:", Response);
            }
        } // end if

        catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return Response;
    }  //end doing background

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
       Utils.showToast(context,Response);

    }
}// end classs

