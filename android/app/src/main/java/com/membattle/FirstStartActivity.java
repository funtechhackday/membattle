package com.membattle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class FirstStartActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

            /*getBackButtonTranslationWrapper()
                    .setEnterTranslation(new IViewTranslation() {
                        @Override
                        public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                            view.setAlpha(percentage);
                        }
                    });
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.first_slide_background)
                    .buttonsColor(R.color.first_slide_buttons)
                    .title("Mems Battle")
                    .description("Текст")
                    .build());
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.second_slide_background)
                    .buttonsColor(R.color.second_slide_buttons)
                    .title("Заголовок")
                    .description("Текст")
                    .build());

            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.third_slide_background)
                    .buttonsColor(R.color.third_slide_buttons)
                    .title("Заголовк")
                    .description("Текст")
                    .build());*/
        addSlide(new FirstSlide("первый"));
        addSlide(new FirstSlide("второй"));
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }
}