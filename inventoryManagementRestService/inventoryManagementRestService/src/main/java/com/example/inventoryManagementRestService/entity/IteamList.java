package com.example.inventoryManagementRestService.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entityList")
public class IteamList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IteamId;
    private String name;
    private Integer NumberOfIteam;
    private Integer amount;
    private Date LastRefile;

    public IteamList() {
    }

    public IteamList(Integer iteamId, String name, Integer numberOfIteam, Integer amount, Date lastRefile) {
        IteamId = iteamId;
        this.name = name;
        NumberOfIteam = numberOfIteam;
        this.amount = amount;
        LastRefile = lastRefile;
    }

    public Integer getIteamId() {
        return IteamId;
    }

    public void setIteamId(Integer iteamId) {
        IteamId = iteamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfIteam() {
        return NumberOfIteam;
    }

    public void setNumberOfIteam(Integer numberOfIteam) {
        NumberOfIteam = numberOfIteam;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getLastRefile() {
        return LastRefile;
    }

    public void setLastRefile(Date lastRefile) {
        LastRefile = lastRefile;
    }

    @Override
    public String toString() {
        return "IteamList{" +
                "IteamId=" + IteamId +
                ", name='" + name + '\'' +
                ", NumberOfIteam=" + NumberOfIteam +
                ", amount=" + amount +
                ", LastRefile=" + LastRefile +
                '}';
    }
}
