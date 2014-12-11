package com.androidapp.yuki.test_butter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuki on 2014/12/10.
 */
public class RankingActivity extends Activity {

    @InjectView(R.id.ranking)
    TextView mRanking;
    @InjectView(R.id.ranklistView)
    ListView mRanklistView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        ButterKnife.inject(this);


        //Setup Ranking
        ArrayList<RankingUser> rank = new ArrayList<RankingUser>();
        RankingUser ru1 = new RankingUser();
        ru1.rankusername = "YUJI";
        ru1.rankscore = "-20";
        rank.add(ru1);

        RankingUser ru2 = new RankingUser();
        ru2.rankusername = "Haru";
        ru2.rankscore = "+21";
        rank.add(ru2);

        RankListAdapter rankListAdapter = new RankListAdapter(this, R.layout.ranking_item, rank);
        mRanklistView.setAdapter(rankListAdapter);
        //ListView
    }

    //Ranking Item
    public class RankingUser {
        public Drawable userImageView;
        public String rankusername;
        public String rankscore;
    }

    //Adapter of Ranking ListView
    public static class RankListAdapter extends ArrayAdapter<RankingUser> {

        Context mContext;
        int mResource;

        public RankListAdapter(Context context, int resource, List<RankingUser> objects) {
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

            RankingUser rankitem = this.getItem(position);

            //           holder.mIcon.setImageDrawable(item.icon);
            holder.mRankusername.setText(rankitem.rankusername);
            holder.mRankscore.setText(rankitem.rankscore);

            return convertView;
        }

        static class ViewHolder {
            @InjectView(R.id.rankusername)
            TextView mRankusername;
            @InjectView(R.id.rankscore)
            TextView mRankscore;

            ViewHolder(View view) {
                ButterKnife.inject(this, view);
            }
        }

    }
}