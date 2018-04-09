package com.example.android.todolistbeta;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by kellyzelaya on 4/9/18.
 */

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder>  {
    private String[] mDataSet;


    //Provides a reference to the views for each data
    //Can provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder (TextView v){
            super(v);
            textView = v;
        }

    }

    public MyAdapter (String[] myDataSet){
        mDataSet = myDataSet;
    }

    //Creates a new view
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewtype){
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.my_text_view,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    //Replace the contents of view (Invoked by the layout manager)
    public void onBindViewHolder(ViewHolder holder, int position){
        //Get element from the dataset at this position
        //Replace the contents of the view with that element

        holder.textView.setText(mDataSet[position]);
    }

    @Override
    public int getItemCount(){
        return mDataSet.length;
    }


}
