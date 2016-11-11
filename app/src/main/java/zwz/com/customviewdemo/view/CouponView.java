package zwz.com.customviewdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import zwz.com.customviewdemo.R;

/**
 * Created by 朱伟志 on 2016/11/11 0011 13:32.
 */
public class CouponView extends LinearLayout {
    private  int mCircleColor;
    private Paint mRadiusPaint;
    private float mRadius;
    private float mSpace=10;
    private float mRemain;
    public CouponView(Context context) {
        super(context);
        initPaint();
    }

    public CouponView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CouponView);
        mCircleColor =styledAttributes.getColor(R.styleable.CouponView_circleColor,0xffff0000);
        mRadius=styledAttributes.getDimension(R.styleable.CouponView_radius,20);
        mSpace=styledAttributes.getDimension(R.styleable.CouponView_radius,10);
        styledAttributes.recycle();
        initPaint();

    }

    private void initPaint(){
        mRadiusPaint=new Paint();
        mRadiusPaint.setColor(mCircleColor);
        mRadiusPaint.setAntiAlias(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int circleCount= (int) ((width-mSpace)/(2*mRadius+mSpace));
        float remain = (int)(width-mSpace)%(2*mRadius+mSpace);
        for (int i = 0; i < circleCount; i++) {
            float x = mSpace+mRadius+remain/2+((mSpace+mSpace*2)*i);
            canvas.drawCircle(x,0,mRadius,mRadiusPaint);
            canvas.drawCircle(x,height,mRadius,mRadiusPaint);
        }
    }

}
