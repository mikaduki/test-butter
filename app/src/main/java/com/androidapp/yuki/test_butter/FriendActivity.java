package com.androidapp.yuki.test_butter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

import java.net.MalformedURLException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by yuki on 2014/12/10.
 */
public class FriendActivity extends Activity {

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
    private MobileServiceClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ButterKnife.inject(this);

        mFriendName.setText("YUJI NAKANISHI");
        mFriendBirthday.setText("10/10/10");
        mFriendCigarTotalCount.setText("xx");
        mFriendCigarDayCount.setText("xx");

        try {
            mClient = new MobileServiceClient(
                    "https://fb-messages.azure-mobile.net/",
                    "CQNkIViRgIWYSsFTsGcUMpcLedvvyB33",
                    this
            );
            FbMessages fbmessage = new FbMessages();
            fbmessage.Id = "8C9F690D-6418-4838-A80B-23FF4EC29A57";
            fbmessage.FromFbId = "aaja88wq0liavao8sehhava";
            fbmessage.ToFbId = "ajoaehnvlia;ndocana";
            fbmessage.Read = true;
            //fbmessage.Text = "最低!!";
            fbmessage.Message = "最低！ ";
            mClient.getTable(FbMessages.class).insert(fbmessage, new TableOperationCallback<FbMessages>() {
                public void onCompleted(FbMessages entity, Exception exception, ServiceFilterResponse response) {
                    if (exception == null) {
                        // Insert succeeded
                    } else {
                        // Insert failed
                    }
                }
            });

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //いいね
    @OnClick(R.id.m1_button)
    public void M1_Button() {
        // TODO submit data to server...
        try {
            mClient = new MobileServiceClient(
                    "https://fb-messages.azure-mobile.net/",
                    "CQNkIViRgIWYSsFTsGcUMpcLedvvyB33",
                    this
            );
            FbMessages fbmessage = new FbMessages();
            fbmessage.Id = "8C9F690D-6418-4838-A80B-23FF4EC29A57";
            fbmessage.FromFbId = "aaja88wq0liavao8sehhava";
            fbmessage.ToFbId = "ajoaehnvlia;ndocana";
            fbmessage.Read = true;
            //fbmessage.Text = "最低!!";
            fbmessage.Message = "saitei ";
            mClient.getTable(FbMessages.class).insert(fbmessage, new TableOperationCallback<FbMessages>() {
                public void onCompleted(FbMessages entity, Exception exception, ServiceFilterResponse response) {
                    if (exception == null) {
                        // Insert succeeded
                    } else {
                        // Insert failed
                    }
                }
            });

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //がんばれ！
    @OnClick(R.id.m2_button)
    public void M2_Button() {
        // TODO submit data to server...
        try {
            mClient = new MobileServiceClient(
                    "https://fb-messages.azure-mobile.net/",
                    "CQNkIViRgIWYSsFTsGcUMpcLedvvyB33",
                    this
            );
            FbMessages fbmessage = new FbMessages();
            fbmessage.FromFbId = "";
            fbmessage.ToFbId = "";
            fbmessage.Read = false;
            //fbmessage.Text = "最低!!";
            fbmessage.Message = "がんばれ！";
            mClient.getTable(FbMessages.class).insert(fbmessage, new TableOperationCallback<FbMessages>() {
                public void onCompleted(FbMessages entity, Exception exception, ServiceFilterResponse response) {
                    if (exception == null) {
                        // Insert succeeded
                    } else {
                        // Insert failed
                    }
                }
            });

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //ダメね。
    @OnClick(R.id.m3_button)
    public void M3_Button() {
        // TODO submit data to server...
        try {
            mClient = new MobileServiceClient(
                    "https://fb-messages.azure-mobile.net/",
                    "CQNkIViRgIWYSsFTsGcUMpcLedvvyB33",
                    this
            );
            FbMessages fbmessage = new FbMessages();
            fbmessage.FromFbId = "";
            fbmessage.ToFbId = "";
            fbmessage.Read = false;
            //fbmessage.Text = "最低!!";
            fbmessage.Message = "ダメね。";
            mClient.getTable(FbMessages.class).insert(fbmessage, new TableOperationCallback<FbMessages>() {
                public void onCompleted(FbMessages entity, Exception exception, ServiceFilterResponse response) {
                    if (exception == null) {
                        // Insert succeeded
                    } else {
                        // Insert failed
                    }
                }
            });

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
