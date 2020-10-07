package com.github.panarik.smartFeatures;


import com.github.panarik.smartFeatures.espresso.screen.TestLandscape;
import com.github.panarik.smartFeatures.espresso.screen.TestShopMain;
import com.github.panarik.smartFeatures.espresso.screen.TestSignIn;
import com.github.panarik.smartFeatures.espresso.screen.TestVideoWeb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//запуск нескольких классов одновременно
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestShopMain.class,
        TestSignIn.class,
        TestVideoWeb.class,
        TestLandscape.class
})

public class TestSuiteAll {
}
