package com.example.jerem.avtools;

import java.util.HashMap;

/**
 * Created by jerem on 10/10/2016.
 */

public class Plane extends HashMap<String, String> {

    int _id;
    String pname;
    String ptype;
    String pclass;
    String pstyle;
    String pnotes;
    String pjetlo;

    //Empty Constructor
    public Plane(){

    }


    //Constructor
    public Plane(String pname, String ptype, String pclass, String pstyle, String pnotes, String pjetlo){
        this.pname = pname;
        this.ptype = ptype;
        this.pclass = pclass;
        this.pstyle = pstyle;
        this.pnotes = pnotes;
        this.pjetlo = pjetlo;
    }

    //Getting id
    public int get_id(){
        return this._id;
    }
    //Setting id
    public void setID(int _id){
        this._id = _id;
    }

    //Getting Name
    public String getPname(){
        return this.pname;
    }
    //Setting Name
    public void setPname(String pname){
        this.pname = pname;
    }

    //Getting Type
    public String getPtype(){
        return this.ptype;
    }
    //Setting Type
    public void setPtype(String ptype){
        this.ptype = ptype;
    }

    //Getting
    public String getPclass() { return this.pclass; }
    //Setting
    public void setPclass(String pclass) {this.pclass = pclass;}

    //Getting
    public String getPstyle() { return this.pclass; }
    //Setting
    public void setPstyle(String pstyle) { this.pstyle = pstyle;}

    //Getting
    public String getPnotes() { return this.pnotes; }
    //Setting
    public void setPnotes(String pnotes) { this.pnotes = pnotes;}

    //Getting
    public String getPjetlo() { return this.pjetlo;}
    //Setting
    public void setPjetlo(String pjetlo){ this.pjetlo = pjetlo;}



}
