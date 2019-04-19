package com.example.harol.lanchonetedeliciatarefas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<String> produtoList = new ArrayList<String>();
        produtoList.add("Suco Onda Tropical");
        produtoList.add("Vitamina Planetaria");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://....herokuapp.com/main/api",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                        Gson gson = new GsonBuilder().create();
                        Produtos[] produtos = gson.fromJson(responseString, Produtos[].class);
                        LinkedBlockingDeque adapter;
                        adapter.clear();
                        for (Produtos produto : produtos) {
                            adapter.add(produto.getNome());
                        }
                    }
                }
                );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> adapterView, View view, int i, long l) {
                Intent detalheIntent = new Intent(MainActivity.this,DetalheActivity.class);
                detalheIntent.putExtra("produto_nome",produtoList.get(i));
            detalheActivity.putExtra("produto_nome", produtos[i].getNome());

                        detalheActivity.putExtra(“produto_preco", produtos[i].getPreco());
                                detalheActivity.putExtra(“produto_desc", produtos[i].getDescricao());
                                        detalheActivity.putExtra(“produto_url", produtos[i].getImagem());
                startActivity(detalheIntent);

            }

        });

    }
}
