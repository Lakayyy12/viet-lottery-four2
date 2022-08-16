package com.application.vietlotteryfour

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.card_layout.view.*

class MyAdapter2(private val newsList : ArrayList<Details>) : RecyclerView.Adapter<MyAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = newsList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading
        holder.briefNews.text = currentItem.briefNews

        val isVisible : Boolean = currentItem.visbility
        holder.constraintLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.tvHeading.setOnClickListener{

            currentItem.visbility = !currentItem.visbility
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
        val briefNews: TextView = itemView.findViewById(R.id.briefNews)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.expendedlayout)
    }
}
class MyAdapter(private val context: Context, private val myModelArrayList: ArrayList<MyModel>): PagerAdapter(){
    override fun getCount(): Int {
        return  myModelArrayList.size //return list of records/items
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //inflate layout card_layout.xml
        val  view = LayoutInflater.from(context).inflate(R.layout.card_layout, container, false)

        //getdata
        val model = myModelArrayList[position]
        val title = model.title
        val description = context.resources.getString(model.description)
        val image = model.image

        //set data to ui views
        view.bannerIv.setImageResource(image)
        view.tanjiro.text = title
        view.description.text = description


        //handle item/card click
        view.setOnClickListener{
            Navigator.showContent(context, "$title \n $description")
        }
        //add view to container
        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}

