package com.github.panarik.smartFeatures.kaspresso.screen

import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.SignInActivity
import com.kaspersky.kaspresso.screens.KScreen

object SignInScreen : KScreen<SignInScreen>() {

    override val layoutId: Int? = R.layout.activity_main
    override val viewClass: Class<*>? = SignInActivity::class.java

    val signIn_withoutAuth = KButton {withId(R.id.sign_in_without_auth)}


}