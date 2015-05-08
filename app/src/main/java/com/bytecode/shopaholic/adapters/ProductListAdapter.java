package com.bytecode.shopaholic.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.application.AppController;
import com.bytecode.shopaholic.items.receive.ProductInfo;
import com.bytecode.shopaholic.view.widget.CustomTextView;

import java.util.List;

/**
 * Created by tuman on 8/5/2015.
 */
public class ProductListAdapter extends BaseAdapter {

    private List<ProductInfo> productInfos;
    private LayoutInflater inflater;
    private Activity activity;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();


    public ProductListAdapter(Activity activity, List<ProductInfo> productInfos) {
        this.activity = activity;
        this.productInfos = productInfos;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return productInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.product_view, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.networkImageView = (NetworkImageView) convertView.findViewById(R.id.product_thumb);
            viewHolder.productName = (CustomTextView) convertView.findViewById(R.id.product_name);
            viewHolder.productPrice = (CustomTextView) convertView.findViewById(R.id.product_price);
            viewHolder.productDetails = (CustomTextView) convertView.findViewById(R.id.product_details);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ProductInfo productInfo = productInfos.get(position);
        viewHolder.networkImageView.setImageUrl(productInfo.getThumbURL(), imageLoader);
        viewHolder.productName.setText(productInfo.getName());
        viewHolder.productPrice.setText(productInfo.getPrice());
        viewHolder.productDetails.setText(productInfo.getDescription());
        return convertView;
    }

    public void addMore(List<ProductInfo> productInfos) {
        this.productInfos.addAll(productInfos);
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        private NetworkImageView networkImageView;
        private CustomTextView productName;
        private CustomTextView productPrice;
        private CustomTextView productDetails;
    }
}
