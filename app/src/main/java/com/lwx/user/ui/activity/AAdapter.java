package com.lwx.user.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.kelin.scrollablepanel.library.PanelAdapter;
import com.lwx.user.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AAdapter extends PanelAdapter {

    public List<List<String>> list;

    public MPSAcitvity acitvity;
    public AAdapter(List<List<String>> list,MPSAcitvity acitvity) {

        this.list = list;
        this.acitvity = acitvity;
    }

    @Override
    public int getRowCount() {


        return list.size();
    }

    @Override
    public int getColumnCount() {
        return list.get(0).size();
    }

    @Override
    public int getItemViewType(int row, int column) {
        return super.getItemViewType(row, column);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int row, int column) {

        String str = list.get(row).get(column);
        ((View)holder).row = row;
        ((View)holder).column = column;


        if((row == 2 || row == 3 )&& (column != 0 && column != 1) || row == 5 && column == 2){

            ((View)holder).textView.setVisibility(android.view.View.GONE);
            ((View)holder).editText.setVisibility(android.view.View.VISIBLE);
            ((View)holder).value = str;
            if(!str.isEmpty()){

                ((View)holder).editText.setText(str);
            }


        }
        else{

            ((View)holder).textView.setVisibility(android.view.View.VISIBLE);
            ((View)holder).editText.setVisibility(android.view.View.GONE);
            (((View)holder).textView).setText(str);
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new View(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.temp, parent, false));

    }

    private   class View extends RecyclerView.ViewHolder{

        EditText editText;
        TextView textView;
        int row;
        int column;
        String value;
        public View(android.view.View itemView) {

            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textV);
            editText = (EditText)itemView.findViewById(R.id.editV);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {


                }

                @Override
                public void afterTextChanged(Editable s) {


                    String str = s.toString();
                    if(value.equals(str)){

                        return;
                    }
                    list.get(row).set(column,str);
                    List<String> para = new ArrayList<>();

                    for(int j = 2; j < 4; ++j){

                        for(int i = 2; i < getColumnCount(); ++i){


                            para.add(list.get(j).get(i));

                        }



                    }


                    para.add(list.get(5).get(2));
                    acitvity.generatePara(para);
                }
            });
        }
    }

    public void setData(List<List<String>>list){

        this.list = list;
    }

}
