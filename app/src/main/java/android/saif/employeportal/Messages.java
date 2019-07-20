package android.saif.employeportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.AbstractList;
import java.util.ArrayList;

public class Messages extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FrameLayout gray_bg;
    LinearLayout Profilemenue;
    LinearLayout profile;

    View menu_expaded;
    private View belllayout;
    private ArrayList<model_message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        mRecyclerView = findViewById(R.id.recycler);
        menu_expaded = findViewById(R.id.menu_expanded);
        belllayout = findViewById(R.id.bell_layout);
        Profilemenue = findViewById(R.id.Profile_menue);
        profile = findViewById(R.id.Profile);
        gray_bg = findViewById(R.id.background);
        messages=new ArrayList<>();
        fillarray();
        mRecyclerView.setAdapter(new MyAdapter(messages));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        setlisteneres();
        View back=findViewById(R.id.nav_toggle);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void fillarray() {

        messages.add(new model_message("How's it going with the rebrand? Can't\n" +
                "wait to see the concepts.",0,false));
        messages.add(new model_message("All Done!",1,false));
        messages.add(new model_message("Awesome",0,false));
        messages.add(new model_message("Can you send it over? Would love a look!",0,false));
        messages.add(new model_message("Of course. Here it is.",1,false));
        messages.add(new model_message("",1,true));
        messages.add(new model_message("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, " +
                "sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat," +
                "sed diam voluptua. At vero eos et accusam et",0,false));  messages.add(new model_message("How's it going with the rebrand? Can't\n" +
                "wait to see the concepts.",0,false));
        messages.add(new model_message("All Done!",1,false));
        messages.add(new model_message("Awesome",0,false));
        messages.add(new model_message("Can you send it over? Would love a look!",0,false));
        messages.add(new model_message("Of course. Here it is.",1,false));
        messages.add(new model_message("",1,true));
        messages.add(new model_message("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, " +
                "sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat," +
                "sed diam voluptua. At vero eos et accusam et",0,false));


    }

    private void setlisteneres() {
        belllayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Messages.this, NotificationActivity.class));
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




    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private final ArrayList<model_message> messages;

        public MyAdapter(ArrayList<model_message> messages) {
this.messages=messages;
        }


        @Override
        public int getItemViewType(int position) {
            if (messages.get(position).hasfile)return 2;
            else if (messages.get(position).type==0)return 0;
            else return 1;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           if (viewType==2) return new MyViewHolder(LayoutInflater.from(parent.getContext())
                   .inflate(R.layout.file, parent, false));
              else if (viewType == 0) {
                return new MyViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.reciece_message, parent, false));
            }
              else
               return new MyViewHolder(LayoutInflater.from(parent.getContext())
                       .inflate(R.layout.sent_message_single, parent, false));
        }
        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {


        }

        @Override
        public int getItemCount() {
            return messages.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
