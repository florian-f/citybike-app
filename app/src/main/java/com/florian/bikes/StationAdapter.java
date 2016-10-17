package com.florian.bikes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder> {

    private List<com.florian.bikes.json.Station> stationList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName, textViewBikes, textViewSlots;

        public ViewHolder(View view) {
            super(view);

            textViewName = (TextView) view.findViewById(R.id.textViewName);
            textViewBikes = (TextView) view.findViewById(R.id.textViewBikes);
            textViewSlots = (TextView) view.findViewById(R.id.textViewSlots);
        }
    }

    public StationAdapter(List<com.florian.bikes.json.Station> stationList) {
        this.stationList = stationList;
    }

    @Override
    public StationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        com.florian.bikes.json.Station station = stationList.get(position);
        holder.textViewName.setText(station.getName());
        holder.textViewBikes.setText("" + station.getFreeBikes());
        holder.textViewSlots.setText("" + station.getEmptySlots());
    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }
}
