package com.example.event;

public class GetterSetter {
    String gid,gname,gsize;

    public GetterSetter(String gid, String gname, String gsize) {
        this.gid = gid;
        this.gname = gname;
        this.gsize = gsize;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGsize() {
        return gsize;
    }

    public void setGsize(String gsize) {
        this.gsize = gsize;
    }
}
