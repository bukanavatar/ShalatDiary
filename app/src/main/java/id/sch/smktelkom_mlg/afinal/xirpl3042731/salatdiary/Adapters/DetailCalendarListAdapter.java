package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model.StatusShalatModel;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.R;

public class DetailCalendarListAdapter extends RecyclerView.Adapter<DetailCalendarListAdapter.ViewHolder> {

    public List<StatusShalatModel> statusShalatModelList;

    public DetailCalendarListAdapter(List<StatusShalatModel> statusShalatModelList) {
        this.statusShalatModelList = statusShalatModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_detail, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName.setText(statusShalatModelList.get(position).getNama());
        holder.mStatus.setText(statusShalatModelList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return statusShalatModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mName, mStatus;
        View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.nama);
            mStatus = itemView.findViewById(R.id.status);
        }
    }
}
