# XWaveView
波浪流动效果

-----------------------------------------------
 ![image](https://github.com/BestCoderXQX/XWaveView/raw/master/screenshots/bbb.gif)


Gradle：
-------------------------------
compile 'acffo.xqx.xwaveviewlib:maven:1.0.0'


Usage：

  ------------------------------------------------
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="180dp"
        android:background="#eba703"
        >

        <acffo.xqx.xwaveviewlib.XWaveView
            android:id="@+id/xWaveView"
            android:layout_width="match_parent"
            android:layout_height="30dp"
            android:layout_gravity="bottom"
            >
        </acffo.xqx.xwaveviewlib.XWaveView>
    </FrameLayout>
    
 ----------------------------------------------------
 
    xWaveView = (XWaveView) findViewById(R.id.xWaveView);
        
    xWaveView.startWave(); //开启波浪动画
        
 ------------------------------------------------
       
        可设置属性：
        
        
        xWaveView.setWaveWidth(800); // 设置波浪的X轴幅度，一上一下为一个单位
        
        xWaveView.setWaveHeight(20); // 设置波浪的Y轴幅度
        
        xWaveView.setxColor(Color.parseColor("f1c351"),Color.parseColor("eba703")); // 设置两个波浪的颜色
        
        xWaveView.setAlphaWave(255,255);  // 设置波浪背景的透明度
        
        xWaveView.setDurationTime(3000);  // 设置动画时间 时间越长，波动越慢 ，单位：毫秒
        
        xWaveView.startWave(); //开启波浪动画
        
        
真实项目app效果图：

 ![image](https://github.com/BestCoderXQX/XWaveView/raw/master/screenshots/aaa.gif)
 

