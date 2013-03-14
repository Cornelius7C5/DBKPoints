package pl.spot.dbk.points;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import org.hsqldb.lib.Collection;

public class MetaObject implements Serializable {
    private static final long serialVersionUID = -1158931697209657065L;

    private String id;
    private String name;

    private HashMap<String, String> extra = new HashMap<String, String>();

    public void setId(Object id_u) {
        this.id = id_u.toString();
    }

    public String getId() {
        return id;
    }

    public void setName(Object name) {
        this.name = name.toString();
    }

    public String getName() {
        return name;
    }

    public void addInfo(String key, String extra) throws Exception {
        if (!this.extra.keySet().contains(key)) {
            this.extra.put(key, extra);
        } else {
            throw new Exception("Key already exists");
        }
    }

    public ArrayList<String> getKeyList() {
        ArrayList<String> ret = new ArrayList<String>();
//        ret.add("Id");
//        ret.add("Nazwa");
        ret.addAll(this.extra.keySet());
        
        return ret;
    }

    public HashMap<String, String> getExtra() {
        return extra;
    }

    public String getExtraItem(String key) {
        return this.extra.get(key);
    }

}
