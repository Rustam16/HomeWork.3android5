package space.android3.lesson3.ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import space.android3.lesson3.R;
import space.android3.lesson3.data.model.FilmModel;

public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder> {


    private List<FilmModel> filmModels = new ArrayList<>();

    public void setFilms(List<FilmModel> films) {
        filmModels = films;
        notifyDataSetChanged();
    }

    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item, parent, false);
        return new FilmViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, int position) {
        holder.onBind(filmModels.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return filmModels.size();
    }
}

class FilmViewHolder extends RecyclerView.ViewHolder {

    TextView title;

    public FilmViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
    }

    public void onBind(String title) {
        this.title.setText(title);
    }

}
