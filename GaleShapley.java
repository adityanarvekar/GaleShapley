/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galeshapley;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author aditya
 */
public class GaleShapley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        createPreferenceList(10);
    }

    private static void createPreferenceList(int number) throws IOException {
        long startTime = System.nanoTime();
        Files.deleteIfExists(Paths.get("preferencelist.txt"));
        Files.deleteIfExists(Paths.get("output.txt"));
        BufferedWriter outs = new BufferedWriter(new FileWriter("preferencelist.txt"));

        ArrayList<Man> manList = new ArrayList<>();
        ArrayList<Woman> womanList = new ArrayList<>();
        List<String> listOfMen = new ArrayList<>();
        List<String> listOfWomen = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            listOfMen.add("M" + i);
            listOfWomen.add("W" + i);
        }

        String menpref = "";
        String womenpref = "";
        String s1 = "";
        String s2 = "";
        for (int i = 1; i <= number; i++) {
            Collections.shuffle(listOfMen);
            Collections.shuffle(listOfWomen);
            s1 = String.join(",", listOfWomen);
            s2 = String.join(",", listOfMen);
            String menpref2 = "M" + i + ": " + s1 + "\n";
            String womenpref2 = "W" + i + ": " + s2 + "\n";

            manList.add(new Man("M" + i, s1));
            womanList.add(new Woman("W" + i, s2));

            menpref = menpref + menpref2;
            womenpref = womenpref + womenpref2;

        }

        outs.write(number + "\n\n" + menpref + "\n" + womenpref);
        outs.close();

        findStablePairs(manList, womanList, startTime);
    }

    private static void findStablePairs(ArrayList<Man> manList, ArrayList<Woman> womanList, long startTime) throws IOException {

        while (smmiuahptew(manList)) {

            for (int i = 0; i < manList.size(); i++) {
                Man man = manList.get(i);
                String[] manPrefArray = man.getPrefList().split(",");
                if (!man.getIsMatched() && !man.getHasProposedEveryWoman()) {

                    for (int j = 0; j < manPrefArray.length; j++) {

                        for (int r = 0; r < womanList.size(); r++) {
                            Woman woman = womanList.get(r);

                            if (woman.getName().equals(manPrefArray[j]) && !woman.getIsMatched()) {
                                manList.get(i).setHisWoman(woman);
                                womanList.get(r).setHerMan(man);
                                manList.get(i).setIsMatched(true);
                                womanList.get(r).setIsMatched(true);
                                j = manPrefArray.length;
                                r = womanList.size();
                            } else if (woman.getName().equals(manPrefArray[j]) && woman.getIsMatched()) {

                                String[] womanPrefArray = woman.getPrefList().split(",");
                                int y = 0;
                                int u = 0;
                                for (int w = 0; w < womanPrefArray.length; w++) {
                                    if (woman.getHerMan().getName().equals(womanPrefArray[w])) {
                                        y = w;
                                    }
                                    if (man.getName().equals(womanPrefArray[w])) {
                                        u = w;
                                    }
                                }

                                if (u < y) {

                                    for (int h = 0; h < manList.size(); h++) {
                                        if (manList.get(h).getName().equals(woman.getHerMan().getName())) {
                                            manList.get(h).setHisWoman(null);
                                            manList.get(h).setIsMatched(false);
                                            manList.get(h).setHasProposedEveryWoman(false);
                                        }
                                    }

                                    manList.get(i).setHisWoman(woman);
                                    manList.get(i).setIsMatched(true);
                                    womanList.get(r).setIsMatched(true);
                                    womanList.get(r).setHerMan(man);
                                    j = manPrefArray.length;
                                    r = womanList.size();
                                }

                            }

                            if (woman.getName().equals(manPrefArray[manPrefArray.length - 1])) {
                                manList.get(i).setHasProposedEveryWoman(true);
                            }
                        }
                    }
                }
            }
        }

        BufferedWriter outs = new BufferedWriter(new FileWriter("output.txt"));
        for (int fin = 0; fin < manList.size(); fin++) {
            outs.write(manList.get(fin).himAndHisBetterHalf() + "\n");
        }
        outs.close();
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns"); 
    }

    private static boolean smmiuahptew(ArrayList<Man> manList) {

        for (int i = 0; i < manList.size(); i++) {
            Man man = manList.get(i);
            if (!man.getIsMatched() && !man.getHasProposedEveryWoman()) {
                return true;
            }
        }
        return false;
    }
}
