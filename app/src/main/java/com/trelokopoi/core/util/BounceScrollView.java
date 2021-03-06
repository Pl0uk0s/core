package com.trelokopoi.core.util;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class BounceScrollView extends ScrollView
{
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;

    //private Context mContext;
    private int mMaxYOverscrollDistance;

    public BounceScrollView(Context context) {
        super(context);
        //mContext = context;
        initBounceScrollView(context);
    }

    public BounceScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //mContext = context;
        initBounceScrollView(context);
    }

    public BounceScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //mContext = context;
        initBounceScrollView(context);
    }

 // true if we can scroll (not locked)
    // false if we cannot scroll (locked)
    private boolean mScrollable = true;

    public void setScrollingEnabled(boolean enabled) {
        mScrollable = enabled;
    }

    public boolean isScrollable() {
        return mScrollable;
    }    
    
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // if we can scroll pass the event to the superclass
                if (mScrollable) return super.onTouchEvent(ev);
                // only continue to handle the touch event if scrolling enabled
                return mScrollable; // mScrollable is always false at this point
            default:
                return super.onTouchEvent(ev);
        }
    }



	@Override  
	public boolean onInterceptTouchEvent(MotionEvent ev) {
	    switch (ev.getAction()) {     
	    case MotionEvent.ACTION_DOWN:         
	        // if we can scroll pass the event to the superclass      
	        if (mScrollable) return super.onInterceptTouchEvent(ev);      
	        // only continue to handle the touch event if scrolling enabled    
	        return mScrollable; // mScrollable is always false at this point     
	        default:          
	            return super.onInterceptTouchEvent(ev);      
	            }
	    }   
    
    private void initBounceScrollView(Context context) {
        //get the density of the screen and do some maths with it on the max overscroll distance
        //variable so that you get similar behaviors no matter what the screen size

        final DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            final float density = metrics.density;

        mMaxYOverscrollDistance = (int) (density * MAX_Y_OVERSCROLL_DISTANCE);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        //This is where the magic happens, we have replaced the incoming maxOverScrollY with our own custom variable mMaxYOverscrollDistance; 
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);  
    }
    


}
