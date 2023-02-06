package allJSON;

import model.University;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteJSONFile {
    public static void writeJSONFile(ArrayList<University> universities, String path) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(JsonUtil.jsonAllUniversities(universities));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
