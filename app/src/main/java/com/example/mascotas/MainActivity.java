package com.example.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.menus.AcercaDe;
import com.example.mascotas.menus.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascota;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarLista();
        inicializarAdaptador();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID =item.getItemId();
        if(itemID == R.id.mContacto) {
            Intent intent = new Intent(this, Contacto.class);
            startActivity(intent);
        }
        else if (itemID == R.id.mAcerca) {
            Intent intent = new Intent(this, AcercaDe.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarLista() {
        mascota = new ArrayList<>();
        mascota.add(new Mascota("Trosky", R.drawable.dog_1, 5, false));
        mascota.add(new Mascota("Loki", R.drawable.dog_2, 5, false));
        mascota.add(new Mascota("Dante", R.drawable.dog_3, 5, false));
        mascota.add(new Mascota("Fofi", R.drawable.dog_4, 5, false));
        mascota.add(new Mascota("Danger", R.drawable.dog_5, 5, false));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void favoritos(View view) {
        Intent intent = new Intent(this, Favoritos.class);
        startActivity(intent);
    }
}