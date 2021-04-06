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

package com.google.samples.apps.sunflower

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/* 출처 : https://developer.android.com/training/dependency-injection/hilt-android?hl=ko
* Hilt를 사용하는 모든 앱은 @HiltAndroidApp으로 주석이 지정된 Application 클래스를 포함해야 합니다.
  @HiltAndroidApp은 애플리케이션 수준 종속 항목 컨테이너 역할을 하는 애플리케이션의 기본 클래스를 비롯하여 Hilt의 코드 생성을 트리거합니다.
* 생성된 이 Hilt 구성요소는 Application 객체의 수명 주기에 연결되며 이와 관련한 종속 항목을 제공합니다.
* 또한 이는 앱의 상위 구성요소이므로 다른 구성요소는 이 상위 구성요소에서 제공하는 종속 항목에 액세스할 수 있습니다.
* */
@HiltAndroidApp
class MainApplication : Application()
