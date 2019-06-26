package com.example.ajoe.agro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class phfragment extends Fragment implements View.OnClickListener {
    @Nullable
    private View mView;
    private TextView motorstate;
    private Button MotorOn,MotorOff;

    String urladdress="http://wwwajoecom.000webhostapp.com/retrive.php";
    String[] name;
    String[] email;
    String[] imagepath;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_ph,container,false);
        motorstate=(TextView)mView.findViewById(R.id.motorstate);
        MotorOn=(Button)mView.findViewById(R.id.motoron);
        MotorOff=(Button)mView.findViewById(R.id.motoroff);


        listView=(ListView)mView.findViewById(R.id.lview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
//        CustomListView customListView=new CustomListView(this,name,email,imagepath);
     //   listView.setAdapter(customListView);

        MotorOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motorstate.setText("Motor Turned ON");
            }
        });
        MotorOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motorstate.setText("Motor Turned OFF");

            }
        });
        return mView;
    }


    @Override
    public void onClick(View v) {

    }

    private void collectData()
    {
//Connection
        try{

            URL url=new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

//JSON
        try{
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            name=new String[ja.length()];
            email=new String[ja.length()];
            imagepath=new String[ja.length()];

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                name[i]=jo.getString("moisture");
                email[i]=jo.getString("ph");
                imagepath[i]=jo.getString("datetime");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }
}
