package `in`.nutritap.newsapp.view

import `in`.nutritap.newsapp.R
import `in`.nutritap.newsapp.model.Article
import `in`.nutritap.newsapp.viewmodel.NewsListViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class NewsActivity : AppCompatActivity() {

    private lateinit var newsListViewModel: NewsListViewModel
    private lateinit var newsListAdapter: NewsListAdapter
    private lateinit var recyclerView:RecyclerView
    private lateinit var article:ArrayList<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        recyclerView = findViewById(R.id.rv_news_list)

        newsListViewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)

        newsListViewModel.getNewsList().observe(this, Observer {

            recyclerView.adapter = NewsListAdapter(this, article)


        })

    }
}