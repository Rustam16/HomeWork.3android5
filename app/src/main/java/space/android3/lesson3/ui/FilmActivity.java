package space.android3.lesson3.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import space.android3.lesson3.App;
import space.android3.lesson3.R;
import space.android3.lesson3.data.interfaces.FilmCallback;
import space.android3.lesson3.data.model.FilmModel;

public class FilmActivity extends AppCompatActivity {

    EditText title, users, content, group;
    Button add;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film2);

        title = findViewById(R.id.title_e);
        users = findViewById(R.id.users);
        content = findViewById(R.id.content_e);
        group = findViewById(R.id.group_e);
        add = findViewById(R.id.add_et);


        add.setOnClickListener(v -> {
            FilmModel f = new FilmModel(title.getText().toString(),
                    content.getText().toString(),
                    Integer.parseInt(users.getText().toString()),
                    Integer.parseInt(group.getText().toString()));

            App.service.addFilm(f, new FilmCallback() {
                @Override
                public void onSuccess(List<FilmModel> films) {
                    Intent intent = new Intent(FilmActivity.this,MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Throwable e) {

                }
            });
        });
    }
}