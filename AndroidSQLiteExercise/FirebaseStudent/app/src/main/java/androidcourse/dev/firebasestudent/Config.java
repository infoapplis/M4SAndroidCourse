package androidcourse.dev.firebasestudent;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Kobe Kid Bi on 29/07/2016.
 */
public class Config extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
