package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends BaseAdapter {
    private ArrayList<Photo> photoArrayList;
    private Context context;

    public PhotoAdapter(ArrayList<Photo> photoArrayList, Context context){
        this.photoArrayList = photoArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {return photoArrayList.size();}

    @Override
    public Object getItem(int position) {return photoArrayList.get(position);}

    @Override
    public long getItemId(int position) {return photoArrayList.get(position).getId();}

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        final MyView dataitem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertview == null){
            dataitem = new MyView();
            convertview = inflater.inflate(R.layout.photo_disp_tpl, null);
            dataitem.iv_photo = convertview.findViewById(R.id.imv_photo);
            dataitem.tv_detail = convertview.findViewById(R.id.tv_title);
            convertview.setTag(dataitem);
        }else{
            dataitem = (MyView) convertview.getTag();
        }
        Picasso.get().load(photoArrayList.get(position).getSource_photo()).into(dataitem.iv_photo);
        dataitem.tv_detail.setText(photoArrayList.get(position).getTitle_photo());

        return convertview;

    }
    private static class MyView{
        ImageView iv_photo;
        TextView tv_detail;
    }
}
