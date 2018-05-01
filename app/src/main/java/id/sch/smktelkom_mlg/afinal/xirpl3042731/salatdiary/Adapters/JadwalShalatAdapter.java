package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model.DataJadwalShalatModel;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;

public class JadwalShalatAdapter extends RecyclerView.Adapter<JadwalShalatAdapter.JadwalShalatViewHolder> {

    private ArrayList<DataJadwalShalatModel> dataJadwalShalatModelArrayList;

    public JadwalShalatAdapter(ArrayList<DataJadwalShalatModel> dataJadwalShalatModelArrayList) {
        this.dataJadwalShalatModelArrayList = dataJadwalShalatModelArrayList;
    }

    @Override
    public JadwalShalatAdapter.JadwalShalatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_jadwal_shalat, parent, false);
        return new JadwalShalatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JadwalShalatAdapter.JadwalShalatViewHolder holder, int position) {
        holder.waktuSubuh.setText(dataJadwalShalatModelArrayList.get(position).getFajr());
        holder.waktuDzuhur.setText(dataJadwalShalatModelArrayList.get(position).getDhuhr());
        holder.waktuAshar.setText(dataJadwalShalatModelArrayList.get(position).getAsr());
        holder.waktuMaghrib.setText(dataJadwalShalatModelArrayList.get(position).getMaghrib());
        holder.waktuIsya.setText(dataJadwalShalatModelArrayList.get(position).getIsha());
    }

    @Override
    public int getItemCount() {
        return dataJadwalShalatModelArrayList.size();
    }

    class JadwalShalatViewHolder extends RecyclerView.ViewHolder {

        TextView waktuSubuh, waktuDzuhur, waktuAshar, waktuMaghrib, waktuIsya;

        public JadwalShalatViewHolder(View itemView) {
            super(itemView);

            waktuSubuh = itemView.findViewById(R.id.jamShalatSubuh);
            waktuDzuhur = itemView.findViewById(R.id.jamShalatDzuhur);
            waktuAshar = itemView.findViewById(R.id.jamShalatAshar);
            waktuMaghrib = itemView.findViewById(R.id.jamShalatMaghrib);
            waktuIsya = itemView.findViewById(R.id.jamShalatIsya);
        }
    }
}

