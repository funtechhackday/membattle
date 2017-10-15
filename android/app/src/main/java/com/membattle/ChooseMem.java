package com.membattle;

/**
 * Created by Севастьян on 15.10.2017.
 */

public class ChooseMem {

    String type;
    int id;

    ChooseMem(String Type, int ID){
        type=Type;
        id=ID;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
