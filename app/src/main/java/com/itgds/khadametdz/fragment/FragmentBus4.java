package com.itgds.khadametdz.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itgds.khadametdz.R;

public class FragmentBus4 extends Fragment implements View.OnClickListener {
    private Context context;
    private Activity activity;
    private static final int globalPermissionRequestCode = 102;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bus_4, container, false);
        activity = getActivity();
        context = getContext();
        RelativeLayout mainHelpCall = view.findViewById(R.id.id_bus_help_call);
        RelativeLayout mainHelpMessage = view.findViewById(R.id.id_bus_help_message);

        mainHelpCall.setOnClickListener(this);
        mainHelpMessage.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_bus_help_call:
                String permissions[] = {Manifest.permission.CALL_PHONE};
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:123456789"));
                    startActivity(callIntent);
                } else {
                    ActivityCompat.requestPermissions(activity, permissions, globalPermissionRequestCode);
                }
                break;

            case R.id.id_bus_help_message:
                dialogOfMessage();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case globalPermissionRequestCode:
                if (grantResults.length > 0) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:123456789"));
                    startActivity(callIntent);
                }
                break;
        }
    }

    private void dialogOfMessage() {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_help);

        final EditText textHeading = dialog.findViewById(R.id.id_dialog_help_heading);
        final EditText textMessage = dialog.findViewById(R.id.id_dialog_help_message);

        Button dialogButton = dialog.findViewById(R.id.id_dialog_help_send_button);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textHeading.getText().toString().length() <= 0) {
                    Toast.makeText(getContext(), "Heading is Empty", Toast.LENGTH_LONG).show();
                    return;
                }
                if (textMessage.getText().toString().length() <= 0) {
                    Toast.makeText(getContext(), "Message is Empty", Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "khadamet.dz@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, textHeading.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, textMessage.getText().toString());
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}