package`in`.nutritap.newsapp.viewmodel

import `in`.nutritap.newsapp.model.Article
import `in`.nutritap.newsapp.repository.NewsRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsListViewModel:ViewModel() {

    var newsLiveData:MutableLiveData<Article>? = null

    fun getNewsList(): LiveData<Article> {
        newsLiveData = NewsRepository.getNewsList()
        return newsLiveData as MutableLiveData<Article>
    }
}