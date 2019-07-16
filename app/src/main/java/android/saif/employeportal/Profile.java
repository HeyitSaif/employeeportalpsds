package android.saif.employeportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class Profile extends AppCompatActivity {

    FrameLayout gray_bg;
    LinearLayout Profilemenue;
    LinearLayout profile;

    View menu_expaded;
    private View belllayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        menu_expaded = findViewById(R.id.menu_expanded);
        belllayout = findViewById(R.id.bell_layout);
        Profilemenue = findViewById(R.id.Profile_menue);
        profile = findViewById(R.id.Profile);
        gray_bg = findViewById(R.id.background);
        View nav_bar=findViewById(R.id.nav_toggle);
        nav_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        setlisteneres();
    }
    private void setlisteneres() {
        belllayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, NotificationActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglemenue();
            }
        });
        Profilemenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglemenue();
            }
        });

        gray_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (menu_expaded.getVisibility() == View.VISIBLE)
                    togglemenue();
            }
        });

    }

    private void togglemenue() {
        if (menu_expaded.getVisibility() == View.GONE) {
            menu_expaded.animate()
                    .translationY(0)
                    .alpha(1.0f)
                    .setDuration(150).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    menu_expaded.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            gray_bg.animate()
                    .alpha(1.0f)
                    .setDuration(150).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    gray_bg.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            menu_expaded.animate()
                    .translationY(0)
                    .alpha(0.0f)
                    .setDuration(150).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    menu_expaded.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            gray_bg.animate()
                    .alpha(0.0f)
                    .setDuration(150).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    gray_bg.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
    }

}
