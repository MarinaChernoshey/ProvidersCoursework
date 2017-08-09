package com.example.marina.providers;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marina.providers.DataBase.DataHelper;
import com.example.marina.providers.DataBase.Provider;

import java.util.ArrayList;
import java.util.List;

public class ProvidersAdapter extends RecyclerView.Adapter<ProvidersAdapter.ProviderViewHolder> {

    private static final int COUNT_ITEM_CRITERIA = 6;
    private ProviderClickListener clickListener;
    private DataHelper dataHelper;
    private List<Provider> providers;


    public interface ProviderClickListener {
        void onProviderClick(int position);
    }

    static class ProviderViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView quality;
        public TextView delivery;
        public TextView distance;
        public TextView price;
        public TextView term;
        public TextView assortment;

        public ProviderViewHolder(View itemView, final ProviderClickListener clickListener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_view_item_recycler_view_name_provider);
            quality = (TextView) itemView.findViewById(R.id.text_view_item_recycler_view_quality);
            delivery = (TextView) itemView.findViewById(R.id.text_view_item_recycler_view_delivery);
            distance = (TextView) itemView.findViewById(R.id.text_view_item_recycler_view_name_distance);
            price = (TextView) itemView.findViewById(R.id.text_view_item_recycler_view_name_price);
            term = (TextView) itemView.findViewById(R.id.text_view_item_recycler_view_name_term);
            assortment = (TextView) itemView.findViewById(R.id.text_view_item_recycler_view_name_assortment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        clickListener.onProviderClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public ProvidersAdapter(ProviderClickListener clickListener) {
        this.clickListener = clickListener;
        this.providers = new ArrayList<Provider>();
    }

    public void setDataHelper(DataHelper dataHelper) {
        this.dataHelper = dataHelper;
    }

    public void setProviders() {
        providers = dataHelper.getProviders();
        notifyDataSetChanged();
    }

    public Provider getProvider(int position) {
        return providers.get(position);
    }

    public Provider getProviderId(int position) {
        Log.d("ssafaaf", position + " " + dataHelper + "");
        return dataHelper.getProviderId(position);
    }

    @Override
    public ProvidersAdapter.ProviderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_providers_list_item, parent, false);
        return new ProviderViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(ProvidersAdapter.ProviderViewHolder holder, int position) {

        if (dataHelper.getProviders() != null) {
            Provider provider = getProvider(position);
            holder.name.setText(provider.getName());
            holder.quality.setText(dataHelper.getEvaluationOnProviderAndCriteriaId(provider.getId(), Long.valueOf(1)).getEvaluation());
            holder.delivery.setText(dataHelper.getEvaluationOnProviderAndCriteriaId(provider.getId(), Long.valueOf(2)).getEvaluation());
            holder.distance.setText(dataHelper.getEvaluationOnProviderAndCriteriaId(provider.getId(), Long.valueOf(3)).getEvaluation());
            holder.price.setText(dataHelper.getEvaluationOnProviderAndCriteriaId(provider.getId(), Long.valueOf(4)).getEvaluation());
            holder.term.setText(dataHelper.getEvaluationOnProviderAndCriteriaId(provider.getId(), Long.valueOf(5)).getEvaluation());
            holder.assortment.setText(dataHelper.getEvaluationOnProviderAndCriteriaId(provider.getId(), Long.valueOf(6)).getEvaluation());
        }
    }

    @Override
    public int getItemCount() {
        return providers.size();
    }
}