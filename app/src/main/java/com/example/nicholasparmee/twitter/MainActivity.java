package com.example.nicholasparmee.twitter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.io.File;

import pager.pdfslider;
import rating.rating_fragment;

public class MainActivity extends ListActivity {


    private Button webBtn;
    private Button promiseBtn;
    private Button webbackBtn;
    private Button homeBtn;
    private Button ratingBtn;
    private Button sumbitBtn;
    private Button slideBtn;
    private LinearLayout promisepage;
    private LinearLayout twitter;
    private LinearLayout ratingslayout;
    private VideoView video;
    private MediaController m;

    private WebView myWebView;

    private ViewPager pdfsliding;

    private FrameLayout ratingfragment;

    private VideoView vv;
    private MediaController mediacontroller;
    private Uri uri;
    private boolean isContinuously = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Twitter.initialize(this);

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("CONSUMER_KEY", "CONSUMER_SECRET"))
                .debug(true)
                .build();
        Twitter.initialize(config);


            final UserTimeline userTimeline = new UserTimeline.Builder()
                    .screenName("Dunloptyres_SA")
                    .build();
            final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                    .setTimeline(userTimeline)
                    .build();
            setListAdapter(adapter);


        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://www.dunloptyres.co.za");

        sumbitBtn = findViewById(R.id.sumbitBtn);

        // video = findViewById(R.id.videopage);
        pdfsliding = findViewById(R.id.pdfslider);

        ratingslayout =  findViewById(R.id.ratinglayout);

        ratingfragment = findViewById(R.id.fragment);
        twitter = findViewById(R.id.twitter);
        vv = (VideoView) findViewById(R.id.vv);

        mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(vv);
        String uriPath = "android.resource://com.example.nicholasparmee.twitter/"+R.raw.sap;  //update package name
        uri = Uri.parse(uriPath);

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isContinuously){
                    vv.start();
                }
            }
        });


        //  final String uriPath = "android.resource://com.example.nicholasparmee.template_kiosk_2/" + R.raw.mov;
       // String uriPath = "https://r6---sn-5hnedn7s.googlevideo.com/videoplayback?pl=15&ei=sI1PW7ujC5eptQfh8KvgBQ&expire=1531961872&clen=3547015&gir=yes&mime=video%2Fmp4&c=WEB&ratebypass=yes&ipbits=0&sparams=clen,dur,ei,expire,gir,id,initcwndbps,ip,ipbits,ipbypass,itag,lmt,mime,mip,mm,mn,ms,mv,pl,ratebypass,requiressl,source,usequic&requiressl=yes&id=o-AN4voqxCWQ-k-3dGJqKLLN8rd0G6r9g9RJtwvKmZGkGz&dur=45.069&itag=18&fexp=23709359,23745105&ip=2600%3A3c00%3A%3Af03c%3A91ff%3Afe52%3Af0d3&key=cms1&lmt=1468991102349639&fvip=5&source=youtube&signature=36CFFD2C7CED3AF4DEA10E922E3D0888336BA7E3.7D521EA5C02403D2E4357772AC1B29180F2470C3&title=Dunlop+-+Take+the+road+-+Television+commercial&rm=sn-q4fel676&req_id=bbd6e626b52ea3ee&ipbypass=yes&mip=197.91.138.31&cm2rm=sn-hfxc-wocl7e,sn-wocd7e&redirect_counter=3&cms_redirect=yes&mm=34&mn=sn-5hnedn7s&ms=ltu&mt=1531940193&mv=m&usequic=no";     uri = Uri.parse(uriPath);


        pdfslider viewPagerAdapter = new pdfslider(this);

        pdfsliding.setAdapter(viewPagerAdapter);


      //  ratingfragment = findViewById(R.id.fragment);

        promiseBtn = findViewById(R.id.promisepageBtn);
        promisepage = findViewById(R.id.promisepage);
        webBtn = findViewById(R.id.webBtn);
        webbackBtn = findViewById(R.id.webbackBtn);
        homeBtn = findViewById(R.id.homeBtn);
        ratingBtn = findViewById(R.id.ratingBtn);
        slideBtn = findViewById(R.id.slidesBtn);

        slideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scrollitem_animation);
                slideBtn.startAnimation(ani);

                ani.setAnimationListener(new Animation.AnimationListener(){

                    @Override
                    public void onAnimationStart(Animation animation){}

                    @Override
                    public void onAnimationRepeat(Animation animation){}

                    @Override
                    public void onAnimationEnd(Animation animation){
                        AllGone();
                        pdfsliding.setVisibility(View.VISIBLE);
                        webbackBtn.setVisibility(View.VISIBLE);
                    }
                });
                view.startAnimation(ani);
            }
        });

        sumbitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scrollitem_animation);
                sumbitBtn.startAnimation(ani);

                ani.setAnimationListener(new Animation.AnimationListener(){

                    @Override
                    public void onAnimationStart(Animation animation){}

                    @Override
                    public void onAnimationRepeat(Animation animation){}

                    @Override
                    public void onAnimationEnd(Animation animation){
                        AllGone();
                        vv.setVisibility(View.VISIBLE);
                        isContinuously = true;
                        vv.setMediaController(mediacontroller);
                        vv.setVideoURI(uri);
                        vv.requestFocus();
                        vv.start();
                    }
                });
                view.startAnimation(ani);
            }
        });

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scrollitem_animation);
                webBtn.startAnimation(ani);

                ani.setAnimationListener(new Animation.AnimationListener(){

                    @Override
                    public void onAnimationStart(Animation animation){}

                    @Override
                    public void onAnimationRepeat(Animation animation){}

                    @Override
                    public void onAnimationEnd(Animation animation){

                        myWebView.setVisibility(View.VISIBLE);
                        webbackBtn.setVisibility(View.VISIBLE);
                    }
                });
                view.startAnimation(ani);
            }
        });


        webbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scrollitem_animation);
                webbackBtn.startAnimation(ani);

                ani.setAnimationListener(new Animation.AnimationListener(){

                    @Override
                    public void onAnimationStart(Animation animation){}

                    @Override
                    public void onAnimationRepeat(Animation animation){}

                    @Override
                    public void onAnimationEnd(Animation animation){
                        AllGone();
                        vv.setVisibility(View.VISIBLE);
                        isContinuously = true;
                        vv.setMediaController(mediacontroller);
                        vv.setVideoURI(uri);
                        vv.requestFocus();
                        vv.start();
                    }
                });
                view.startAnimation(ani);

            }
        });



        ratingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scrollitem_animation);
                ratingBtn.startAnimation(ani);

                ani.setAnimationListener(new Animation.AnimationListener(){

                    @Override
                    public void onAnimationStart(Animation animation){}

                    @Override
                    public void onAnimationRepeat(Animation animation){}

                    @Override
                    public void onAnimationEnd(Animation animation){

                        AllGone();
                        ratingslayout.setVisibility(View.VISIBLE);
                        ratingfragment.setVisibility(View.VISIBLE);
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.add(R.id.fragment, new rating_fragment());


                        ft.commit();
                    }
                });
                view.startAnimation(ani);
            }
        });

        promiseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scrollitem_animation);
                promiseBtn.startAnimation(ani);

                ani.setAnimationListener(new Animation.AnimationListener(){

                    @Override
                    public void onAnimationStart(Animation animation){}

                    @Override
                    public void onAnimationRepeat(Animation animation){}

                    @Override
                    public void onAnimationEnd(Animation animation){

                        AllGone();
                        promisepage.setVisibility(View.VISIBLE);
                    }
                });
                view.startAnimation(ani);

            }
        });


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scrollitem_animation);
                homeBtn.startAnimation(ani);

                ani.setAnimationListener(new Animation.AnimationListener(){

                    @Override
                    public void onAnimationStart(Animation animation){}

                    @Override
                    public void onAnimationRepeat(Animation animation){}

                    @Override
                    public void onAnimationEnd(Animation animation){

                        AllGone();
                       // twitter.setVisibility(View.VISIBLE);
                        vv.setVisibility(View.VISIBLE);
                        isContinuously = true;
                        vv.setMediaController(mediacontroller);
                        vv.setVideoURI(uri);
                        vv.requestFocus();
                        vv.start();
                    }
                });
                view.startAnimation(ani);

            }
        });

    }


    public void AllGone(){

        ratingslayout.setVisibility(View.GONE);
        myWebView.setVisibility(View.GONE);
        webbackBtn.setVisibility(View.GONE);
        vv.stopPlayback();
        vv.setVisibility(View.GONE);
        promisepage.setVisibility(View.GONE);
        ratingfragment.setVisibility(View.GONE);
        pdfsliding.setVisibility(View.GONE);
        pdfsliding.setVisibility(View.GONE);
        FragmentManager fm = getFragmentManager();
        if(fm.getBackStackEntryCount()>0) {
            fm.popBackStack();

        }

    }

}

