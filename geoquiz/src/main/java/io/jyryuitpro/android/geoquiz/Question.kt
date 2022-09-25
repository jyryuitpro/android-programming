package io.jyryuitpro.android.geoquiz

import androidx.annotation.StringRes

// @StringRes: 애노테이션이 없어도 되지만, 다음 두 가지 이유로 지정하는 것이 좋다.
// 첫 번째, 생성자에 유효한 문자열 리소스 ID를 제공하는지를 컴파일 시점에서 Lint가 검사한다.
// 따라서 유효하지 않은 리소스 ID(예를 들어, 문자열이 아닌 리소스를 참조하는 ID)가 생성자에 사용되어 런타임 시에 앱이 중단되는 것을 방지해준다.
// 두 번째, 애노테이션을 지정함으로써 다른 개발자가 쉽게 코드를 알 수 있다.
data class Question(@StringRes val textResId: Int, val answer: Boolean)
