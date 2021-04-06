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

package com.google.samples.apps.sunflower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.google.samples.apps.sunflower.databinding.ActivityGardenBinding
import dagger.hilt.android.AndroidEntryPoint

/* 출처 : https://developer.android.com/training/dependency-injection/hilt-android?hl=ko#android-classes
* Application 클래스에 Hilt를 설정하고 애플리케이션 수준 구성요소를 사용할 수 있게 되면
* Hilt는 @AndroidEntryPoint 주석이 있는 다른 Android 클래스에 종속 항목을 제공할 수 있습니다.
*
* Android 클래스에 @AndroidEntryPoint로 주석을 지정하면 이 클래스에 종속된 Android 클래스에도 주석을 지정해야 합니다.
* 예를 들어 프래그먼트에 주석을 지정하면 이 프래그먼트를 사용하는 활동에도 주석을 지정해야 합니다.
*
* @AndroidEntryPoint는 프로젝트의 각 Android 클래스에 관한 개별 Hilt 구성요소를 생성합니다.
* 이러한 구성요소는 구성요소 계층 구조에 설명된 대로 각 상위 클래스에서 종속 항목을 받을 수 있습니다.
* */
@AndroidEntryPoint
class GardenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityGardenBinding>(this, R.layout.activity_garden)
    }
}
