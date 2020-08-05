package com.example.smartstickapp3;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MCPlantAdapter extends RecyclerView.Adapter<MCPlantAdapter.MyViewHolder> {

    ArrayList<SensorItem> mDataList;
    LayoutInflater inflater;

    public MCPlantAdapter(Context context, ArrayList<SensorItem> data){
        inflater = LayoutInflater.from(context);
        this.mDataList = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // xml den java dönüştürmek istediğimiz layoutu veriyoruz.
        View v = inflater.inflate(R.layout.my_current_plant_cards,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Tıklanan öğeler SensorItem class tipinde nesnedir.
        SensorItem tiklanilanSensorItem = mDataList.get(position);
        holder.setData(tiklanilanSensorItem,position);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewData, mTextViewName;
        ImageView mImageView;
        SeekBar mSeekbar;
        int minValue=0;
        int maxValue=0;
        int currentValue=0;
        int optimumValue=0;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.textViewName);
            mTextViewData = itemView.findViewById(R.id.textViewData);
            mImageView = itemView.findViewById(R.id.imageView);
            mSeekbar = itemView.findViewById(R.id.seek_bar);
        }

        public void setData(SensorItem tiklanilanSensorItem, int position) {
            this.mTextViewName.setText(tiklanilanSensorItem.getBitkiAdi());
            this.mTextViewData.setText(tiklanilanSensorItem.getBitkiVeriTur());
            this.mImageView.setImageResource(tiklanilanSensorItem.getBitki_logo());
        }
    }
}
