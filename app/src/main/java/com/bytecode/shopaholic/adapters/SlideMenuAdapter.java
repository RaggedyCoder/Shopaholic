package com.bytecode.shopaholic.adapters;
/*
 * Copyright (C) 2014 The Blue Pandora Project Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.adapters.items.Item;
import com.bytecode.shopaholic.adapters.items.SlideMenuItem;
import com.bytecode.shopaholic.utils.Utils;
import com.bytecode.shopaholic.view.widget.CustomTextView;

import java.util.List;

@SuppressLint("InflateParams")
public class SlideMenuAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Item> feedItems;
    private int selectedPosition;

    public SlideMenuAdapter(Activity activity, List<Item> feedItems) {
        this.activity = activity;
        this.feedItems = feedItems;
        selectedPosition = 0;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (inflater == null) {
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sliding_menu_row, null);
            holder = new ViewHolder();
            holder.text = (CustomTextView) convertView
                    .findViewById(R.id.slideMenu);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SlideMenuItem item = (SlideMenuItem) feedItems.get(position);
        holder.text.setText(item.getSlideItem());
        holder.icon.setImageResource(item.getIcons());
        if (position == selectedPosition) {
            holder.text.setTextColor(Color.argb(0xff, 0x00, 0xBC, 0xD4));
            if (Utils.hasEclair()) {
                holder.icon.setColorFilter(Color.argb(0xff, 0x00, 0xBC, 0xD4));
            }
        } else {
            holder.text.setTextColor(Color.argb(0xff, 0x28, 0x28, 0x28));
            if (Utils.hasEclair()) {
                holder.icon.setColorFilter(null);
            }
        }
        return convertView;
    }

    public void setSelected(int position) {
        selectedPosition = position;
    }

    private static class ViewHolder {
        CustomTextView text;
        ImageView icon;
    }
}
