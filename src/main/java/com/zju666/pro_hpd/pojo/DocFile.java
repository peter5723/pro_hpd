package com.zju666.pro_hpd.pojo;

public class DocFile {
    private Integer id;
    private String docname;
    private String username;
    private String pass;
    private String attribute;
    private Long size;

    public DocFile(Integer id, String docname, String username, String pass, String attribute, Long size) {
        this.id = id;
        this.docname = docname;
        this.username = username;
        this.pass = pass;
        this.attribute = attribute;
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

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DocFile [id=" + id + ", docname=" + docname + ", username=" + username + ", pass=" + pass
                + ", attribute="
                + attribute + ", size=" + size + "]";
    }

}
