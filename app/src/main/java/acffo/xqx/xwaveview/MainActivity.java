package acffo.xqx.xwaveview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import acffo.xqx.xwaveviewlib.XWaveView;

public class MainActivity extends AppCompatActivity {
    private XWaveView xWaveView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xWaveView = (XWaveView) findViewById(R.id.xWaveView);
        xWaveView.startWave(); //开启波浪动画

    }

}
