package com.itgds.khadametdz.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itgds.khadametdz.R;
import com.itgds.khadametdz.interfaces.PurchaseTicketListenerr;
import com.itgds.khadametdz.model.ModelBusDetail;

import java.util.ArrayList;

public class RecyclerAdapterBusDetail extends RecyclerView.Adapter<RecyclerAdapterBusDetail.MyViewHolder> {
    private ArrayList<ModelBusDetail> arrayBusDetails;
    private PurchaseTicketListenerr purchaseTicketListener;
    public RecyclerAdapterBusDetail(ArrayList<ModelBusDetail> arrayBusDetails,PurchaseTicketListenerr purchaseTicketListener) {
        this.arrayBusDetails = arrayBusDetails;
        this.purchaseTicketListener=purchaseTicketListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bus, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        ModelBusDetail modelBusDetail = arrayBusDetails.get(i);
        holder.busTextSource.setText(modelBusDetail.getBusSourceName());
        holder.busTextDestination.setText(modelBusDetail.getBusDestinationName());
        holder.busTextFrom.setText(modelBusDetail.getBusTimeFrom());
        holder.busTextTo.setText(modelBusDetail.getBusTimeTo());
        holder.busTextPrice.setText(modelBusDetail.getBusPrice());
    }

    @Override
    public int getItemCount() {
        return arrayBusDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView busTextSource, busTextDestination, busTextFrom, busTextTo, busTextPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            busTextSource = itemView.findViewById(R.id.id_bus_detail_source);
            busTextDestination = itemView.findViewById(R.id.id_bus_detail_destination);
            busTextFrom = itemView.findViewById(R.id.id_bus_detail_from);
            busTextTo = itemView.findViewById(R.id.id_bus_detail_to);
            busTextPrice = itemView.findViewById(R.id.id_bus_detail_price);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            purchaseTicketListener.onTicketButtonClickToBuy(arrayBusDetails.get(position).getBusPrice());

        }
    }
}