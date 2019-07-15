package android.saif.employeportal;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class MenuModel {

    public   int drawable;
    public String menuName;
       int count;
    public boolean hasChildren, isGroup;

    public MenuModel(String menuName, boolean isGroup, boolean hasChildren, int drawable,int count) {
        this.drawable=drawable;
        this.menuName = menuName;
this.count=count;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }
}
