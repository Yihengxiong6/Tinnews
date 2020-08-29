package com.laioffer.tinnews;

import android.app.Application;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;

public class TinNewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Gander.setGanderStorage(GanderIMDB.getInstance()); // in memory database 关掉重启不work了
        // TODO: new code here.
    }
}