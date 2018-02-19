package app.demo.iot.com.kotlinwithretrofit

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.demo.iot.com.kotlinwithretrofit.databinding.RowBinding

/**
 * Created by muhammed on 2/19/2018.
 */
class MyAdapter(val items: List<User>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = MyHolder(RowBinding.inflate(LayoutInflater.from(parent?.context)))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder?.binThis(items[position].title)
    }

    class MyHolder(itemView: RowBinding?) : RecyclerView.ViewHolder(itemView?.root) {
        private var rowBinding: RowBinding? = itemView

        fun binThis(name: String) {
            rowBinding?.textName = name
            rowBinding?.executePendingBindings()
        }
    }
}