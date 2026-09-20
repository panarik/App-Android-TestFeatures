package com.github.panarik.smartFeatures.kakao.screen


import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import com.github.panarik.smartFeatures.R

open class SignInScreen : Screen<SignInScreen>() {

    val signIn = KTextView {withId(R.id.chat_toggleSingUpTextView)}
    val email = KEditText {withId(R.id.chat_emailEditText)}
    val pass = KEditText {withId(R.id.chat_passwordEditText)}
    val loginSignUpButton = KEditText {withId(R.id.chat_loginSignUpButton)}

}