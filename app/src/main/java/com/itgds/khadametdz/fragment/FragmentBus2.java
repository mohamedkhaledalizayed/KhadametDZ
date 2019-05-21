package com.itgds.khadametdz.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itgds.khadametdz.model.ModelFragBusTicket;
import com.itgds.khadametdz.R;

import java.util.ArrayList;

public class FragmentBus2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bus_2, container, false);
        RecyclerView busTicketRV = view.findViewById(R.id.id_bus_ticket_rv);
        RecyclerViewBusTicket mAdapter = new RecyclerViewBusTicket(arrayListTicket());
        busTicketRV.setLayoutManager(new LinearLayoutManager(getContext()));
        busTicketRV.setItemAnimator(new DefaultItemAnimator());
        busTicketRV.setAdapter(mAdapter);
        return view;
    }


    private class RecyclerViewBusTicket extends RecyclerView.Adapter<RecyclerViewBusTicket.MyViewHolder> {
        private ArrayList<ModelFragBusTicket> arrayList;

        public RecyclerViewBusTicket(ArrayList<ModelFragBusTicket> arrayList) {
            this.arrayList = arrayList;
        }


        @NonNull
        @Override
        public RecyclerViewBusTicket.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_bus_ticket, viewGroup, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewBusTicket.MyViewHolder myViewHolder, int i) {
            ModelFragBusTicket modelFragBusTicket = arrayList.get(i);
            myViewHolder.mainBusStationText.setText(modelFragBusTicket.getTicketSourceName() + " - " + modelFragBusTicket.getTicketDestinationName());
            myViewHolder.mainBusTicketFare.setText(modelFragBusTicket.getTicketPrice());
            myViewHolder.mainBusTicketStation.setText(modelFragBusTicket.getTicketStation());
            myViewHolder.mainBusTicketStatus.setText(modelFragBusTicket.getTicketStatus());
            if (modelFragBusTicket.getTicketColor().equals("red")) {
                myViewHolder.mainBusTicketStatus.setTextColor(Color.parseColor("#DD5145"));

            } else {
                myViewHolder.mainBusTicketStatus.setTextColor(Color.parseColor("#5EBA7D"));
            }
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView mainBusStationText, mainBusTicketFare, mainBusTicketStatus, mainBusTicketStation;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                mainBusStationText = itemView.findViewById(R.id.id_card_bus_ticket_source_destination);
                mainBusTicketFare = itemView.findViewById(R.id.id_card_bus_ticket_source_fare);
                mainBusTicketStatus = itemView.findViewById(R.id.id_card_bus_ticket_status);
                mainBusTicketStation = itemView.findViewById(R.id.id_card_bus_ticket_station);
            }
        }
    }

    private ArrayList<ModelFragBusTicket> arrayListTicket() {
        ArrayList<ModelFragBusTicket> arrayList = new ArrayList<>();
        arrayList.add(new ModelFragBusTicket("Adrar Station", "Adrar", "Naâma", "20", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Djelfa Station", "Djelfa", "Guelma", "10", "Active", "green"));
        arrayList.add(new ModelFragBusTicket("Illizi Station", "Illizi", "Jijel", "30", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Alger Station", "Alger", "Mumbai", "20", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Naâma Station", "Naâma", "Illizi", "20", "Active", "green"));
        arrayList.add(new ModelFragBusTicket("Guelma Station", "Guelma", "Djelfa", "50", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Tipaza Station", "Tipaza", "Alger", "60", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Mascara Station", "Mascara", "Ghardaïa", "80", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Illizi Station", "Illizi", "Naâma", "20", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Djelfa Station", "Djelfa", "Djelfa", "10", "Active", "green"));
        arrayList.add(new ModelFragBusTicket("Jijel Station", "Jijel", "Alger", "10", "Active", "green"));
        arrayList.add(new ModelFragBusTicket("Tissemsilt Station", "Tissemsilt", "Illizi", "20", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Mascara Station", "Mascara", "Naâma", "50", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Blida Station", "Blida", "Tissemsilt", "20", "Active", "green"));
        arrayList.add(new ModelFragBusTicket("Naâma Station", "Naâma", "Blida", "70", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Alger Station", "Alger", "Tipaza", "60", "Expire", "red"));
        arrayList.add(new ModelFragBusTicket("Naâma Station", "Naâma", "Illizi", "20", "Expire", "red"));
        return arrayList;
    }
}