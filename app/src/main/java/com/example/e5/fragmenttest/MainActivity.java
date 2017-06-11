package com.example.e5.fragmenttest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.e5.fragmenttest.listfragment.ListFragment;
import com.example.e5.fragmenttest.msgfragment.Msg;
import com.example.e5.fragmenttest.msgfragment.MsgFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemClickCallBack{
    Map<Integer,Msg> mMsgs = new HashMap<>();
    MsgFragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.list_frame,new ListFragment(),"List");
        mFragment = new MsgFragment();
        ft.add(R.id.msg_frame,mFragment,"Msg");
        ft.commit();
    }

    @Override
    public void onItemClick(int position) {
        Msg msg;
        if(mMsgs.get(position)==null) {
            msg = new Msg();
        }else{
            msg = mMsgs.get(position);
        }
        mMsgs.put(position,msg);
        msg.name = "联系人"+(position+1);
        mFragment.init(msg);
    }
}
