package com.lwx.user.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kelin.scrollablepanel.library.ScrollablePanel;
import com.lwx.user.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MPSAcitvity extends AppCompatActivity {

    @BindView(R.id.scrollable_panel)
    ScrollablePanel scrollablePanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpsacitvity);
        ButterKnife.bind(this);
        Adapter adapter = new Adapter();
        List<List<String>> list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; ++i){

            list.add(new ArrayList<>());
        }

        addDate(list);
        
    }


    void addDate(List<List<String>> list){

        //todo
    }
}
