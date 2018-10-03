package com.example.sonaj.graduationproject.Activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.sonaj.graduationproject.CharactorMake;
import com.example.sonaj.graduationproject.R;
import com.example.sonaj.graduationproject.databinding.ActivitySelectPostBinding;

public class SelectMyPostActivity extends AppCompatActivity {

    Context mContext;
    ActivitySelectPostBinding binding;

    //intent 로 받아오는 값
    int group;
    int lvl;
    int order;
    int DrinkKind;
    int Emotion;
    String SelectContent;
    int CocktailReceived;
    int CheeringCock;
    int LaughCock;
    int ComfortCock;
    int SadCock;
    int AngerCock;
    int Views;
    int Image;
    String UploadTime;
    String text;
    String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀 바 삭제
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mContext = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_post);




        //인텐트로 관련 내용 받아오기
        Intent intent = getIntent();
        group  = intent.getIntExtra("group",0);
        lvl  = intent.getIntExtra("lvl",0);
        order  = intent.getIntExtra("order",0);
        DrinkKind  = intent.getIntExtra("DrinkKind",0);
        Emotion  = intent.getIntExtra("Emotion",0);
        SelectContent = intent.getStringExtra("SelectContent");
        text = intent.getStringExtra("text");
        CocktailReceived  = intent.getIntExtra("CocktailReceived",0);
        CheeringCock  = intent.getIntExtra("CheeringCock",0);
        LaughCock = intent.getIntExtra("LaughCock",0);
        ComfortCock = intent.getIntExtra("ComfortCock",0);
        SadCock = intent.getIntExtra("SadCock",2018);
        AngerCock = intent.getIntExtra("AngerCock",2018);
        Views = intent.getIntExtra("Views",2018);
        Image = intent.getIntExtra("Image",2018);
        UploadTime = intent.getStringExtra("UploadTime");
        nickname = intent.getStringExtra("nickname");

        setContentText();

    }

    public void setContentText(){
        binding.tvUsrNickname.setText(nickname);
        binding.tvUsrContent.setText(SelectContent);
        binding.tvWriteTime.setText(UploadTime);
        binding.tvPostContent.setText(text);

        // int 에 String 처리가 필요한 item 들 처리
        binding.tvCheeringCocktailCount.setText("("+CheeringCock+")");
        binding.tvLaughCocktailCount.setText("("+LaughCock+")");
        binding.tvComfortCocktailCount.setText("("+ComfortCock+")");
        binding.tvSadCocktailCount.setText("("+SadCock+")");
        binding.tvAngerCocktailCount.setText("("+AngerCock+")");

        //view
        String views = "";
        if(Views>9){
            views = Views+"회";
        }else{
            views = "0"+Views+"회";
        }
        binding.tvViews.setText(views);

        //receive cocktail
        String receiveCocktail = "";
        if(CocktailReceived>9){
            receiveCocktail = CocktailReceived+"개";
        }else{
            receiveCocktail = "0"+CocktailReceived+"개";
        }
        binding.receiveCocktail.setText(receiveCocktail);

        CharactorMake.setDrinkBackgroundColor(DrinkKind,binding.rlDrinkColor);
        CharactorMake.setEmotionFace(Emotion,binding.imEmotion);

    }
}
