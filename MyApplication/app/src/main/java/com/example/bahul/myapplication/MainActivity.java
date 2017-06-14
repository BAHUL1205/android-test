package com.example.bahul.myapplication;

import android.app.ActionBar;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends Activity implements Animation.AnimationListener {

    Animation animFadein;
    Animation animationbounce;
    ImageView v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);



        // load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),

                R.anim.sequential);
        animationbounce = AnimationUtils.loadAnimation(getApplicationContext(),

                R.anim.bounce);

        v1=  (ImageView) findViewById(R.id.imgLogo);
        v1.setImageResource(R.drawable.placiosymbol);
        v1.startAnimation(animFadein);
        animFadein.setAnimationListener(this);
// start the animation



        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, main2.class));
            }
        });

    }
    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override

    public void onAnimationEnd(Animation animation) {
        if (animation == animFadein) {

            Toast.makeText(getApplicationContext(), "Click PLACIO",
                    Toast.LENGTH_SHORT).show();
            onAnimationRepeat(animationbounce);

        }}

    @SuppressWarnings("ResourceAsColor")
    @Override
    public void onAnimationRepeat(Animation animation) {

        if (animation == animationbounce) {

            v1.startAnimation(animationbounce);
        }}

}