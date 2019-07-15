package android.saif.employeportal;

import android.animation.Animator;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View menu_expaded;
    private View gray_bg;
    LinearLayout Profilemenue;
    LinearLayout profile;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        recyclerView=findViewById(R.id.recycler);

        gray_bg = findViewById(R.id.gray_bg);
        menu_expaded = findViewById(R.id.menu_expanded);
        Profilemenue = findViewById(R.id.Profile_menue);
        profile = findViewById(R.id.Profile);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
setlisteners();
        // specify an adapter (see also next example)

        recyclerView.setAdapter(new MyAdapter());
    }

    private void setlisteners() {profile.setOnClickListener(new View.OnClickListener() {
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


    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        
        public MyAdapter() {

        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.notification_single, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
