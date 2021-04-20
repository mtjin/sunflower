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

import android.content.Context
import com.google.samples.apps.sunflower.data.AppDatabase
import com.google.samples.apps.sunflower.data.GardenPlantingDao
import com.google.samples.apps.sunflower.data.PlantDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*https://programmar.tistory.com/51
   * Repository Pattern에서 Repository는 뷰, 뷰 모델과 별개로 존재해야 하며, 어디서든 접근이 가능해야 하므로
   *  Singleton 컴포넌트로 작성을 합니다.
   *  그리하여 Repository 모듈은 InstallIn(SingletonComponent::class)를 통해 싱글턴 모듈임을 나타내도록 합니다.*/

// @InstallIn 을 지정하여 각 모듈을 사용하거나 설치할 Android 클래스를 Hilt 에 알려야한다.
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    /*데이터베이스만 Singleton이고 Dao 주입은 아니다. */
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providePlantDao(appDatabase: AppDatabase): PlantDao {
        return appDatabase.plantDao()
    }

    @Provides
    fun provideGardenPlantingDao(appDatabase: AppDatabase): GardenPlantingDao {
        return appDatabase.gardenPlantingDao()
    }
}
