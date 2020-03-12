package com.flege.gumukrejo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flege.gumukrejo.R;
import com.flege.gumukrejo.dataclass.RiwayatTransaksi;

import java.util.ArrayList;

public class RiwayatTransaksiAdapter extends ArrayAdapter<RiwayatTransaksi> implements View.OnClickListener{

    private ArrayList<RiwayatTransaksi> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView description;
        TextView status;
        TextView tanggal;
        ImageView icon;
    }

    public RiwayatTransaksiAdapter(ArrayList<RiwayatTransaksi> data, Context context) {
        super(context, R.layout.item_riwayat_transaksi, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        RiwayatTransaksi object = getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_riwayat_transaksi, parent, false);
            viewHolder.description = convertView.findViewById(R.id.description);
            viewHolder.status = convertView.findViewById(R.id.status);
            viewHolder.tanggal = convertView.findViewById(R.id.tanggal);
            viewHolder.icon = convertView.findViewById(R.id.icon);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.description.setText(dataSet.get(position).getTitle());
        if(dataSet.get(position).getStatus().equalsIgnoreCase("berhasil")){
            viewHolder.status.setText(dataSet.get(position).getStatus());
            viewHolder.status.setTextColor(convertView.getResources().getColor(R.color.success));
        }else if(dataSet.get(position).getStatus().equalsIgnoreCase("OnProgress")){
            viewHolder.status.setText(dataSet.get(position).getStatus());
            viewHolder.status.setTextColor(convertView.getResources().getColor(R.color.secondary));
        }else{
            viewHolder.status.setText(dataSet.get(position).getStatus());
            viewHolder.status.setTextColor(convertView.getResources().getColor(R.color.danger));
        }
        viewHolder.tanggal.setText(dataSet.get(position).getTanggal());
        viewHolder.icon.setOnClickListener(this);
        viewHolder.icon.setTag(position);

        return convertView;
    }
}
