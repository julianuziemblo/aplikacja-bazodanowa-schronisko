package bdbt_project.SpringApplication.utility;

import org.json.simple.JSONObject;

import java.util.HashMap;

public class JSONUtility {

    public static HashMap<String, String> toMap(JSONObject j) {
        var map = new HashMap<String, String>();
        for(var key : j.keySet()) {
            map.put((String)key, (String)j.get(key));
        }
        return map;
    }

}
