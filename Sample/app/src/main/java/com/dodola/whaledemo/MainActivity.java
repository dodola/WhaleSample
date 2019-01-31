package com.dodola.whaledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lody.whale.xposed.XC_MethodHook;
import com.lody.whale.xposed.XposedHelpers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XposedHelpers.findAndHookMethod(MainActivity.class, "TextClick", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                Toast.makeText(MainActivity.this, "before text click", Toast.LENGTH_SHORT).show();
            }
        });
        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextClick();
            }
        });
    }

    public void TextClick() {
        Log.d("TTTTT", "AAAAA");
    }
}
