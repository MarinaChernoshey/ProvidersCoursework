package com.example.marina.providers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.marina.providers.DataBase.DataHelper;
import com.example.marina.providers.DataBase.Provider;

public class AddProviderActivity extends AppCompatActivity {

    DataHelper dataHelper;
    TextView textViewQuality;
    TextView textViewDelivery;
    TextView textViewDistance;
    TextView textViewPrice;
    TextView textViewTerm;
    TextView textViewAssortment;

    EditText editTextName;
    Spinner editTextQuality;
    Spinner editTextDelivery;
    EditText editTextDistance;
    EditText editTextPrice;
    EditText editTextTerm;
    EditText editTextAssortment;

    Button buttonSave;
    Button buttonDelete;

    int providerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provider);

        setButtonClick();

    }

    private void setButtonClick() {

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHelper.getProviderDao().delete(dataHelper.getProviderId(providerId));
            }

            private void updateRecord() {
                Provider provider = dataHelper.getProviderId(providerId);
                provider.setName(String.valueOf(editTextName.getText()));
                dataHelper.getProviderDao().update(provider);


            }

            private void pasteRecord() {

                dataHelper.update();
            }

            private void setProviderId() {
                Intent intent = getIntent();
                providerId = Integer.valueOf(intent.getStringExtra("intentProviderIdClick"));

                if (providerId == -1) {
                    buttonDelete.setVisibility(View.GONE);
                } else {
                    setEditTextViews();
                }
            }

            private void setEditTextViews() {
                editTextName.setText(dataHelper.getProviderId(providerId).getName());
            }

            private void setDataHelper() {
                dataHelper = new DataHelper(this);
                dataHelper.setProviderDao();
                dataHelper.setProviderQuery();
            }

            private void setViews() {
                textViewQuality = (TextView) findViewById(R.id.text_view_activity_add_provider_quality);
                textViewDelivery = (TextView) findViewById(R.id.text_view_activity_add_provider_delivery);
                textViewDistance = (TextView) findViewById(R.id.text_view_activity_add_provider_distance);
                textViewPrice = (TextView) findViewById(R.id.text_view_activity_add_provider_price);
                textViewTerm = (TextView) findViewById(R.id.text_view_activity_add_provider_term);
                textViewAssortment = (TextView) findViewById(R.id.text_view_activity_add_provider_assortment);


                editTextName = (EditText) findViewById(R.id.edit_text_name_provider);
                editTextQuality = (Spinner) findViewById(R.id.spinner_quality);
                editTextDelivery = (Spinner) findViewById(R.id.spinner_delivery);
                editTextDistance = (EditText) findViewById(R.id.edit_text_distance);
                editTextPrice = (EditText) findViewById(R.id.edit_text_prices);
                editTextTerm = (EditText) findViewById(R.id.edit_text_terms);
                editTextAssortment = (EditText) findViewById(R.id.edit_text_assortment);

                buttonSave = (Button) findViewById(R.id.btn_save);
                buttonDelete = (Button) findViewById(R.id.btn_delete);

            }
        }
    }
}
