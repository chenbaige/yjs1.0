package com.yjtc.cbg.yjsapp.util;

/**
 * Created by chen on 2016/5/20.
 */

import android.widget.ImageView;

public class SceneAnimationUtil {

    private ImageView mImageView;
    private int[] mFrameRess;
    private int[] mDurations;
    private int mDuration;

    private int mLastFrameNo;
    private long mBreakDelay;

    private onAnimationEndListener mListener;

    public void setmListener(onAnimationEndListener mListener) {
        this.mListener = mListener;
    }

    public SceneAnimationUtil(ImageView pImageView, int[] pFrameRess,
                              int[] pDurations) {
        mImageView = pImageView;
        mFrameRess = pFrameRess;
        mDurations = pDurations;
        mLastFrameNo = pFrameRess.length - 1;

        mImageView.setBackgroundResource(mFrameRess[0]);
        play(1);
    }

    public SceneAnimationUtil(ImageView pImageView, int[] pFrameRess, int pDuration, onAnimationEndListener mListener) {
        mImageView = pImageView;
        this.mListener=mListener;
        mFrameRess = pFrameRess;
        mDuration = pDuration;
        mLastFrameNo = pFrameRess.length - 1;

        mImageView.setBackgroundResource(mFrameRess[0]);
        playConstant(1);
    }

    public SceneAnimationUtil(ImageView pImageView, int[] pFrameRess,
                              int pDuration, long pBreakDelay) {
        mImageView = pImageView;
        mFrameRess = pFrameRess;
        mDuration = pDuration;
        mLastFrameNo = pFrameRess.length - 1;
        mBreakDelay = pBreakDelay;

        mImageView.setBackgroundResource(mFrameRess[0]);
        playConstant(1);
    }

    private void play(final int pFrameNo) {
        mImageView.postDelayed(new Runnable() {
            public void run() {
                mImageView.setBackgroundResource(mFrameRess[pFrameNo]);
                if (pFrameNo == mLastFrameNo)
                    play(0);
                else
                    play(pFrameNo + 1);
            }
        }, mDurations[pFrameNo]);
    }

    private void playConstant(final int pFrameNo) {
        mImageView.postDelayed(new Runnable() {
            public void run() {
                mImageView.setBackgroundResource(mFrameRess[pFrameNo]);
                if (pFrameNo == mLastFrameNo){
                    mListener.click();
                }
                else{
                    playConstant(pFrameNo + 1);
                }
            }
        }, pFrameNo == mLastFrameNo && mBreakDelay > 0 ? mBreakDelay
                : mDuration);
    }

   public interface onAnimationEndListener{
        void click();
    }
}
