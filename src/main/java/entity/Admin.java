package entity;

public class Admin {

    private Long aid;
    private String aname;
    private String password;
    private Integer Authority;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuthority() {
        return Authority;
    }

    public void setAuthority(Integer authority) {
        Authority = authority;
    }
}
