package entity;

/**
 * @author trafalgar
 */
public class Authority {

    private Integer arid;
    private String aname;
    private String role;
    private boolean isEnabled;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Integer getArid() {
        return arid;
    }

    public void setArid(Integer arid) {
        this.arid = arid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString(){
        String ans = this.arid + " " + this.aname+" "+this.isEnabled+" "+this.role;
        return ans;
    }
}
