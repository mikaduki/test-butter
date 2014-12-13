package com.androidapp.yuki.test_butter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuki on 2014/12/11.
 */
public class FriendsMessageActivity extends Activity {

    @InjectView(R.id.messages)
    TextView mMessages;
    @InjectView(R.id.messagelist)
    ListView mMessagelist;

    private MobileServiceClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendsmessage);
        ButterKnife.inject(this);


    }

    public class User {
        public Drawable icon;
        public String name;
        public String cigarCount;
    }

    public static class TestListAdapter extends ArrayAdapter<User> {

        Context mContext;
        int mResource;

        public TestListAdapter(Context context, int resource, List<User> objects) {
            super(context, resource, objects);
            this.mContext = context;
            this.mResource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView != null) {
                holder = (ViewHolder) convertView.getTag();
            } else {
                convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }

            User item = this.getItem(position);
//            holder.mIcon.setImageDrawable(item.icon);
            holder.mName.setText(item.name);
            holder.mCigarCount.setText(item.cigarCount);

            // etc...

            return convertView;
        }

        static class ViewHolder {
            @InjectView(R.id.icon)
            ImageView mIcon;
            @InjectView(R.id.name)
            TextView mName;
            @InjectView(R.id.cigarCount)
            TextView mCigarCount;

            ViewHolder(View view) {
                ButterKnife.inject(this, view);
            }
        }
    }
}
