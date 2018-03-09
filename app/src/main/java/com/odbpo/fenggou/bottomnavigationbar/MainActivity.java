package com.odbpo.fenggou.bottomnavigationbar;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.odbpo.fenggou.bottomnavigationbar.fragment.FindFragment;
import com.odbpo.fenggou.bottomnavigationbar.fragment.IndexFragment;
import com.odbpo.fenggou.bottomnavigationbar.fragment.MineFragment;
import com.odbpo.fenggou.bottomnavigationbar.fragment.MsgFragment;

/**
 * http://blog.csdn.net/u010046908/article/details/50962081
 * https://www.jianshu.com/p/d03d9889ba02
 * https://github.com/Ashok-Varma/BottomNavigation
 */
public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;

    private IndexFragment indexFragment;
    private MsgFragment msgFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigationBar();
        setDefaultFragment();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        indexFragment = IndexFragment.newInstance("index");
        transaction.replace(R.id.frame, indexFragment);
        transaction.commit();
    }

    private void initBottomNavigationBar() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        TextBadgeItem badge=new TextBadgeItem()//
                .setBorderWidth(2)//Badge的Border(边界)宽度//
                .setBorderColor("#3F51B5")//Badge的Border颜色//
                .setBackgroundColor("#FF9BFE")//Badge背景颜色//
                .setGravity(Gravity.RIGHT| Gravity.TOP)//位置，默认右上角
                .setText("51")//显示的文本//
                .setTextColor("#F0F8FF");//文本颜色//
                //.setAnimationDuration(2000)//延迟时间
                //.setHideOnSelect(true);//当选中状态时消失，非选中状态显示
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "消息").setBadgeItem(badge))
                .addItem(new BottomNavigationItem(R.drawable.ic_find_replace_white_24dp, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.ic_github_circle_white_24dp, "我"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
                Log.d("TAG", "onTabSelected() called with: " + "position = [" + position + "]");
                FragmentManager fm = getSupportFragmentManager();
                //开启事务
                FragmentTransaction transaction = fm.beginTransaction();
                switch (position) {
                    case 0:
                        if (indexFragment == null) {
                            indexFragment = IndexFragment.newInstance("index");
                        }
                        transaction.replace(R.id.frame, indexFragment);
                        break;
                    case 1:
                        if (msgFragment == null) {
                            msgFragment = MsgFragment.newInstance("msg");
                        }
                        transaction.replace(R.id.frame, msgFragment);
                        break;
                    case 2:
                        if (findFragment == null) {
                            findFragment = FindFragment.newInstance("爱好");
                        }
                        transaction.replace(R.id.frame, findFragment);
                        break;
                    case 3:
                        if (mineFragment == null) {
                            mineFragment = MineFragment.newInstance("图书");
                        }
                        transaction.replace(R.id.frame, mineFragment);
                        break;
                    default:
                        break;
                }
                // 事务提交
                transaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {//选中 -> 未选中

            }

            @Override
            public void onTabReselected(int position) {//选中 -> 选中

            }
        });
    }

    /**
     * Android设定字体大小，不随系统变化
     * http://blog.csdn.net/peak1chen/article/details/50558139
     * @return
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config=new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config,res.getDisplayMetrics());
        return res;
    }
}
