/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.di

import com.google.samples.apps.sunflower.api.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// @InstallIn 을 지정하여 각 모듈을 사용하거나 설치할 Android 클래스를 Hilt 에 알려야한다.
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    /*API Interface @Singleton*/
    @Singleton
    @Provides
    fun provideUnsplashService(): UnsplashService {
        return UnsplashService.create()
    }
}
