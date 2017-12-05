package com.villegas.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAV();

        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,planetas));

        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescarContenido();
            }
        });
    }

    public void refrescarContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);

    }

    public void agregarFAV(){
        FloatingActionButton myFav = (FloatingActionButton) findViewById(R.id.favMiFAV);
        myFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(),getResources().getString(R.string.message),Toast.LENGTH_SHORT).show();
                Snackbar.make(view,getResources().getString(R.string.message),Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "Ha hecho click en SnackBar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });


    }
}
