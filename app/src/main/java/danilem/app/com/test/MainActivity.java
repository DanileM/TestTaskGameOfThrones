package danilem.app.com.test;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends Activity implements RewardedVideoAdListener {

    @BindView(R.id.rc_test) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        recyclerView = findViewById(R.id.rc_test);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        TestAdapter adapter = new TestAdapter(this, Data.getModelList());
        recyclerView.setAdapter(adapter);

        AdmobVideoRewardHelper.mAd = MobileAds.getRewardedVideoAdInstance(this);
        AdmobVideoRewardHelper.mAd.setRewardedVideoAdListener(this);
        AdmobVideoRewardHelper.loadRewardedVideoAd();
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        AdmobVideoRewardHelper.loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {
        Toast.makeText(this, "Спасибо!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        AdmobVideoRewardHelper.mAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        AdmobVideoRewardHelper.mAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        AdmobVideoRewardHelper.mAd.destroy(this);
        super.onDestroy();
    }
}
