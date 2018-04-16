package com.lwx.user.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lwx.user.R;
import com.lwx.user.contracts.ToImageDetailContract;
import com.lwx.user.model.model.Image;
import com.lwx.user.ui.activity.MPSAcitvity;
import com.lwx.user.utils.ImageLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 36249 on 2017/4/13.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    private Context context;
    private List<String> imageList;


    public static final String TAG = "RecyclerViewAdapter";
    public RecyclerViewAdapter(Context context,List<String> imageList){

        this.context = context;
        this.imageList = imageList;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){


        List<List<String>>  tempList = new ArrayList<>();
        ((ViewHolder)holder).num = position;
        try{


            //ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(context.getFilesDir(),imageList.get(position))));

            //tempList = (List<List<String>>)ois.readObject();
            //ois.close();;

        }
        catch (Exception e){

        }


        ((ViewHolder)holder).textView.setText(imageList.get(position));


        ((ViewHolder)holder).textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MPSAcitvity.class);


                intent.putExtra("flag",imageList.get(position));
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount(){

        return imageList.size();
    }


    public void setData(List<String> list){

        this.imageList = list;
    }

    public void addData(List<String> list){

        this.imageList.addAll(list);
    }

    public List<String> getData(){

        return imageList;
    }
    class ViewHolder extends RecyclerView.ViewHolder{


        @BindView(R.id.textid)TextView textView;
        int num;
        public ViewHolder(View view){

            super(view);
            ButterKnife.bind(this,view);



        }

    }

}
