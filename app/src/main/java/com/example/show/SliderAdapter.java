package com.example.show;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slider_images={
            R.drawable.eat,
            R.drawable.sleep,
            R.drawable.watch
    };

    public String[] slide_heading={
            "EAT",
            "SLEEP",
            "Listen"
  };
//    public String[] slide_descs={
//            "mhvbh,jvsajhdsjlavahbhkb .bajkskhbabsbsjkabslabb.ab.kasb.hkb"+"aliqua",
//            "hbkbc,shhls,lshlhsla,akjsd;baj;,ajksbbs;ajbjsan asjnjj;sjajd"+"aliqua",
//            ""+"aliqua"
//    };



    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }


    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);


        ImageView slideImageView=(ImageView) view.findViewById(R.id.imageView);
        TextView slideHeading=(TextView)view.findViewById(R.id.heder);
        TextView slideDescription=(TextView)view.findViewById(R.id.decr);


        slideImageView.setImageResource(slider_images[position]);
        slideHeading.setText(slide_heading[position]);
       // slideDescription.setText(slide_descs[position]);

        container.addView(view);
        return  view;
    }

    @Override
    public  void destroyItem(ViewGroup container,int position,Object object)
    {
        container.removeView((RelativeLayout)object);
    }
}
