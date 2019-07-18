package android.saif.employeportal;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DocumentActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FrameLayout gray_bg;
    LinearLayout Profilemenue;
    LinearLayout profile;
    LinearLayout fab_icon;
    FloatingActionButton fab;
    View menu_expaded;
    private View belllayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        mRecyclerView = findViewById(R.id.recycler);
        menu_expaded = findViewById(R.id.menu_expanded);
        belllayout = findViewById(R.id.bell_layout);
        Profilemenue = findViewById(R.id.Profile_menue);
        profile = findViewById(R.id.Profile);
        fab = findViewById(R.id.fab);
        fab_icon = findViewById(R.id.fabs);
        gray_bg = findViewById(R.id.background);
        mRecyclerView.setAdapter(new MyAdapter());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        View back=findViewById(R.id.nav_toggle);
        back.setOnClickListener(new View.OnClickListener() {
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
                startActivity(new Intent(DocumentActivity.this, NotificationActivity.class));
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
        CardView attendance = findViewById(R.id.attendence);
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DocumentActivity.this, "attendence clicked", Toast.LENGTH_SHORT).show();
            }
        });
        gray_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fab_icon.getVisibility() == View.VISIBLE)
                    toggleFab();
                if (menu_expaded.getVisibility() == View.VISIBLE)
                    togglemenue();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                toggleFab();
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

    private void toggleFab() {
        if (fab_icon.getVisibility() == View.GONE) {

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

            fab_icon.animate()
                    .translationY(0)
                    .alpha(1.0f)
                    .setDuration(150).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    fab_icon.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

        } else {
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
            fab_icon.animate()
                    .translationY(fab_icon.getHeight())
                    .alpha(0.0f)
                    .setDuration(150).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    fab_icon.setVisibility(View.GONE);
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


    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        public MyAdapter() {

        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.document_single, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {


        }

        @Override
        public int getItemCount() {
            return 8;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
