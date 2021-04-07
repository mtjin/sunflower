/*
 * Copyright 2018 Google LLC
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

package com.google.samples.apps.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.google.samples.apps.sunflower.BuildConfig
import com.google.samples.apps.sunflower.PlantDetailFragment
import com.google.samples.apps.sunflower.data.GardenPlantingRepository
import com.google.samples.apps.sunflower.data.PlantRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
/*
* ViewModel 관련 Hilt에서 위 사항 말고도 다음과 같이 @AssistedInject , @Assisted 라는 어노테이션도 있다.

AssitedInject는 Dagger의 컴파일타임 안정성과 의존성 주입 이후 원하는 의존성을 얻을 수 있도록 도와준다.
* 쉽게 말해서 동적인 파라미터들과 함께 의존성 주입을 할 수 있다.
* (예를들어 SavedState 정보나 고유ID값 등, WorkManager에서도 @Assisted 을 사용한다.
* WorkerParameters와 context 의 동적인 전달을 받기 위해서이다.
* https://dagger.dev/dev-guide/assisted-injection.html
* https://proandroiddev.com/whats-new-in-hilt-and-dagger-2-31-c46b7abbc64a
* https://www.charlezz.com/?p=44184
*
* */
/**
 * The ViewModel used in [PlantDetailFragment].
 */
class PlantDetailViewModel @AssistedInject constructor(
    plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    @Assisted private val plantId: String
) : ViewModel() {

    val isPlanted = gardenPlantingRepository.isPlanted(plantId).asLiveData()
    val plant = plantRepository.getPlant(plantId).asLiveData()

    fun addPlantToGarden() {
        viewModelScope.launch {
            gardenPlantingRepository.createGardenPlanting(plantId)
        }
    }

    fun hasValidUnsplashKey() = (BuildConfig.UNSPLASH_ACCESS_KEY != "null")

    companion object {
        fun provideFactory(
            assistedFactory: PlantDetailViewModelFactory,
            plantId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(plantId) as T
            }
        }
    }
}

@AssistedFactory
interface PlantDetailViewModelFactory {
    fun create(plantId: String): PlantDetailViewModel
}
