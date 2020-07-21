package com.github.panarik.smartFeatures;


import com.github.panarik.smartFeatures.screen.TestMainBase;
import com.github.panarik.smartFeatures.screen.TestSignInBase;
import com.github.panarik.smartFeatures.screen.TestVideoWebBase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//запуск нескольких классов
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestMainBase.class,
        TestSignInBase.class,
        TestVideoWebBase.class,
})

public class TestSuiteAll {
}
