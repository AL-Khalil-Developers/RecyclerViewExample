package com.alkhalildevelopers.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    List<MyModel> myModelList;
    OnBtnClickListener mOnBtnClickListener;
    public MyAdapter(List<MyModel> myModelList,OnBtnClickListener mOnBtnClickListener) {
        this.myModelList = myModelList;
        this.mOnBtnClickListener = mOnBtnClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.main_list_layout,parent,false);
        return new myViewHolder(view,mOnBtnClickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((myViewHolder)holder).textLineTxt.setText(myModelList.get(position).getTextLine());
    }


    @Override
    public int getItemCount() {
        return myModelList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textLineTxt;
        Button shareBtn;
        Button deleteBtn;
        OnBtnClickListener mOnBtnClickListener;
        public myViewHolder(@NonNull View itemView , final OnBtnClickListener mOnBtnClickListener) {
            super(itemView);
            this.mOnBtnClickListener = mOnBtnClickListener;
            textLineTxt = itemView.findViewById(R.id.textID);
            shareBtn = itemView.findViewById(R.id.shareBtnID);
            deleteBtn = itemView.findViewById(R.id.deleteBtnID);

            shareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnBtnClickListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mOnBtnClickListener.onShareBtnClick(position);
                        }
                    }
                }
            });

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnBtnClickListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mOnBtnClickListener.onDeleteBtnClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnBtnClickListener{
        void onShareBtnClick(int position);
        void onDeleteBtnClick(int position);
    }
}
