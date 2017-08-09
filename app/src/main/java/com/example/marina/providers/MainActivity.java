package com.example.marina.providers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.marina.providers.DataBase.DataHelper;
import com.example.marina.providers.DataBase.Provider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DataHelper dataHelper;
    private ProvidersAdapter providersAdapter;

    List<Provider> providersParetoOptional;

    TextView textViewHatName;
    TextView textViewHatQuality;
    TextView textViewHatDelivery;
    TextView textViewHatDistance;
    TextView textViewHatPrice;
    TextView textViewHatTerm;
    TextView textViewHatAssortment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolBar();
        setFloatingActionBar();
        setRecyclerView();
        setDataHelper();
        setViews();
    }

    private void setViews() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        dataHelper.update();
        if (dataHelper.getProviders() != null) {
            providersAdapter.setDataHelper(dataHelper);
            providersAdapter.setProviders();
            providersAdapter.setEvaluations();
        }
    }

    private void setDataHelper() {
        dataHelper = new DataHelper(this);
        dataHelper.setProviderDao();
    }

    protected void setRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_providers_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        providersAdapter = new ProvidersAdapter(providerClickListener);
        recyclerView.setAdapter(providersAdapter);
    }

    ProvidersAdapter.ProviderClickListener providerClickListener = new ProvidersAdapter.ProviderClickListener() {
        @Override
        public void onProviderClick(int position) {
            Provider provider = providersAdapter.getProvider(position);
            Long providerId = provider.getId();
            Log.d("DaoExample", " ID: " + providerId);

            Intent intent = new Intent(MainActivity.this, AddProviderActivity.class);
            intent.putExtra("intentProviderIdClick", String.valueOf(providerId));
            startActivity(intent);

        }
    };

    private void setFloatingActionBar() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddProviderActivity.class);
                intent.putExtra("intentProviderIdClick", "-1");
                startActivity(intent);
            }
        });
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pareto) {
            providersParetoOptional = new ArrayList<>();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void deleteNotParetoOptional(List<Provider> thisProviders) {
        int leftP = 0, rightP = 0;

        for (Provider provider1 : thisProviders) {
            for (int i = 1; i < thisProviders.size(); i++) {
                Provider provider2 = thisProviders.get(i);
            }
        }
    }

    private float setQuality(String quality) {
        if (quality == getString(R.string.ball_quality_5)) {
            return 0.9f;
        }
        if (quality == getString(R.string.ball_quality_4)) {
            return 0.7f;
        }
        if (quality == getString(R.string.ball_quality_3)) {
            return 0.5f;
        }
        if (quality == getString(R.string.ball_quality_2)) {
            return 0.3f;
        }
        if (quality == getString(R.string.ball_quality_1)) {
            return 0.1f;
        }
        return 0;
    }

    private float setDelivery(String delivery) {
        if (delivery == getString(R.string.ball_delivery_2)) {
            return 0.6f;
        }
        if (delivery == getString(R.string.ball_delivery_1)) {
            return 0.3f;
        }
        return 0;
    }
}
