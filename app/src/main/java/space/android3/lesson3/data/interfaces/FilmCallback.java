package space.android3.lesson3.data.interfaces;

import android.widget.LinearLayout;

import java.util.List;

import space.android3.lesson3.data.model.FilmModel;

public interface FilmCallback {
    void onSuccess(List<FilmModel> films);

    void onFailure(Throwable e);

}
