package com.example.hp.railss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.railss.api.Client;
import com.example.hp.railss.api.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    EditText pnr;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // TextView doj=(TextView)findViewById(R.id.doj);
       pnr=(EditText) findViewById(R.id.pnrno) ;
        recyclerView = findViewById(R.id.recyclerView);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.railwayapi.com")
                .addConverterFactory(GsonConverterFactory.create());
        retrofit= builder.build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
    public void checkit(View v)
    {
        Client client = retrofit.create(Client.class);
        Call<List<Model>> call = client.reposForUser(pnr.getText().toString());

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> repos = response.body();

                recyclerView.setAdapter(new DetailAdapter(repos));
            }
            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
