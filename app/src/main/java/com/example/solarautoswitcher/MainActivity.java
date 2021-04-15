package com.example.solarautoswitcher;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {

    Button btnConfig;
    EditText ssid,password;
    Socket socket;
    int port = 80;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConfig=(Button)findViewById(R.id.btnConfig); // button for sending wifi username and password
        ssid=(EditText)findViewById(R.id.ssd);
        password=(EditText)findViewById(R.id.password);
        btnConfig.setOnClickListener(SendWifiConfig);
    }
//-------------------------------------------Click Buttons Events-----------------------------------------------------------------------------

    View.OnClickListener SendWifiConfig=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String WifiSSid,WifiPassword,message;
            WifiSSid=ssid.getText().toString(); // get the wifi username

            WifiPassword=password.getText().toString();  //get the wifi password
            //combine in one message
            message = "#"+WifiSSid + "$" + WifiPassword + "@" ; //send in this format for decoding


            Connection taskPost=new Connection(message); //send this message
            taskPost.execute("hello");   //do nothing just for not sending null object because app will crush

        }
    };
   //------------------------------------------------------------------------------------------------



}
