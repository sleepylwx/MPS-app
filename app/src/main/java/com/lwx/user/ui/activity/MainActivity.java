package com.lwx.user.ui.activity;

import android.content.Context;
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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    @BindView(R.id.floatingactionbutton)
    private FloatingActionButton floatingActionButton;
    @OnClick(R.id.floatingactionbutton)
    public void onClick(){


    }
    public static final String MATCH_NUM = "1";
    public static final int RESULTCODE = 2;


    private RecyclerViewAdapter adapter;
    private List<Image> list;



    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list = new ArrayList<>();


        //headerImageView =strenthenToolBar.getHeaderView();

        //


        //
        init();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter = null;

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{

            moveTaskToBack(false);
        }
    }





    private void initNavigationView() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@android.support.annotation.NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.nav_dailytask){

                    Intent intent = new Intent(MainActivity.this,DailyTaskActivity.class);
                    startActivity(intent);
                }
                else if(id == R.id.nav_history){

                    Intent intent = new Intent(MainActivity.this,HistoryStatisticsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_label) {


                    Intent intent = new Intent(MainActivity.this, HistoryLabelActivity.class);
                    //intent.putExtra(HistoryLabelActivity.USERID,App.getInstance().getUid());
                    startActivity(intent);

                } else if (id == R.id.nav_image) {

                    Intent intent = new Intent(MainActivity.this, HistoryImageActivity.class);
                    //intent.putExtra(HistoryImageActivity.USERID,App.getInstance().getUid());
                    startActivity(intent);
                }

                else if(id == R.id.nav_feedback){

                    Intent intent = new Intent(MainActivity.this,FeedBackActivity.class);
                    startActivity(intent);

                }
                else if (id == R.id.nav_exit) {

                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.putExtra(LoginActivity.MATCH_NUM, App.getInstance().getUid());

                    Log.d(TAG, "exit login" + " " + App.getInstance().getUid());

                    new PreferenceHelper().deleteLogInUID();
                    startActivity(intent);
                    finish();
                }


                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void init() {




        initToolBar();
        initNavigationView();

        initRecycleView();





    }


    private void initToolBar(){


        toolbar.setTitle("");
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
        Log.d(TAG, "" + list.size());
        adapter = new RecyclerViewAdapter(this, this.list);
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);


    }



}
