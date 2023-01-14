import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUtil implements JsonSerializer<University>, JsonDeserializer<University>  {
    public JsonElement serialize(University src, Type type,
                                 JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("id", src.id);
        object.addProperty("fullName", src.fullName);
        object.addProperty("year", src.yearOfFoundation);
        System.out.println(object);
        return object;
    }
    static void jsonAllUniversities(ArrayList<University> universities) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities);
        System.out.println(json);
    }

//    @Override
//    public JsonElement serialize(University university, Type type, JsonSerializationContext jsonSerializationContext) {
//        return null;
//    }

    @Override
    public University deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
