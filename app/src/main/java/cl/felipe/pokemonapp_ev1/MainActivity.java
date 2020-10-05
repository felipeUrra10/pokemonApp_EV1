package cl.felipe.pokemonapp_ev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.felipe.pokemonapp_ev1.Adapter.AdapterPokemon;
import cl.felipe.pokemonapp_ev1.modelo.Pokemon;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String URL="https://api.pokemontcg.io/v1/cards";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processHttp();
    }

    public void processHttp(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                Log.d("INFO", data);
                processPokemon(data);


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void processPokemon(String data) {
        try {
            JSONObject root = new JSONObject(data);
            JSONArray cards = root.getJSONArray("cards");

            List<Pokemon> list = new ArrayList<>();

            for (int i=0; i<cards.length();i++){
                JSONObject pokemon1 = cards.getJSONObject(i);

                String id = pokemon1.getString("id");
                String name = pokemon1.getString("name");
                String imageUrl = pokemon1.getString("imageUrl");
                String supertype = pokemon1.getString("supertype");
                String set = pokemon1.getString("set");

                Pokemon pokemon = new Pokemon(id,name,imageUrl,supertype,set);
                list.add(pokemon);

            }


            RecyclerView rc = findViewById(R.id.rc_pokemon);
            AdapterPokemon ad = new AdapterPokemon(this,list,R.layout.item_pokemon);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);

            rc.setLayoutManager(lm);
            rc.setAdapter(ad);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}