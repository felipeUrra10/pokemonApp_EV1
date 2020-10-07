package cl.felipe.pokemonapp_ev1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Details extends AppCompatActivity {

    String picture;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        picture = getIntent().getStringExtra("PICTURE");

        img = findViewById(R.id.detail_img);

        Glide.with(this).load(picture).into(img);

    }
}