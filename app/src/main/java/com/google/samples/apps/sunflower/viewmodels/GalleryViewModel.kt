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

package com.google.samples.apps.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.google.samples.apps.sunflower.data.UnsplashPhoto
import com.google.samples.apps.sunflower.data.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
/*
* @HiltViewModel 은 2021년 4월 7일 기준 안드로이드 공식문서 한글판에는 적혀있는게 없고 영문 문서에만
* 안드로이드 클래스에 디펜던시 주입하는데 ViewModel에는 @HiltViewModel 을 사용한다고 나와있다.
*
Hilt 2.31에서 나왔고 기존의 ViewModel은 @Assisted와 ViewModelInject 을 사용하여 DI를 했는데
* 이제는 @Inject와 @HiltViewModel 를 활용하면 된다.
*@AndroidEntryPoint 어노테이션가 있는 액티비티나 프래그먼트에서 이 Hilt가 적용된 ViewModel 인스턴스를 얻으려면
* ViewModelProvider 나 kt-extensions 를 활용한 by viewmodels() 을 활용하면 된다.

* https://proandroiddev.com/whats-new-in-hilt-and-dagger-2-31-c46b7abbc64a

*
* */
@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: UnsplashRepository
) : ViewModel() {
    private var currentQueryValue: String? = null
    private var currentSearchResult: Flow<PagingData<UnsplashPhoto>>? = null

    fun searchPictures(queryString: String): Flow<PagingData<UnsplashPhoto>> {
        currentQueryValue = queryString
        val newResult: Flow<PagingData<UnsplashPhoto>> =
            repository.getSearchResultStream(queryString).cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}
