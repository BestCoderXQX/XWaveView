package acffo.xqx.xwaveviewlib;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
* @author xqx
* @email djlxqx@163.com
* blog:http://www.cnblogs.com/xqxacm/
* createAt 2017/11/15
* description: 波浪View
*/

public class XWaveView extends View{

    private Path xPathMain;
    private Path xPathMinor;
    private Paint xPaintMain;    // 淡化的主线条
    private Paint xPaintMinor;   // 主线条
    private int orginY;

    private int alphaMain = 255 ; // 透明值
    private int alphaMinor = 255 ; // 透明值
    private int waveWidth; //波浪X轴偏移量
    private int waveHeight; //波浪Y轴偏移量
    private int offsetAnimator ; //动画偏移量
    private int paddingBottom = 30 ;  // 距离父容器底部的距离
    private int durationTime = 2000; //动画时间


    public XWaveView(Context context) {
        super(context);
    }

    public XWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        xPaintMain = new Paint();
        xPathMain = new Path();

        xPaintMinor = new Paint();
        xPathMinor = new Path();

        xPaintMain.setStrokeWidth(2);
        xPaintMinor.setStrokeWidth(2);
        xPaintMain.setAntiAlias(true);//抗锯齿功能
        xPaintMinor.setAntiAlias(true);//抗锯齿功能

        xPaintMain.setStyle(Paint.Style.FILL_AND_STROKE);
        xPaintMinor.setStyle(Paint.Style.FILL_AND_STROKE);
        xPaintMain.setColor(Color.parseColor("#f1c351"));
        xPaintMinor.setColor(Color.parseColor("#eba703"));
        xPaintMain.setAlpha(alphaMain);
        xPaintMinor.setAlpha(alphaMinor);
        setBackgroundColor(Color.parseColor("#ffffff"));

        waveWidth = 800;
        waveHeight = 20;
        orginY = 5;
        offsetAnimator = 0;
    }


    /**
     * 设置次波浪的颜色透明度 ， 范围为0-255 否则无效
     * @param alphaMinor
     */
    public void setAlphaMinor(int alphaMinor) {
        this.alphaMinor = alphaMinor;
        if (alphaMinor>=0&&alphaMinor<=255) {
            xPaintMinor.setAlpha(alphaMinor);
        }
    }

    /**
     * 设置主波浪的颜色透明度 ，范围为0-255 否则无效
     * @param alphaMain
     */
    public void setAlphaMain(int alphaMain) {
        this.alphaMain = alphaMain;
        if (alphaMain>=0&&alphaMain<=255) {
            xPaintMain.setAlpha(alphaMain);
        }
    }

    /**
     * 同时设置主次波浪的颜色的透明度 ，范围为0-255 否则无效
     * @param alphaMain    主波浪的颜色透明度
     * @param alphaMinor    次波浪的颜色透明度
     */
    public void setAlphaWave(int alphaMain , int alphaMinor){
        this.alphaMinor = alphaMinor;
        this.alphaMain = alphaMain;
        if (alphaMinor>=0&&alphaMinor<=255) {
            xPaintMinor.setAlpha(alphaMinor);
        }
        if (alphaMain>=0&&alphaMain<=255) {
            xPaintMain.setAlpha(alphaMain);
        }
    }


    /**
     * 设置主次波浪颜色
     * @param mainColor  主波浪颜色
     * @param minorColor  次波浪颜色
     */
    public void setxColor(int mainColor , int minorColor){
        xPaintMain.setColor(mainColor);
        xPaintMinor.setColor(minorColor);
    }

    /**
     * 设置波浪的宽度
     * 注意此宽度定义为一上一下两个弧度的宽度
     * @param waveWidth
     */
    public void setWaveWidth(int waveWidth) {
        this.waveWidth = waveWidth;
    }

    public int getWaveHeight() {
        return waveHeight;
    }

    /**
     * 设置波浪的波动幅度
     * @param waveHeight
     */
    public void setWaveHeight(int waveHeight) {
        this.waveHeight = waveHeight;
    }

    public int getDurationTime() {
        return durationTime;
    }

    /**
     * 设置波浪的流动时间，以毫秒为单位  值越大，变换的速度越慢
     * @param durationTime
     */
    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        xPathMain.reset();
        xPathMinor.reset();
        xPathMain.moveTo(-waveWidth +offsetAnimator, getHeight()-orginY-paddingBottom); // 起始点
        xPathMinor.moveTo(-waveWidth+offsetAnimator, getHeight()-orginY-paddingBottom+1); // 起始点
        for (int i = 0; i <= getWidth()+ waveWidth *2; i += waveWidth) {
            xPathMain.rQuadTo(waveWidth /4, waveHeight, waveWidth /2, 0);
            xPathMain.rQuadTo(waveWidth /4, -waveHeight, waveWidth /2, 0);

            xPathMinor.rQuadTo(waveWidth /8*2/3, -waveHeight/2, waveWidth /4, 0);
            xPathMinor.rQuadTo(waveWidth /8*2/3, waveHeight/3, waveWidth /4, 0);
            xPathMinor.rQuadTo(waveWidth /4, -waveHeight, waveWidth /2, 0);
        }

        xPathMain.lineTo(getWidth(), 0);
        xPathMain.lineTo(0, 0);
        xPathMain.close();

        xPathMinor.lineTo(getWidth(), 0);
        xPathMinor.lineTo(0, 0);
        xPathMinor.close();

        canvas.drawPath(xPathMain, xPaintMain);
        canvas.drawPath(xPathMinor, xPaintMinor);
    }

    public void startWave(){
        ValueAnimator animator = ValueAnimator.ofInt(0 , waveWidth);
        animator.setDuration(durationTime);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                offsetAnimator = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

}
