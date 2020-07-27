package com.github.panarik.smartFeatures.data.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.panarik.smartFeatures.R;

public class LandscapeOneFragment extends Fragment {

    //TAG для различия фрагментов
    public static final String landscapeFragmentTAG = "OneFragmentTAG";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_landscape_one, null);
    }
}
