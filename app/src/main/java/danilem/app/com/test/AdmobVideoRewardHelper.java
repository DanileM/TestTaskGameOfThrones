package danilem.app.com.test;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class AdmobVideoRewardHelper {

    public static RewardedVideoAd mAd;

    public static  void loadRewardedVideoAd() {
        if(!mAd.isLoaded()){
            mAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
        }
    }
}
