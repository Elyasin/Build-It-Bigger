package gradle.shaladi.de.jokelib;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeService {

    //http://api.icndb.com/jokes/random
    @GET("jokes/random")
    Call<JokeData> getJoke();

}
