package space.android3.lesson3.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import space.android3.lesson3.App;
import space.android3.lesson3.R;
import space.android3.lesson3.data.interfaces.FilmCallback;
import space.android3.lesson3.data.model.FilmModel;
import space.android3.lesson3.ui.Adapter.FilmAdapter;

public class MainActivity extends AppCompatActivity {

    FilmAdapter adapter;
    RecyclerView recyclerView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new FilmAdapter();
        recyclerView = findViewById(R.id.films_recycler);
        addBtn = findViewById(R.id.add);

        recyclerView.setAdapter(adapter);

       App.service.getFilms(new FilmCallback() {
           @Override
           public void onSuccess(List<FilmModel> films) {
               adapter.setFilms(films);
           }

           @Override
           public void onFailure(Throwable e) {
               Log.d("filmError", e.getMessage());
           }
       });
       addBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in = new Intent(MainActivity.this, FilmActivity.class);
               startActivity(in);
           }
       });
    }

}

