package android.saif.employeportal;

public class model_message {
    int type;
    boolean hasfile;

    String text;

    public model_message(String s, int i, boolean b) {
        text=s;
        type=i;
        hasfile=b;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isHasfile() {
        return hasfile;
    }

    public void setHasfile(boolean hasfile) {
        this.hasfile = hasfile;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
