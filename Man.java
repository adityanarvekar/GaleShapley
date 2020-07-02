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
public class Man {

    private String name;
    private String prefList;
    private boolean isMatched = false;
    private boolean hasProposedEveryWoman = false;
    private Woman hisWoman;

    public Man(String name, String prefList) {
        this.name = name;
        this.prefList = prefList;
        this.isMatched = false;
    }
    
    public void setHasProposedEveryWoman(boolean val) {
        this.hasProposedEveryWoman = val;
    }

    public boolean getHasProposedEveryWoman() {
        return this.hasProposedEveryWoman;
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

    public void setHisWoman(Woman w1) {
        this.hisWoman = w1;
    }
    
    public Woman getHisWoman() {
        return this.hisWoman;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.prefList + "\n";
    }

    public String himAndHisBetterHalf() {
        if(this.hisWoman!=null){
            return this.name + " and " + this.hisWoman.getName();
        }
        else{
            return this.name + " and No one";
        }
        
    }
}
