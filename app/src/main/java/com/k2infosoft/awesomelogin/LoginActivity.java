package com.k2infosoft.awesomelogin;

import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;

import com.k2infosoft.awesomelogin.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.setActivity(this);
        fab =(FloatingActionButton)findViewById(R.id.fab);
    }

    public void onFabButtonClick(){
        getWindow().setExitTransition(null);
        getWindow().setEnterTransition(null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =
                    ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
            startActivity(new Intent(this, SignUpActivity.class), options.toBundle());
        } else {
            startActivity(new Intent(this, SignUpActivity.class));
        }

        //Toast.makeText(this,email,Toast.LENGTH_SHORT).show();
    }

    public void onButtonClick(){
        Explode explode = new Explode();
        explode.setDuration(500);

        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);
        ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent i2 = new Intent(this,MainActivity.class);
        startActivity(i2, oc2.toBundle());
    }

    public void onForgotClick(){
        getWindow().setExitTransition(null);
        getWindow().setEnterTransition(null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =
                    ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
            startActivity(new Intent(this, ForgotPassActivity.class), options.toBundle());
        } else {
            startActivity(new Intent(this, ForgotPassActivity.class));
        }

    }
}
