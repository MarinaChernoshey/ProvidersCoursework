package com.example.marina.providers.DataBase;

import android.app.Activity;

import com.example.marina.providers.App;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class DataHelper {
    private Activity activity;
    DaoSession daoSession;
    private ProviderDao providerDao;
    private Query<Provider> providerQuery;
    List<Provider> providers;


    public DataHelper(Activity activity) {
        this.activity = activity;
        daoSession = ((App) this.activity.getApplication()).getDaoSession();
    }

    public void update() {
        if (providers != null)
            providers = providerQuery.list();
    }

    ///---------------------------------------------------------------------------------------------set&get

    ///---------------------------------------------------------------------------------------------providers
    public void setProviders() {
        providers = providerQuery.list();
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public Provider getProviderId(int position) {
        List<Provider> providers = providerDao.queryBuilder().
                where(ProviderDao.Properties.Id.eq(position)).limit(1).list();
        return providers.get(0);
    }

    public void setProviderDao() {
        providerDao = daoSession.getProviderDao();
    }

    public ProviderDao getProviderDao() {
        return providerDao;
    }

    public void setProviderQuery() {
        providerQuery = providerDao.queryBuilder().orderAsc(ProviderDao.Properties.Name).build();
    }

    public Query<Provider> getProviderQuery() {
        return providerQuery;
    }

}
