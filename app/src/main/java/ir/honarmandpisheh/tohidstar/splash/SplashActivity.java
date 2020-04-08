package ir.honarmandpisheh.tohidstar.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.skyfishjy.library.RippleBackground;

import ir.honarmandpisheh.tohidstar.R;
import ir.honarmandpisheh.tohidstar.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_splash);

        RippleBackground background = findViewById(R.id.Ripple);
        background.startRippleAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(
                        SplashActivity.this,
                        LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        finish();
            }
        }, 2000);
    }
}
