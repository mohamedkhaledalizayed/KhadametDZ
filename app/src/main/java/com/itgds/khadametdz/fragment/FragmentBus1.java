package com.itgds.khadametdz.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.itgds.khadametdz.R;
import com.itgds.khadametdz.adapter.RecyclerAdapterBusDetail;
import com.itgds.khadametdz.interfaces.PurchaseTicketListenerr;
import com.itgds.khadametdz.model.ModelBusDetail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FragmentBus1 extends Fragment implements View.OnClickListener, PurchaseTicketListenerr, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private String[] cityNamesList = {"[1] Adrar", "[2] Chlef", "[3] Laghouat", "[4] Oum El Bouaghi", "[5] Batna", "[6] Béjaïa", "[7] Biskra", "[8] Béchar", "[9] Blida", "[10] Bouira",
            "[11] Tamanrasset", "[12] Tébessa", "[13] Tlemcen", "[14] Tiaret", "[15] Tizi Ouzou", "[16] Alger", "[17] Djelfa", "[18] Jijel", "[19] Sétif", "[20] Saïda",
            "[21] Skikda", "[22] Sidi Bel Abbès", "[23] Annaba", "[24] Guelma", "[25] Constantine", "[26] Médéa", "[27] Mostaganem", "[28] M'Sila", "[29] Mascara", "[30] Ouargla",
            "[31] Oran", "[32] El Bayadh", "[33] Illizi", "[34] Bordj Bou Arreridj", "[35] Boumerdès", "[36] El Tarf", "[37] Tindouf", "[38] Tissemsilt", "[39] El Oued", "[40] Khenchela",
            "[41] Souk Ahras", "[42] Tipaza", "[43] Mila", "[44] Aïn Defla", "[45] Naâma", "[46] Aïn Témouchent", "[47] Ghardaïa", "[48] Relizane"};

    private Button searchButton;
    private TextView busTicketPayText;
    private Spinner spinnerSource, spinnerDestination;
    private Activity activity;
    private Context context;
    private RecyclerView recyclerView;
    private RelativeLayout mainBusTicketPayLayout;
    private Button busTicketPayButton;
    private TextView mainBusTextDate, mainBusTextTime;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bus_1, container, false);
        activity = getActivity();
        context = getContext();

        mainBusTextDate = view.findViewById(R.id.id_text_date);
        mainBusTextTime = view.findViewById(R.id.id_text_time);

        recyclerView = view.findViewById(R.id.id_bus_recycler_detail);
        mainBusTicketPayLayout = view.findViewById(R.id.id_bus_ticket_layout);
        busTicketPayText = view.findViewById(R.id.id_bus_ticket_pay_text);
        mainBusTicketPayLayout.setVisibility(View.GONE);
        busTicketPayButton = view.findViewById(R.id.id_bus_ticket_pay_button);

        final List<String> stateListArray = new ArrayList<>(Arrays.asList(cityNamesList));
        searchButton = view.findViewById(R.id.id_bus_button_search);
        spinnerSource = view.findViewById(R.id.id_spinner_source);
        final ArrayAdapter<String> spinnerArrayAdapterSource = new ArrayAdapter<>(context, R.layout.spinner_item, stateListArray);
        spinnerArrayAdapterSource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSource.setAdapter(spinnerArrayAdapterSource);


        spinnerDestination = view.findViewById(R.id.id_spinner_destination);
        final ArrayAdapter<String> spinnerArrayAdapterDestination = new ArrayAdapter<>(context, R.layout.spinner_item, stateListArray);
        spinnerArrayAdapterDestination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDestination.setAdapter(spinnerArrayAdapterDestination);

        searchButton.setOnClickListener(this);
        busTicketPayButton.setOnClickListener(this);
        mainBusTextDate.setOnClickListener(this);
        mainBusTextTime.setOnClickListener(this);
        mainBusTextTime.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
        mainBusTextDate.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
         timePickerDialog=new TimePickerDialog(context, this, Integer.parseInt(new SimpleDateFormat("HH", Locale.getDefault()).format(new Date())),
                Integer.parseInt(new SimpleDateFormat("mm", Locale.getDefault()).format(new Date())), true);
        datePickerDialog = new DatePickerDialog(
                context, this, Integer.parseInt(new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date())),
                Integer.parseInt(new SimpleDateFormat("MM", Locale.getDefault()).format(new Date())) - 1,
                Integer.parseInt(new SimpleDateFormat("dd", Locale.getDefault()).format(new Date())));
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_bus_button_search:
                Toast.makeText(context, spinnerSource.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                RecyclerAdapterBusDetail mAdapter = new RecyclerAdapterBusDetail(busArrayListData(), this);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
                break;
            case R.id.id_bus_ticket_pay_button:
                mainBusTicketPayLayout.setVisibility(View.GONE);
                Toast.makeText(context, "Paid", Toast.LENGTH_LONG).show();
                break;
            case R.id.id_text_date:
                datePickerDialog.show();
                break;
            case R.id.id_text_time:
                timePickerDialog.show();
                break;
        }
    }

    private ArrayList<ModelBusDetail> busArrayListData() {
        ArrayList<ModelBusDetail> busArrayList = new ArrayList<>();
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "120"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "100"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "80"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "20"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "150"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "60"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "70"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "130"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "20"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "90"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "50"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "150"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "20"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "150"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "60"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "70"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "130"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "20"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "90"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "50"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "150"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "20"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "150"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "60"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "70"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "10"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "130"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "20"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "90"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "50"));
        busArrayList.add(new ModelBusDetail("Adrar", "Aflou", "06:00", "08:00", "150"));
        return busArrayList;
    }


    @Override
    public void onTicketButtonClickToBuy(String busTicketPrice) {
        mainBusTicketPayLayout.setVisibility(View.VISIBLE);
        busTicketPayText.setText("Buy " + busTicketPrice);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month = month + 1;
        mainBusTextDate.setText(dayOfMonth + "/" + month + "/" + year);


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mainBusTextTime.setText(hourOfDay + ":" + minute);
    }
}