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
    View View;
    ListView vMsgs;
    ArrayAdapter<String> adapter;
    List<String> sMsgs = new ArrayList<>(0);
    EditText msg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View = inflater.inflate(R.layout.msg_frame_layout,container,false);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,sMsgs);
        vMsgs = (ListView)View.findViewById(R.id.msgs);
        vMsgs.setAdapter(adapter);
        msg = (EditText)View.findViewById(R.id.sendmsg);
        View.findViewById(R.id.send).setOnClickListener(this);
        return View;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:{
                String msg = this.msg.getText().toString();
                if(msg!=null&&msg!="") {
                    sMsgs.add(msg);
                    adapter.notifyDataSetChanged();
                    this.msg.setText("");
                }
            }
        }
    }
}
