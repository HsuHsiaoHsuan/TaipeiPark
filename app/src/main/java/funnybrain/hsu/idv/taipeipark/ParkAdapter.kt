package funnybrain.hsu.idv.taipeipark

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import funnybrain.hsu.idv.taipeipark.restful.model.Park
import kotlinx.android.synthetic.main.item_park.view.*

class ParkAdapter(private val mContext: Context, private val list: List<Park>) : RecyclerView.Adapter<ParkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_park, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = " ${list[position].parkName} \n ${list[position].picName}"
        Glide.with(mContext).load(list[position].image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.iv_img
        val title: TextView = view.tv_title
    }
}
