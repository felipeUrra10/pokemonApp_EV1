package cl.felipe.pokemonapp_ev1.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.felipe.pokemonapp_ev1.R;
import cl.felipe.pokemonapp_ev1.modelo.Pokemon;

public class AdapterPokemon extends RecyclerView.Adapter<AdapterPokemon.PokemonHolder>{

    public Activity activity;
    public List<Pokemon> list;
    public int item_pokemon;

    public AdapterPokemon(Activity activity, List<Pokemon> list, int item_pokemon) {
        this.activity = activity;
        this.list = list;
        this.item_pokemon = item_pokemon;
    }

    @NonNull
    @Override
    public PokemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_pokemon,parent,false);
        return new PokemonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonHolder holder, int position) {
        Pokemon pokemon = list.get(position);
        holder.item_id.setText(pokemon.id);
        holder.item_name.setText(pokemon.name);
        holder.item_supertype.setText(pokemon.supertype);
        holder.item_set.setText(pokemon.set);
        Glide.with(activity).load(pokemon.imageUrl).into(holder.item_image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  PokemonHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_id, item_name, item_supertype, item_set;

        public PokemonHolder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            item_id = itemView.findViewById(R.id.item_id);
            item_name = itemView.findViewById(R.id.item_name);
            item_supertype = itemView.findViewById(R.id.item_supertype);
            item_set = itemView.findViewById(R.id.item_set);
        }
    }

}
