package com.huatec.mymobileshop.activity;



import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.huatec.mymobileshop.R;
import com.huatec.mymobileshop.common.BaseActivity;
import com.huatec.mymobileshop.fragment.NavigationFragment;


public class MainActivity extends BaseActivity {
   @Override
   public  @LayoutRes
   int getContentViewId(){
       return R.layout.activity_main;
   }

    @Override
    protected void initView() {
        super.initView();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.f1_main,new NavigationFragment());
        transaction.commit();
    }
}
