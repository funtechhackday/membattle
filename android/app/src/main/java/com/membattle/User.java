package com.membattle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Севастьян on 25.09.2017.
 */
//{
//        "ticket_pk": 50,
//        "result": true,
//        "hash": "ac6fc560c212b77d43ead7216bf230a3",
//        "email": "themezv@gmail.com"
//        }
public class User {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("coins")
    @Expose
    private Integer coins;
    @SerializedName("username")
    @Expose
    private String username;
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
