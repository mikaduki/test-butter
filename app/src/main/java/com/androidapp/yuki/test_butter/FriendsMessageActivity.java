package com.androidapp.yuki.test_butter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

import java.net.MalformedURLException;

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

        try {
            mClient = new MobileServiceClient("https://myservice.azure-mobile.net/",
                    "slkerjasfi234eSomePrivateKey", this);

            FbMessages fbmessage = new FbMessages();
            fbmessage.Message = "Awesome item";

            mClient.getTable(FbMessages.class).insert(fbmessage,
                    new TableOperationCallback<FbMessages>() {
                        public void onCompleted(FbMessages entity,
                                                Exception exception,
                                                ServiceFilterResponse response) {
                            if (exception == null) {
                                //Successful
                            } else {
                                //Failed
                            }
                        }
                    });

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
