package com.github.panarik.smartFeatures;


import com.github.panarik.smartFeatures.screen.TestLandscape;
import com.github.panarik.smartFeatures.screen.TestMain;
import com.github.panarik.smartFeatures.screen.TestSignIn;
import com.github.panarik.smartFeatures.screen.TestVideoWeb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//запуск нескольких классов одновременно
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestMain.class,
        TestSignIn.class,
        TestVideoWeb.class,
        TestLandscape.class
})

public class TestSuiteAll {
}
