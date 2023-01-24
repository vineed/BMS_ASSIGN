package com.bookmyshow.feature_one.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.adapter.VenueAdapter.VenueViewHolder
import com.bookmyshow.feature_one.R;
import android.view.View;
import android.widget.TextView;

class VenueAdapter(
    val layoutInflater: LayoutInflater,
    val venueList: List<Venue>,
    val onItemClick: ((Venue) -> Unit)? = null
) :
    RecyclerView.Adapter<VenueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        return VenueViewHolder(
            layoutInflater.inflate(R.layout.venue_item, parent, false),
            onItemClick
        )
    }

    override fun onBindViewHolder(
        holder: VenueViewHolder, position: Int
    ) {
        holder.setData(venueList.get(position))
    }

    override fun getItemCount(): Int = venueList.size

    public inner class VenueViewHolder(
        val itemView: View,
        val onItemClick: ((Venue) -> Unit)? = null
    ) : RecyclerView.ViewHolder(itemView) {
        private lateinit var tvVenueName: TextView
        private lateinit var tvVenueShowDate: TextView
        private var venue: Venue? = null

        init {
            tvVenueName = itemView.findViewById(R.id.tvVenueName)
            tvVenueShowDate = itemView.findViewById(R.id.tvVenueShowDate)

            setListener()
        }

        fun setListener() {
            itemView.setOnClickListener {
                venue?.let { onItemClick?.invoke(it) }
            }
        }

        fun setData(venue: Venue) {
            this.venue = venue
            tvVenueName.text = "Venue : \n\t${venue.name}"
            tvVenueShowDate.text = "Show Date : \n\t${venue.showDisplayDate}"
        }
    }
}