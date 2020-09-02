package com.laioffer.tinnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.repository.NewsRepository;

public class HomeViewModel extends ViewModel {

    private final NewsRepository repository;
    private final MutableLiveData<String> countryInput = new MutableLiveData<>(); // final 表示没必要变

    public HomeViewModel(NewsRepository newsRepository) {
        this.repository = newsRepository;
    }  // dependency injection

    public void setCountryInput(String country) {
        countryInput.setValue(country);
    } // setQuery to get the country

    public LiveData<NewsResponse> getTopHeadlines() {
        return Transformations.switchMap(countryInput, repository::getTopHeadlines);
    } // switchmap 把countryInput的country倒到getTopHeadlines里
}