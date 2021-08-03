package com.app.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.login.annotation.ClickBehavior;
import com.app.login.annotation.LoginBehavior;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "aop_aspect >>> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @ClickBehavior("登录")
    public void login(View view) {
        Log.e(TAG,"登录！！！");
        startActivity(new Intent(this, LoginActivity.class));
    }

    @ClickBehavior("专区")
    @LoginBehavior
    public void area(View view) {
        Log.e(TAG,"专区！！！");
        startActivity(new Intent(this, OtherActivity.class));
    }

    @ClickBehavior("优惠券")
    @LoginBehavior
    public void coupon(View view) {
        Log.e(TAG,"优惠券！！！");
        startActivity(new Intent(this, OtherActivity.class));
    }

    @ClickBehavior("积分")
    @LoginBehavior
    public void score(View view) {
        Log.e(TAG,"积分！！！");
        startActivity(new Intent(this, OtherActivity.class));
    }
}