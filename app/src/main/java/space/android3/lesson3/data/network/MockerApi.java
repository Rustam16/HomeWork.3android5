package space.android3.lesson3.data.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import space.android3.lesson3.data.model.FilmModel;

public interface MockerApi {

    @GET("posts/")
    Call<List<FilmModel>> getFilms();

    @POST("posts/")
    Call<FilmModel> addFilm(@Body FilmModel model);


    @DELETE("posts/{postId}")
    Call<FilmModel> deleteFilm(@Path("postId") int id);
}