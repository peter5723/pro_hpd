package com.zju666.pro_hpd.pojo;

public class DocFile {
    private Integer id;
    private String docname;
    private String url;
    private String username;
    private String pass;
    private int size;
    public DocFile(Integer id, String docname, String url, String username, String pass, int size) {
        this.id = id;
        this.docname = docname;
        this.url = url;
        this.username = username;
        this.pass = pass;
        this.size = size;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDocname() {
        return docname;
    }
    public void setDocname(String docname) {
        this.docname = docname;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "DocFile [id=" + id + ", docname=" + docname + ", url=" + url + ", username=" + username + ", pass="
                + pass + ", size=" + size + "]";
    }
    
    

    
    

}
