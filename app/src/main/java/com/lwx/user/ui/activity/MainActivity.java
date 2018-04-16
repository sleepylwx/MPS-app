package com.lwx.user.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;
import com.lwx.user.App;
import com.lwx.user.R;
import com.lwx.user.adapter.RecyclerViewAdapter;
import com.lwx.user.contracts.MainContract;
import com.lwx.user.model.model.Image;
import com.lwx.user.model.model.ImageSearch;
import com.lwx.user.model.model.User;
import com.lwx.user.presenter.MainPresenter;
import com.lwx.user.utils.ImageLoader;
import com.lwx.user.utils.PreferenceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;



    @BindView(R.id.floatingactionbutton)
    FloatingActionButton floatingActionButton;
    @OnClick(R.id.floatingactionbutton)
    public void onClick(){

        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
    public static final String MATCH_NUM = "1";
    public static final int RESULTCODE = 2;


    private RecyclerViewAdapter adapter;
    private List<String> list;




    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list = new ArrayList<>();





        //
        init();



    }




    @Override
    protected void onResume() {
        super.onResume();
        initRecycleView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter = null;

    }









    private void init() {




        initToolBar();

        initRecycleView();



    }


    private void initToolBar(){


        toolbar.setTitle("主界面");
        setSupportActionBar(toolbar);

        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               // this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawerLayout.setDrawerListener(toggle);

        //toggle.syncState();




    }





















    private void initRecycleView() {

//        if(imageList != null){
//
//            list.addAll(imageList);
//        }
        List<String> mpsList = new ArrayList<>();
        try{


            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(this.getFilesDir(),"mpslist")));

            mpsList = (List<String>)ois.readObject();


            ois.close();;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        adapter = new RecyclerViewAdapter(this, mpsList);
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);


    }



}
