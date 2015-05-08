package com.bytecode.shopaholic.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.activities.LogInActivity;
import com.bytecode.shopaholic.adapters.SlideMenuAdapter;
import com.bytecode.shopaholic.adapters.items.Item;
import com.bytecode.shopaholic.adapters.items.SlideMenuItem;
import com.bytecode.shopaholic.appdata.AppManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuman on 8/5/2015.
 */
public class SlideMenuFragment extends Fragment {

    private View rootView;
    private View header;
    private ListView menuList;
    private SlideMenuAdapter listAdapter;
    private List<Item> slideItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createSlidingMenu();
        listAdapter = new SlideMenuAdapter(getActivity(), slideItems);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_slide_menu, container, false);
        header = inflater.inflate(R.layout.profile_view, null, false);
        menuList = (ListView) rootView.findViewById(R.id.menu_list);
        menuList.setAdapter(listAdapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position + 1 == listAdapter.getCount()) {
                    AppManager appManager = new AppManager(getActivity());
                    appManager.setSessionId("");
                    Intent intent = new Intent(getActivity(), LogInActivity.class);
                    getActivity().finish();
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }

    private void createSlidingMenu() {
        slideItems = new ArrayList<Item>();
        String[] names = getResources().getStringArray(R.array.nav_drawer_items);
        TypedArray icons = getResources().obtainTypedArray(R.array.nav_drawer_icons);
        SlideMenuItem item;
        for (int i = 0; i < names.length; i++) {
            item = new SlideMenuItem();
            item.setSlideItem(names[i]);
            item.setIcons(icons.getResourceId(i, -1));
            slideItems.add(item);
        }
        icons.recycle();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
