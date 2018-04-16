package com.lwx.user.ui.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import com.kelin.scrollablepanel.library.ScrollablePanel;
import com.lwx.user.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MPSAcitvity extends AppCompatActivity {


    @BindView(R.id.tv1)
    TextView tv1;

    @BindView(R.id.tv2)
    TextView tv2;

    @BindView(R.id.tv3)
    TextView tv3;


    @BindView(R.id.tv4)
    TextView tv4;


    @BindView(R.id.tv5)
    TextView tv5;


    @BindView(R.id.tv6)
    TextView tv6;

    @BindView(R.id.tv7)
    TextView tv7;

    @BindView(R.id.tv8)
    TextView tv8;

    @BindView(R.id.tv9)
    TextView tv9;

    @BindView(R.id.tv10)
    TextView tv10;

    @BindView(R.id.tv11)
    TextView tv11;

    @BindView(R.id.tv12)
    TextView tv12;


    @BindView(R.id.scrollable_panel)
    ScrollablePanel panel;

    @BindView(R.id.buttona)
    Button button;

    @OnClick(R.id.buttona)
    public void onClick(){


        if("确定".equals(button.getText())){


            List<String> list1 = new ArrayList<>();
            List<List<String>>  list = adapter.getData();
            for(int j = 2; j <4; ++j){

                for(int i = 0; i < Integer.parseInt(twelveh); ++i){

                    list1.add(list.get(j).get(i+2));
                }
            }
            list1.add(list.get(5).get(2));
            generatePara(list1);

        }


        List<String> mpsList;


        try{


            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(this.getFilesDir(),"mpslist")));

            mpsList = (List<String>)ois.readObject();
            if(mpsList == null){
                mpsList = new ArrayList<>();
            }
            int flag = 0;
            for(int i = 0; i < mpsList.size() ;++i){

                if(mpsList.get(i).equals(first)){

                    flag = 1;
                }
            }
            if(flag == 0){

                mpsList.add(first);
            }

            ois.close();;
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(this.getFilesDir(),"mpslist")));
            oos.writeObject(mpsList);
            oos.flush();
            oos.close();

            ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(new File(this.getFilesDir(),first)));
            oos1.writeObject(adapter.getData());
            oos1.flush();
            oos1.close();
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(new File(this.getFilesDir(),first+"#")));
            List<String> list = new ArrayList<>();
            list.add(first);
            list.add(second);
            list.add(third);
            list.add(fourth);
            list.add(fifth);
            list.add(sixth);
            list.add(seventh);
            list.add(eighth);
            list.add(nineth);
            list.add(tenth);
            list.add(eleventh);
            list.add(twelveh);
            list.add(thirteenth);
            oos2.writeObject(list);
            oos2.flush();
            oos2.close();

        }
        catch (Exception e){

            try{

                mpsList = new ArrayList<>();
                mpsList.add(first);

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(this.getFilesDir(),"mpslist")));
                oos.writeObject(mpsList);
                oos.flush();
                oos.close();

                ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(new File(this.getFilesDir(),first
                )));
                oos1.writeObject(adapter.getData());
                oos1.flush();
                oos1.close();
                ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(new File(this.getFilesDir(),first+"#")));
                List<String> list = new ArrayList<>();
                list.add(first);
                list.add(second);
                list.add(third);
                list.add(fourth);
                list.add(fifth);
                list.add(sixth);
                list.add(seventh);
                list.add(eighth);
                list.add(nineth);
                list.add(tenth);
                list.add(eleventh);
                list.add(twelveh);
                list.add(thirteenth);
                oos2.writeObject(list);
                oos2.flush();
                oos2.close();
            }

            catch (Exception e1){


            }

        }


    }
    String first;
    String second;
    String third;
    String fourth;
    String fifth;
    String sixth;
    String seventh;
    String eighth;
    String nineth;
    String tenth;
    String eleventh;
    String twelveh;
    String thirteenth;
    AAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpsacitvity);
        ButterKnife.bind(this);



        Intent intent = getIntent();
        String flag = intent.getStringExtra("flag");
        if(flag != null){

            try{

                ObjectInputStream oos1 = new ObjectInputStream(new FileInputStream(new File(this.getFilesDir(),flag)));
                ObjectInputStream oos2 = new ObjectInputStream(new FileInputStream(new File(this.getFilesDir(),flag+"#")));

                List<List<String>>tempList = (List<List<String>>)oos1.readObject();
                List<String> tempList1 = (List<String>)oos2.readObject();
                first = tempList1.get(0);
                second = tempList1.get(1);
                third = tempList1.get(2);
                fourth = tempList1.get(3);
                fifth = tempList1.get(4);
                sixth  = tempList1.get(5);

                seventh = tempList1.get(6);
                eighth = tempList1.get(7);
                nineth = tempList1.get(8);
                tenth = tempList1.get(9);
                eleventh = tempList1.get(10);
                twelveh = tempList1.get(11);
                thirteenth = tempList1.get(12);

                adapter = new AAdapter(tempList,this);
                panel.setPanelAdapter(adapter);
                panel.notifyDataSetChanged();

            }
            catch (Exception e){


            }
            tv1.setText(first);
            tv2.setText(eighth);
            Calendar calender = Calendar.getInstance();
            tv3.setText(calender.get(Calendar.YEAR) + "/" + calender.get(Calendar.MONTH)+"/" + calender.get(Calendar.DAY_OF_MONTH));
            tv4.setText(thirteenth);
            tv5.setText(fourth);
            tv6.setText(tenth);
            tv7.setText(nineth);
            tv8.setText(sixth);
            tv9.setText(second);
            tv10.setText(fifth);
            tv11.setText(seventh);
            tv12.setText(third);

            return;
        }
        //List<List<String>> list =
        first = intent.getStringExtra("first");
        second = intent.getStringExtra("second");
        third = intent.getStringExtra("third");
        fourth = intent.getStringExtra("fourth");
        fifth = intent.getStringExtra("fifth");
        sixth = intent.getStringExtra("sixth");
        seventh = intent.getStringExtra("seventh");
        eighth = intent.getStringExtra("eighth");
        nineth = intent.getStringExtra("nineth");
        tenth = intent.getStringExtra("tenth");
        eleventh = intent.getStringExtra("eleventh");
        twelveh = intent.getStringExtra("twelveh");
        thirteenth = intent.getStringExtra("thirteen");

        tv1.setText(first);
        tv2.setText(eighth);
        Calendar calender = Calendar.getInstance();
        tv3.setText(calender.get(Calendar.YEAR) + "/" + (calender.get(Calendar.MONTH)+1)+"/" + calender.get(Calendar.DAY_OF_MONTH));
        tv4.setText(thirteenth);
        tv5.setText(fourth);
        tv6.setText(tenth);
        tv7.setText(nineth);
        tv8.setText(sixth);
        tv9.setText(second);
        tv10.setText(fifth);
        tv11.setText(seventh);
        tv12.setText(third);


        adapter = new AAdapter(new ArrayList<>(),this);


        List<String> para = new ArrayList<>();

        for(int j = 2; j < 4; ++j){

            for(int i = 0; i < Integer.parseInt(twelveh); ++i){


                para.add("");
            }


        }

        para.add("");
        generatePara(para);

        //list.add(new ArrayList<String>());




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();



    }

    public void generatePara(List<String> para){

        List<String> para2 = new ArrayList<>();
        para2.add(twelveh);
        para2.add(nineth);
        para2.add(fifth);
        para2.add(fourth);
        para2.add(sixth);
        para2.add(seventh);
        para2.add(second);
        para2.add(third);
        para2.add(eighth);
        para2.add(eleventh);

        adapter.setData(getTable(para2,para));

        panel.setPanelAdapter(adapter);
        panel.notifyDataSetChanged();
    }
    public  List<List<String>> getTable(List<String> para1,List<String> para2){
        int timeNum=Integer.parseInt(para1.get(0));		//时段数
        int leadTime = Integer.parseInt(para1.get(1));	//提前期（天）
        int PAB = Integer.parseInt(para1.get(2));		//当期预计库存量
        int safeStock = Integer.parseInt(para1.get(3));	//安全库存
        int batch = Integer.parseInt(para1.get(4));		//批量
        int batchIn = Integer.parseInt(para1.get(5));	//批量增量
        int deFence = Integer.parseInt(para1.get(6));	//需求时界
        int plFence = Integer.parseInt(para1.get(7));	//计划时界
        double Rate = Double.parseDouble(para1.get(8));	//成品率
        String startDate=para1.get(9);					//开始日期

        List<List<String>> data = new ArrayList<>();
        for(int i=0;i<11;++i){
            data.add(new ArrayList<String>());
        }
        //添加固定字段
        data.get(0).add("时段");
        data.get(1).add("日期");
        data.get(0).add("");
        data.get(1).add("当期");
        data.get(2).add("预测量");
        data.get(3).add("合同量");
        data.get(4).add("毛需求");
        data.get(5).add("计划接收量");
        data.get(6).add("预计库存量");
        data.get(7).add("净需求");
        data.get(8).add("计划产出量");
        data.get(9).add("计划投入量");
        data.get(10).add("可供销售量");
        //添加时段数
        for(int i=1;i<=timeNum;++i)
            data.get(0).add(""+i);
        //添加日期
        DateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = dateFormat1.parse(startDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DateFormat dateFormat2 = new SimpleDateFormat("MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        data.get(1).add(dateFormat2.format(cal.getTime()));
        for(int i=0;i<timeNum-1;++i){
            cal.add(Calendar.DATE, +leadTime);
            data.get(1).add(dateFormat2.format(cal.getTime()));
        }
        //添加当期的空白项
        data.get(2).add("");
        data.get(3).add("");
        data.get(4).add("");
        data.get(5).add("");
        data.get(7).add("");
        data.get(8).add("");
        data.get(9).add("");
        data.get(10).add("");

        //添加预计库存量
        data.get(6).add(""+PAB);

        //添加预测量
        int k=0;
        for(;k<timeNum;++k){
            data.get(2).add(para2.get(k));
        }
        //添加合同量
        for(;k<2*timeNum;++k){
            data.get(3).add(para2.get(k));
        }
        //添加第一期计划接收量
        data.get(5).add(para2.get(k));
        //计算毛需求
        for(int i=2;i<=deFence+1;++i){
            String val = data.get(3).get(i);
            data.get(4).add(val);
        }
        for(int i=deFence+2;i<=plFence+1;++i){
            int preval,conval;
            if(data.get(2).get(i).equals("") && !data.get(3).get(i).equals("")){

                data.get(4).add(data.get(3).get(i));
            }
            else if(data.get(3).get(i).equals("") && !data.get(2).get(i).equals("")){
                data.get(4).add(data.get(2).get(i));
            }else if(data.get(3).get(i).equals("") && data.get(2).get(i).equals("")){
                data.get(4).add("");
            }else{
                preval = Integer.parseInt(data.get(2).get(i));
                conval = Integer.parseInt(data.get(3).get(i));
                if(preval>conval){
                    data.get(4).add(""+preval);
                }else{
                    data.get(4).add(""+conval);
                }
            }
        }
        for(int i=plFence+2;i<=timeNum+1;++i){
            String val = data.get(2).get(i);
            data.get(4).add(val);
        }
        //计算第一期的数据

        int gross = 0;
        if(!data.get(4).get(2).equals(""))
            gross = Integer.parseInt(data.get(4).get(2));
        int preStock = PAB;
        int netReq = preStock-gross-safeStock;
        int preRec =0;
        if(!data.get(5).get(2).equals(""))
            preRec = Integer.parseInt(data.get(5).get(2));
        int curStock = netReq+safeStock+preRec;
        data.get(6).add(""+curStock);
        data.get(7).add("");
        data.get(8).add("");
        data.get(10).add(""+curStock);

        for(int i=3;i<=timeNum+1;++i){
            gross = 0;
            if(!data.get(4).get(i).equals(""))
                gross = Integer.parseInt(data.get(4).get(i));
            preStock = Integer.parseInt(data.get(6).get(i-1));
            netReq = preStock-gross-safeStock;
            if(netReq<0){
                //添加净需求
                data.get(7).add(""+(-netReq));
                //计算计划产出量
                int batchVal = batch;
                while(-netReq>batchVal){
                    batchVal += batchIn;
                }
                data.get(8).add(""+batchVal);
                //计算前一期的计划投入量
                int preIncome = (int)(batchVal/Rate+0.5);	//上取整
                int temp = (preIncome-batch)/batchIn;
                if(preIncome-batch==0){
                    preIncome = batch;
                }else if((preIncome-batch)%batchIn==0){
                    preIncome = batch + temp*batchIn;
                }else{
                    preIncome = batch + (temp+1)*batchIn;
                }
                data.get(9).add(""+preIncome);
                //计算计划接收量
                preRec = (int)(preIncome * Rate);
                data.get(5).add(""+preRec);

                //计算预计库存量
                curStock = preRec+preStock-gross;
                data.get(6).add(""+curStock);
            }else{
                data.get(7).add("");
                data.get(8).add("");
                data.get(9).add("");
                data.get(5).add("");
                data.get(6).add(""+(netReq+safeStock));
                if(i == timeNum+1){

                    data.get(9).add("");
                }
            }

        }
        for(int i=3;i<=timeNum+1;++i){
            if(data.get(8).get(i).equals("")){
                data.get(10).add("");
                continue;
            }
            int j=i+1;
            int totalConCount = 0;
            if(!data.get(3).get(i).equals(""))
                totalConCount = Integer.parseInt(data.get(3).get(i));
            for(;j<=timeNum+1;j++){
                if(!data.get(8).get(j).equals("")){
                    break;
                }
                if(!data.get(3).get(j).equals("")){
                    totalConCount+=Integer.parseInt(data.get(3).get(j));
                }
            }
            data.get(10).add(""+(Integer.parseInt(data.get(8).get(i))-totalConCount));
        }
        return data;
    }


}
