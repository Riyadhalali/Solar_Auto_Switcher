package com.example.solarautoswitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    Button btnConfig;
    EditText ssd,password;
    Socket socket;
    int port=80;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConfig=(Button)findViewById(R.id.btnConfig);
        ssd=(EditText)findViewById(R.id.ssd);
        password=(EditText)findViewById(R.id.password);

//----------------------------Connection Button----------------------------------------------------
        btnConfig.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String WifiSSid,WifiPassword,message;

                WifiSSid=ssd.getText().toString(); // get the username
                WifiPassword=password.getText().toString(); // get the password

                message="#"+WifiSSid+"$"+WifiPassword+"@"; // decode the message for sending it to Esp

                Connection taskPost=new Connection(message);//send this message
                taskPost.execute("hello"); //do nothing just for not sending null object because app will crush
                
            }
        });

    } // onCreate
//--------------------------------------------------------------------------------------------------


} // end class