package app.demo.example.com.trailtracker.routes.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.demo.example.com.trailtracker.R
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.utils.toCustomDateFormatString
import app.demo.example.com.trailtracker.utils.toCustomStringFormat
import kotlinx.android.synthetic.main.route_item_layout.view.*
import kotlin.properties.Delegates

typealias Listener = (Route) -> Unit

class RoutesAdapter(data: List<Route> = emptyList(), private val listener: Listener) :
        RecyclerView.Adapter<RoutesAdapter.MyRoutesViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRoutesViewHolder =
            MyRoutesViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.route_item_layout, parent, false), listener)

    override fun onBindViewHolder(holder: MyRoutesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class MyRoutesViewHolder(view: View, private val listener: Listener) :
            RecyclerView.ViewHolder(view) {

        fun bind(item: Route) = with(itemView) {
            tv_route_name.text = item.name
            tv_route_start_date.text = item.startDate.toCustomDateFormatString()
            tv_route_count_locations.text = item.locations.size.toString()
            tv_route_duration.text = context.getString(R.string.route_duration,item.duration?.toCustomStringFormat())
            setOnClickListener { listener(item) }
        }
    }
}