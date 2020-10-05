package com.github.panarik.smartFeatures.kakao.screen


import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.github.panarik.smartFeatures.R

open class SignInScreen : Screen<SignInScreen>() {

    val signIn = KTextView {withId(R.id.chat_toggleSingUpTextView)}
    val email = KEditText {withId(R.id.chat_emailEditText)}
    val pass = KEditText {withId(R.id.chat_passwordEditText)}
    val loginSignUpButton = KEditText {withId(R.id.chat_loginSignUpButton)}

}