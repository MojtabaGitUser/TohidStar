package ir.honarmandpisheh.tohidstar;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

import io.realm.Realm;

public class BaseApplication extends Application {


    @Override
    public void onCreate() {

        super.onCreate();
        Hawk.init(this).build();
        Realm.init(this);
    }


}
