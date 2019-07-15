package android.saif.employeportal;

import android.animation.Animator;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.webkit.WebView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.prefs.AbstractPreferences;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView mImageView;
    LinearLayout fab_icon;
    FrameLayout gray_bg;
    LinearLayout Profilemenue;
    LinearLayout profile;
    View menu_expaded;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    FloatingActionButton fab;
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.nav_toggle);
        expandableListView = findViewById(R.id.expandableListView);
        menu_expaded = findViewById(R.id.menu_expanded);
        Profilemenue = findViewById(R.id.Profile_menue);
        profile = findViewById(R.id.Profile);
        fab = findViewById(R.id.fab);
        fab_icon = findViewById(R.id.fabs);
        gray_bg = findViewById(R.id.background);
        setlisteneres();
        prepareMenuData();
        populateExpandableList();
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);


//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, mImageView, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                } else
                    drawer.closeDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setlisteneres() {
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
                Toast.makeText(MainActivity.this, "attendence clicked", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void prepareMenuData() {
        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel menuModel = new MenuModel("Employee Portal", true, true, R.drawable.employeeportal,0); //Menu of Android Tutorial. No sub menus
        headerList.add(menuModel);
        childModelsList.add(new MenuModel("Document", false, false, R.drawable.nav_doc,0));
        childModelsList.add(new MenuModel("Leaves", false, false, R.drawable.nav_leave,1));
        childModelsList.add(new MenuModel("Petty Cash", false, false, R.drawable.nav_pettycash,2));
        childModelsList.add(new MenuModel("Payslips", false, false, R.drawable.nav_pay,3));
        childModelsList.add(new MenuModel("Salary Advance", false, false, R.drawable.nav_salary,0));
        childModelsList.add(new MenuModel("Loans", false, false, R.drawable.nav_load,0));
        childModelsList.add(new MenuModel("Assets", false, false, R.drawable.nav_asset,0));
        childModelsList.add(new MenuModel("Savings", false, false, R.drawable.nav_sav,0));
        if (menuModel.hasChildren) {
            childList.put(menuModel,childModelsList);

        }

        menuModel = new MenuModel("Profile", true, false, R.drawable.portal,0); //Menu of Java Tutorials
        headerList.add(menuModel);

        menuModel = new MenuModel("Communication", false, false, R.drawable.communication,0);
        headerList.add(menuModel);
        menuModel = new MenuModel("More", false, false, R.drawable.more,0);
        headerList.add(menuModel);
        menuModel = new MenuModel("Setting", false, false, R.drawable.setting,0);
        headerList.add(menuModel);

    }

    private void populateExpandableList() {

        expandableListAdapter = new android.saif.employeportal.ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
//
                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);

                }

                return false;
            }
        });
    }
}
