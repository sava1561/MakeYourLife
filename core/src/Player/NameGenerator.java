package Player;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sava on 24.03.2016.
 */
public class NameGenerator {
    public Random rand;
    public ArrayList<String> man_names;

    public NameGenerator(){
        rand=new Random();
        man_names=new ArrayList<String>();
        man_names.add("Mike");
        man_names.add("Roman");
        man_names.add("Alex");
        man_names.add("John");
        man_names.add("Andrew");
        man_names.add("Jake");
        man_names.add("Michel");
        man_names.add("Carl");
        man_names.add("Rassel");
        man_names.add("Bred");
        man_names.add("Dalton");
        man_names.add("Mike");
        man_names.add("Derek");
        man_names.add("Ross");
        man_names.add("Chris");
    }
    public String generateManName(){
        return man_names.get(rand.nextInt(man_names.size()));
    }
}
