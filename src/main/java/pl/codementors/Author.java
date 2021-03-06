package pl.codementors;

import java.io.Serializable;

/**
 * Created by sit0 on 09.06.17.
 */
public class Author implements Serializable {
    private String name;
    private String surName;
    private String stageName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String print(){

        return name + " " + surName + " " + stageName;
    }
}

