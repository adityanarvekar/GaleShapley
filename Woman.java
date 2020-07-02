/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galeshapley;

import java.util.List;

/**
 *
 * @author aditya
 */
public class Woman {

    private String name;
    private String prefList;
    private boolean isMatched = false;
    private Man herMan;

    public Woman(String name, String prefList) {
        this.name = name;
        this.prefList = prefList;
        this.isMatched = false;
    }

    public void setIsMatched(boolean val) {
        this.isMatched = val;
    }

    public boolean getIsMatched() {
        return this.isMatched;
    }

    public String getPrefList() {
        return this.prefList;
    }

    public String getName() {
        return this.name;
    }

    public void setHerMan(Man m1) {
        this.herMan = m1;
    }

    public Man getHerMan() {
        return this.herMan;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.prefList + "\n";
    }
}
