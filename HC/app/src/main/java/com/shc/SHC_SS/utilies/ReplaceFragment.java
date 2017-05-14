package com.shc.SHC_SS.utilies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.shc.SHC_SS.R;

/**
 * Created by jawdah on 3/26/2017.
 */

public class ReplaceFragment {

    public void replace(FragmentTransaction fragmentTransaction,  Fragment fragment){
        //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.setCustomAnimations(R.anim.enter_to_activity, R.anim.leave_activity);
        fragmentTransaction.replace(R.id.mainframe,fragment); // f2_container is your FrameLayout container
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
