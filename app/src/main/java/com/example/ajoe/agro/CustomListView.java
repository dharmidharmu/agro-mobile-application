package com.example.ajoe.agro;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by jaiso on 13-02-2018.
 */

public class CustomListView extends ArrayAdapter<String> {

    private String[] profilename;
    private String[] email;
    private String[] imagepath;
    private Activity context;
    Bitmap bitmap;

    public CustomListView(Activity context, String[] profilename, String[] email, String[] imagepath) {
        super(context, R.layout.layout,profilename);
        this.context=context;
        this.profilename=profilename;
        this.email=email;
        this.imagepath=imagepath;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(profilename[position]);
        viewHolder.tvw2.setText(email[position]);
        viewHolder.tvw3.setText(imagepath[position]);


        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvprofilename);
            tvw2=(TextView)v.findViewById(R.id.tvemail);
            tvw3=(TextView) v.findViewById(R.id.tvdate);
        }

    }





}
