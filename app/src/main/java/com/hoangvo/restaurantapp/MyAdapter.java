package com.hoangvo.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hoang Vo on 12/1/2017.
 */

public class MyAdapter extends ArrayAdapter<String> {

    private Context context;

    public MyAdapter(Context context, ArrayList<String> records){
        super(context, 0, records);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String item = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_custom, parent, false);
        }

        final TextView list_txt = (TextView) convertView.findViewById(R.id.list_text);
        Button list_button = (Button) convertView.findViewById(R.id.list_button);

        list_txt.setText(item);

        list_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(context, InfoActivity.class);
                infoIntent.putExtra("nearBy", true);
                infoIntent.putExtra("pos", position);
                context.startActivity(infoIntent);
            }
        });
        return  convertView;
    }
}
