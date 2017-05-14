package com.shc.SHC_SS.activities;

/**
 * Created by jawdah on 4/3/2017.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.utilies.HCApplication;

public class Splash extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        HCApplication.newInstance().preventLocalization();
        setContentView(R.layout.splash);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                if( HCApplication.saveDataInSharedPrefrances.getStringFRomShard("User_Data", "user_number").equals("")) {
                    Intent mainIntent = new Intent(Splash.this, LoginPage.class);
                    Splash.this.startActivity(mainIntent);
                    Splash.this.finish();
                }else {
                    int move =HCApplication.saveDataInSharedPrefrances.getFRomShard("ActivityMove","activity_value");
                    switch (move){
                        case 2:
                            movement(Splash.this,new AgreementActivity());
                            break;
                        case 3:
                            movement(Splash.this,new Section0991());
                            break;
                        case 4:
                            movement(Splash.this,new QuestionsShow());
                            break;
                        default:
                            movement(Splash.this,new FamilyDetails());

                            break;
                    };
                }
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    void movement(Context context, Activity activity2){
        Intent mainIntent = new Intent(context,activity2.getClass());
        Splash.this.startActivity(mainIntent);
        Splash.this.finish();
    }
}