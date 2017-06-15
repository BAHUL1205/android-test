package com.example.bahul.testingnewcase;
/**
 * Created by bahul on 7/6/17.
 */
import android.app.ActionBar;
import android.content.Intent;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
@SuppressLint("NewApi")
public class Splash extends Activity {
    public ImageView vi;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.splash);
        Uri uri = Uri.parse("android.resource://com.example.bahul.myapplication/" + R.drawable.a);
        SimpleDraweeView mSimpleDraweeView=(SimpleDraweeView) findViewById(R.id.my_image_view);
        mSimpleDraweeView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        mSimpleDraweeView.setController(controller);
        vi=(ImageView) findViewById(R.id.pl);
        vi.setImageResource(R.mipmap.ic_launcher);
        ActionBar actionBar = getActionBar();
        actionBar.hide();
new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Splash.this.startActivity(new Intent(Splash.this,MainActivity.class));

            }
        } ,5000);
    }}

