package com.zju666.pro_hpd.pojo;

public class DocUser {
    private Integer id;             
    private String username;        
    private String password;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "DocUser [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
    public DocUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }    
}
