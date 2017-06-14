package com.example.bahul.myapplication;

/**
 * Created by bahul on 26/5/17.
 */

import android.app.ActionBar;
import android.content.Intent;
        import android.annotation.SuppressLint;
        import android.annotation.TargetApi;
        import android.app.ActionBar;
        import android.app.Activity;
        import android.content.Intent;
import android.net.Uri;
import android.os.Build;
        import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;



@SuppressLint("NewApi")
public class Splash extends Activity {
       public ImageView vi;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_splash);
        Uri uri = Uri.parse("android.resource://com.example.bahul.myapplication/" + R.drawable.a);
        SimpleDraweeView mSimpleDraweeView=(SimpleDraweeView) findViewById(R.id.my_image_view);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        mSimpleDraweeView.setController(controller);
       vi=(ImageView) findViewById(R.id.pl);
        vi.setImageResource(R.drawable.ic_action_name);
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Splash.this.startActivity(new Intent(Splash.this,MainActivity.class));

            }
        } ,5000);



            }

}

