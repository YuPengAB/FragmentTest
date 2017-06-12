package com.example.e5.fragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.e5.fragmenttest.listfragment.ListFragment;
import com.example.e5.fragmenttest.msgfragment.MsgFragment;
import com.example.e5.fragmenttest.msgfragment.MsgTitleFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ListFragment.ListClickCallBack{
    MsgFragment oldFragment;
    MsgTitleFragment mTitleFragment;
    FragmentManager fm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.list_frame,new ListFragment(),"List");
        mTitleFragment = new MsgTitleFragment();
        ft.add(R.id.msg_title,mTitleFragment,"Title");
        ft.hide(mTitleFragment);
        ft.commit();
    }

    @Override
    public void onItemClick(int position) {
        FragmentTransaction ft = fm.beginTransaction();
        if(oldFragment!=null){
            ft.hide(oldFragment);
        }
        oldFragment = (MsgFragment) fm.findFragmentByTag("msg"+Integer.toString(position));
        ft.show(oldFragment);
        mTitleFragment.changeTitle(position);
        ft.show(mTitleFragment);
        ft.commit();
    }

    @Override
    public void newContact(int postition) {
        FragmentTransaction ft = fm.beginTransaction();
        MsgFragment mFragment = new MsgFragment();
        ft.add(R.id.msg_frame,mFragment,"msg"+Integer.toString(postition));
        ft.hide(mFragment);
        ft.commit();
    }
}
