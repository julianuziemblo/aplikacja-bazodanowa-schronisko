package bdbt_project.SpringApplication.utility;

import bdbt_project.SpringApplication.dto.KlientPassword;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;

public class JSONUtility {

    private static final JSONParser parser = new JSONParser();

    public static HashMap<String, String> toMap(JSONObject j) {
        var map = new HashMap<String, String>();
        for(var key : j.keySet()) {
            map.put((String)key, (String)j.get(key));
        }
        return map;
    }

    public static HashMap<String, String> read(String path) throws IOException, ParseException {
        if(FileUtility.isBlank(path)) {
            JSONUtility.writeEmptyMap(path);
        }
        var parser = new JSONParser();
        var auth = (JSONObject)parser.parse(new FileReader(path));
        return JSONUtility.toMap(auth);
    }

    public static void write(KlientPassword kh, String path) throws IOException, ParseException {
        if(FileUtility.isBlank(path)) {
            JSONUtility.writeEmptyMap(path);
        }
        var auth = (JSONObject)parser.parse(new FileReader(path));
        var map = JSONUtility.toMap(auth);
        map.put(kh.getEmail(), kh.getPassword());
        var row = new JSONObject(map);
        var writer = new BufferedWriter(new FileWriter(path));
        writer.write(row.toString());
        writer.flush();
        writer.close();
    }

    public static void writeEmptyMap(String path) throws IOException {
        var bw = new BufferedWriter(new FileWriter(path));
        bw.write("{}");
        bw.close();
    }

}
