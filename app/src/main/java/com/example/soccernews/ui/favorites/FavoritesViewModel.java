package com.example.soccernews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.soccernews.data.SoccerNewsRepository;
import com.example.soccernews.domain.News;

import java.util.List;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {
    }

    public LiveData<List<News>> loadFavoriteNews() {
        final LiveData<List<News>> news;
        news = SoccerNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
        return news;
    }

    public void saveFavorites(News news) {
        AsyncTask.execute(() -> SoccerNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }
}