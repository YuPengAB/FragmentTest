package com.example.e5.fragmenttest.msgfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.e5.fragmenttest.R;

/**
 * Created by E5 on 2017/6/11.
 */

public class MsgTitleFragment extends Fragment {
    TextView name;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.msg_title, container, false);
        name = (TextView) view.findViewById(R.id.name);
        return view;
    }
    public void changeTitle(int position){
        name.setText("联系人"+position);
    }
}
