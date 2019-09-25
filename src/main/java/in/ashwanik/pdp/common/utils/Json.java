package in.ashwanik.pdp.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for Json objects
 */
public class Json {
    private static Gson gson = new GsonBuilder().create();
    private static JsonParser jsonParser = new JsonParser();

    private Json() {
    }

    /**
     * Serialize string.
     *
     * @param <T> Type of the object passed
     * @param obj Object to serialize
     * @return Serialized string
     */
    public static <T> String serialize(T obj) {
        return gson.toJson(obj);

    }

    /**
     * De-serialize a string
     *
     * @param <T>        Type of the object
     * @param jsonString Serialized string
     * @param tClass     Class of the type
     * @return De-serialized object
     */
    public static <T> T deserialize(String jsonString,
                                    Class<T> tClass) {
        if (!isValid(jsonString)) {
            return null;
        }
        return gson.fromJson(jsonString, tClass);
    }

    /**
     * De-serialize to list
     *
     * @param <T>  Type of the object
     * @param data Serialized string
     * @param type Type of the object
     * @return List of converted object
     */
    public static <T> List<T> deserializeList(String data,
                                              Type type) {
        if (!isValid(data)) {
            return Collections.emptyList();
        }
        return gson.fromJson(data, type);
    }

    /**
     * Check if a string is valid json.
     *
     * @param json Json String
     * @return Flag indicating if string is json
     */
    public static boolean isValid(String json) {
        try {
            jsonParser.parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }
}
