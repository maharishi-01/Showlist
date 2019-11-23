package com.example.show;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private ViewPager mSliderViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mSliderViewPager =(ViewPager)findViewById(R.id.slideViewPager);
        mDotLayout=(LinearLayout) findViewById(R.id.dotsLayout);
        sliderAdapter=new SliderAdapter(this);
        mSliderViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);

        mSliderViewPager.addOnPageChangeListener(viewListaner);

    }

    public void addDotsIndicator(int position){

        mDots=new TextView[3];
        mDotLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++)
        {
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0){

            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListaner=new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void skipone(View view) {

        Intent intent=new Intent(Main3Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
