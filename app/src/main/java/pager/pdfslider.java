package pager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nicholasparmee.twitter.R;

/**
 * Created by nicholasparmee on 2018/07/15.
 * Under the project title Template_Kiosk_2
 */

public class pdfslider extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.smart1,R.drawable.smart2};


    public pdfslider(Context context){

        this.context = context;

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    public Object instantiateItem(ViewGroup container, int position){

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.pdf_layout,null);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;

    }


    public void destroyItem(ViewGroup container, int position, Object object){
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
