package com.bookmyshow.network.di

import dagger.Component

/**
 * Created by Akshansh Dhing on 14/02/22.
 */
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface NetworkComponent {

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }
}