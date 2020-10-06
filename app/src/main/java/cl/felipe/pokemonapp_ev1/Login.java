package cl.felipe.pokemonapp_ev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
    }

    public void confirm(View view) {
        if (edit1.getText().toString().isEmpty() || edit2.getText().toString().isEmpty()){
            Toast.makeText( this,"Llene los campos vacios",Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

    public void signUp(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void creation(View view) {
        Intent intent = new Intent(this, Creators.class);
        startActivity(intent);
    }
}