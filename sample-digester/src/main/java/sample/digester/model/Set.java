package sample.digester.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Set.java
 * Description:a parameter might contain a lot of set
 * Created by John.Huwenxuan on 2016/4/13.
 */
public class Set implements Serializable {
    private HashMap<String, String> sets;

    public Set() {
        sets = new HashMap<>();
    }

    public HashMap<String, String> getSets() {
        return sets;
    }

    public void setSets(HashMap<String, String> sets) {
        this.sets = sets;
    }

    public void addSets(String key, String value){
        sets.put(key, value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Set{");
        sb.append("sets=").append(sets);
        sb.append('}');
        return sb.toString();
    }
}
