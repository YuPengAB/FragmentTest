package com.example.e5.fragmenttest.msgfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e5.fragmenttest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 2017/6/10.
 */

public class MsgFragment extends Fragment implements View.OnClickListener{
    View sView;
    ListView vMsgs;
    ArrayAdapter<String> adapter;
    List<String> sMsgs = new ArrayList<>(0);
    List<String> cMsgs;
    EditText msg;
    TextView name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sView = inflater.inflate(R.layout.msg_frame_layout,container,false);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,sMsgs);
        vMsgs = (ListView)sView.findViewById(R.id.msgs);
        vMsgs.setAdapter(adapter);
        msg = (EditText)sView.findViewById(R.id.sendmsg);
        name = (TextView)sView.findViewById(R.id.name);
        sView.findViewById(R.id.send).setOnClickListener(this);
        return sView;
    }
    public void init(Msg msg){
        cMsgs = msg.msgs;
        sMsgs.clear();
        sMsgs.addAll(cMsgs);
        adapter.notifyDataSetChanged();
        name.setText(msg.name);
        this.msg.setText("");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:{
                String msg = this.msg.getText().toString();
                if(msg!=null&&msg!="") {
                    sMsgs.add(msg);
                    cMsgs.add(msg);
                    adapter.notifyDataSetChanged();
                    this.msg.setText("");
                }
            }
        }
    }
}
