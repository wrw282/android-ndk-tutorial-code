package com.mamlambo.sample.ndk1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AndroidNDK1SampleActivity extends Activity {
    private static final String DEBUG_TAG = "AndroidNDK1SampleActivity";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onCallNative1(View view) {
        // call to the native method
        helloLog("This will log to LogCat via the native call.");
    }
    
    public void onCallNative2(View view) {
        String result = getString(5,2);
        Log.v(DEBUG_TAG, "Result: "+result);
        
        result = getString(105, 1232);
        Log.v(DEBUG_TAG, "Result2: "+result);
    }
    
    private native void helloLog(String logThis);
    private native String getString(int value1, int value2);
    
    static {
        System.loadLibrary("ndk1");
    }
    
}