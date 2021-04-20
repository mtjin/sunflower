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


/*https://programmar.tistory.com/51
   * Repository Pattern에서 Repository는 뷰, 뷰 모델과 별개로 존재해야 하며, 어디서든 접근이 가능해야 하므로
   *  Singleton 컴포넌트로 작성을 합니다.
   *  그리하여 Repository 모듈은 InstallIn(SingletonComponent::class)를 통해 싱글턴 모듈임을 나타내도록 합니다.*/

/*
* 참고로 Repository는 왜 싱글턴 객체여야 하는가? Repository는 네트워크 작업 혹은 데이터베이스 작업을 위해 만들어진 뷰와 뷰 모델과는 별개의 공간입니다. 만약 싱글턴이 아닌 단순 클래스라고 가정하면, 매번 네트워크 작업 혹은 데이터베이스 작업이 일어날 시 새로운 클래스 객체를 생성한다는 것은 매우 비효율적입니다.
* 만약 클래스 생성이 오래 걸린다고 가정하면, 네트워크 작업 및 데이터베이스 작업을 하기 위해 클래스 객체를 생성하는 것은 네트워크 처리, 데이터베이스 처리 시간에 더해져 매우 오래 걸릴 것입니다. 그래서 싱글턴 객체로 선언을 하여 항상 어디서든 준비되어 있도록 합니다.
* */
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
