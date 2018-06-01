package com.landi.mvpdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.landi.mvpdemo.R;
import com.landi.mvpdemo.ui.fragment.CollectionFragment;
import com.landi.mvpdemo.ui.fragment.TextInputFragment;
import com.landi.mvpdemo.ui.fragment.ZhihuFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    12345579798
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.imageList)
    ImageView imageList;

    public ZhihuFragment zhihuFragment;
    public CollectionFragment connectionFragment;
    public TextInputFragment textInputFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setItemIconTintList(null);
        getSupportActionBar().hide();
        initFragment();
        initNavigationItem();
    }

    @OnClick(R.id.imageList)
    public void openNavigation(View view){
        switch(view.getId())
        {
        case R.id.imageList:
            drawerLayout.openDrawer(navigation);
          break;
        default:
        }

    }


    private void initFragment() {
        zhihuFragment=ZhihuFragment.getZhihuInstance();
        connectionFragment=CollectionFragment.getCollectionInstabce();
        textInputFragment=TextInputFragment.getTextInputFragment();
        TextInputFragment.getTextInputFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, zhihuFragment);
        transaction.add(R.id.frameLayout,connectionFragment);
        transaction.add(R.id.frameLayout, textInputFragment);
        transaction.hide(CollectionFragment.getCollectionInstabce());
        transaction.hide(TextInputFragment.getTextInputFragment());
        transaction.commit();
    }


    private void initNavigationItem() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                case R.id.favour:
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.hide(zhihuFragment);
                    transaction.hide(textInputFragment);
                    transaction.show(connectionFragment);
                    transaction.commit();
                  break;
                case R.id.zhihu:
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    transaction1.hide(connectionFragment);
                    transaction1.hide(textInputFragment);
                    transaction1.show(zhihuFragment);
                    transaction1.commit();
                  break;
                    case R.id.textInput:
                        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                        transaction2.hide(connectionFragment);
                        transaction2.hide(zhihuFragment);
                        transaction2.show(textInputFragment);
                        transaction2.commit();
                        break;
                default:
                }
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }
}


// if (item.getItemId() == R.id.favorite) {
//         transaction.hide(ZhihuFragment.getZhihuInstance());
//         transaction.show(CollectionFragment.getCollectionInstabce());
//         transaction.commit();
//         } else if (item.getItemId() == R.id.wallet) {
//         FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//         transaction.show(ZhihuFragment.getZhihuInstance());
//         transaction.add(LiveclassActivity).add(DetailFragment).show().commit()
//         }q
//         Q
//         www
//         insert some code
//         hotfix insert someMore code   
