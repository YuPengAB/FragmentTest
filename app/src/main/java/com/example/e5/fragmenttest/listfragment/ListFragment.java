package com.example.e5.fragmenttest.listfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.e5.fragmenttest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 2017/6/10.
 */

public class ListFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener{
    ListView vContacts;
    Button addCt;
    ArrayAdapter<String> adapter;
    List<String> sContacts = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_frame_layout,container,false);
        vContacts = (ListView)view.findViewById(R.id.contacts);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,sContacts);
        vContacts.setAdapter(adapter);
        vContacts.setOnItemClickListener(this);
        addCt = (Button)view.findViewById(R.id.addcontact);
        addCt.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addcontact:{
                sContacts.add("联系人"+(sContacts.size()+1));
                adapter.notifyDataSetChanged();
                break;
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ((ItemClickCallBack)getActivity()).onItemClick(i);
    }
    public interface ItemClickCallBack{
        void onItemClick(int position);
    }
}
