package acffo.xqx.xwaveview;

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
        xWaveView.startWave();
//        gradlew clean build bintrayUpload -PbintrayUser=acffo -PbintrayKey=002934430dfe836f7d2cc159ec0c341eee48ffe6 -PdryRun=false
//        gradlew clean build bintrayUpload
//        -PbintrayUser=acffo
//        -PbintrayKey=002934430dfe836f7d2cc159ec0c341eee48ffe6
//        -PdryRun=false

    }

}
