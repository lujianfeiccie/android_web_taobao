package com.lujianfei.taobao_alimama;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class TabActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText("tab2");
        text.setTextSize(100);
        text.setBackgroundColor(Color.RED);
        setContentView(text);
    }
}
