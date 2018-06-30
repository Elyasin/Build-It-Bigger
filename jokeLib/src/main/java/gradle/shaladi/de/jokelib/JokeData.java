package gradle.shaladi.de.jokelib;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JokeData {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("value")
    @Expose
    private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

}