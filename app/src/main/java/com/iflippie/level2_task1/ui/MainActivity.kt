package com.iflippie.level2_task1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.iflippie.level2_task1.R
import com.iflippie.level2_task1.model.Place
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val places = arrayListOf<Place>()
    private val placeAdapter = PlaceAdapter(places)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        rvPlaces.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvPlaces.adapter = placeAdapter

        // Populate the places list and notify the data set has changed.
        for (i in Place.PLACE_NAMES.indices) {
            places.add(
                Place(
                    Place.PLACE_NAMES[i],
                    Place.PLACE_RES_DRAWABLE_IDS[i]
                )
            )
        }
        placeAdapter.notifyDataSetChanged()
    }

}
