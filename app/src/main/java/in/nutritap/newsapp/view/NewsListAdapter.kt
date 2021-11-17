package`in`.nutritap.newsapp.view

import `in`.nutritap.newsapp.R
import `in`.nutritap.newsapp.model.Article
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NewsListAdapter(var activity:Activity, var newsList:ArrayList<Article>):
    RecyclerView.Adapter<NewsAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_list,parent,false)
       return NewsAdapter(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter, position: Int) {
        var newsLists =newsList[position]
        holder.newHeadline.text = newsLists?.title
        holder.newsAuthor.text  = newsLists?.author
        holder.newsDescription.text = newsLists?.description
        var newsImage = newsLists.urlToImage

        if(newsImage.isNullOrEmpty()) {
            holder.imageNews.setImageResource(R.drawable.ic_launcher_foreground)
        }else {
            Picasso.with(activity).load(newsImage).placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageNews)
        }
    }

    override fun getItemCount(): Int {
       return newsList.size
    }
}
class NewsAdapter(itemView: View):RecyclerView.ViewHolder(itemView) {

    var imageNews = itemView.findViewById<ImageView>(R.id.image_headline)
    var newHeadline = itemView.findViewById<TextView>(R.id.text_news_headline)
    var newsAuthor = itemView.findViewById<TextView>(R.id.text_author)
    var newsDescription = itemView.findViewById<TextView>(R.id.text_news_description)
}