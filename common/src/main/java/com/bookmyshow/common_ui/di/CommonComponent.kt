package com.bookmyshow.common_ui.di

import dagger.Component

/**
 * Created by Akshansh Dhing on 14/02/22.
 */
@Component(
    modules = [
        CommonModule::class
    ]
)
interface CommonComponent {

    @Component.Factory
    interface Factory {
        fun create(): CommonComponent
    }
}