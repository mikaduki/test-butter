package com.androidapp.yuki.test_butter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by yuki on 2014/12/10.
 */
public class FriendActvity extends Activity {

    @InjectView(R.id.friend_image)
    ImageView mFriendImage;
    @InjectView(R.id.friend_birthday)
    TextView mFriendBirthday;
    @InjectView(R.id.friend_name)
    TextView mFriendName;
    @InjectView(R.id.m1_button)
    Button mM1Button;
    @InjectView(R.id.m2_button)
    Button mM2Button;
    @InjectView(R.id.m3_button)
    Button mM3Button;
    @InjectView(R.id.imageView)
    ImageView mImageView;
    @InjectView(R.id.friend_cigar_day_count)
    TextView mFriendCigarDayCount;
    @InjectView(R.id.friend_cigar_total_count)
    TextView mFriendCigarTotalCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ButterKnife.inject(this);

        mFriendName.setText("YUJINAKANISHI");
        mFriendBirthday.setText("10/10/10");
        mFriendCigarTotalCount.setText("300");
        mFriendCigarDayCount.setText("10");

    }

    //いいね
    @OnClick(R.id.m1_button)
    public void M1_Button() {
        // TODO submit data to server...

    }

    //ダメね
    @OnClick(R.id.m2_button)
    public void M2_Button() {
        // TODO submit data to server...

    }

    //最低！
    @OnClick(R.id.m3_button)
    public void M3_Button() {
        // TODO submit data to server...

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
}
