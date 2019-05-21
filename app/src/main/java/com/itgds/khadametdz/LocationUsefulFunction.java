package com.itgds.khadametdz;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocationUsefulFunction {

    public static ArrayList<String> getCountry(Context context) {
        ArrayList<String> localAddress = new ArrayList<>();
        GpsTraker g = new GpsTraker(context);
        Location l = g.getLocation();
        if (l != null) {
            double lat = l.getLatitude();
            double lon = l.getLongitude();
            return getCountryName(context, lat, lon);
        }
        localAddress.add(Constants.ERROR_IN_GETTING_LOCATION);
        localAddress.add(Constants.ERROR_IN_GETTING_LOCATION);
        return localAddress;
    }

    private static ArrayList<String> getCountryName(Context context, double latitude, double longitude) {
        ArrayList<String> localAddress = new ArrayList<>();
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && !addresses.isEmpty()) {

                localAddress.add(addresses.get(0).getCountryName());
                localAddress.add(addresses.get(0).getLocality());
                return localAddress;
            }
            return null;
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
        localAddress.add(Constants.ERROR_IN_GETTING_LOCATION);
        localAddress.add(Constants.ERROR_IN_GETTING_LOCATION);
        return localAddress;
    }
}
