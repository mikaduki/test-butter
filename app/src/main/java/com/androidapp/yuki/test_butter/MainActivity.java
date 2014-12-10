package com.androidapp.yuki.test_butter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;


public class MainActivity extends Activity {
    @InjectView(R.id.friend_list)
    ListView mFriendList;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        //ListView setup
        users = new ArrayList<User>();

        User u1 = new User();
        u1.name = "YUJI";
        u1.cigarCount = "20";
        users.add(u1);

        User u2 = new User();
        u2.name = "Haru";
        u2.cigarCount = "21";
        users.add(u2);

        TestListAdapter testListAdapter = new TestListAdapter(this, R.layout.item, users);
        mFriendList.setAdapter(testListAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @OnItemClick(R.id.friend_list)
    public void friendClick(int position) {
        User user = (User) mFriendList.getItemAtPosition(position);
        Toast.makeText(this, user.name, Toast.LENGTH_SHORT).show();

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
