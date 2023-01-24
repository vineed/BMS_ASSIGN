package com.bookmyshow.feature_one.venue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmyshow.feature_one.adapter.VenueAdapter
import com.bookmyshow.feature_one.databinding.ActivityFeatureOneBinding
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.util.FeatureOneViewModelFactory
import com.bookmyshow.feature_one.venue.viewmodel.FeatureOneViewModel
import javax.inject.Inject

val TAG = FeatureOneActivity::class.simpleName

class FeatureOneActivity : AppCompatActivity() {

    @Inject
    lateinit var featureOneViewModelFactory: FeatureOneViewModelFactory
    private lateinit var viewModel: FeatureOneViewModel //by viewModels<FeatureOneViewModel>()
    private lateinit var activityFeatureOneBinding: ActivityFeatureOneBinding
    private lateinit var venueAdapter:VenueAdapter
    private var venueList = mutableListOf<Venue>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureOneDaggerProvider.component.inject(this)
        activityFeatureOneBinding = ActivityFeatureOneBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_feature_one)
        setContentView(activityFeatureOneBinding.root)

        venueAdapter = VenueAdapter(LayoutInflater.from(this), venueList) { venue ->
            Log.d(TAG, "onCreate: Clicked: venue: $venue")

            //startActivity(Intent())
        }

        activityFeatureOneBinding.rvVenue.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        activityFeatureOneBinding.rvVenue.adapter = venueAdapter

        viewModel =
            ViewModelProvider(this, featureOneViewModelFactory).get(FeatureOneViewModel::class.java)

        observeData()
        observeError()
    }

    fun observeData() {
        viewModel.venuesData.observe(this) { data ->
            Log.d(TAG, "observeData: got data: $data")
            venueList.clear()
            venueList.addAll(data)

            venueAdapter.notifyDataSetChanged()
        }
    }

    fun observeError() {
        viewModel.error.observe(this) { error ->
            Log.d(TAG, "observeError: error: $error")
        }
    }
}