package space.android3.lesson3.data.network;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import space.android3.lesson3.data.interfaces.FilmCallback;
import space.android3.lesson3.data.model.FilmModel;

public class MockerService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://android-3-mocker.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    MockerApi client = retrofit.create(MockerApi.class);

    public void getFilms(FilmCallback filmCallback) {
        client.getFilms().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<FilmModel>> call, @NotNull Response<List<FilmModel>> response) {
                filmCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<List<FilmModel>> call, @NotNull Throwable t) {
                filmCallback.onFailure(t);
            }
        });
    }

    public void addFilm(FilmModel filmModel, FilmCallback f) {
        client.addFilm(filmModel).enqueue (new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                List <FilmModel> l = new ArrayList<>();
                l.add(response.body());
                f.onSuccess(l);
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                f.onFailure(t);
            }
        });

    }
}
