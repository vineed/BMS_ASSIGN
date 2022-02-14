package com.bookmyshow.feature_one

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bookmyshow.common_ui.imageloader.ImageLoader
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureOneDaggerProvider.component.inject(this)
        setContentView(R.layout.activity_feature_one)

        val image = findViewById<ImageView>(R.id.test)
        imageLoader.loadImage(
            imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
            imageView = image
        )
    }
}