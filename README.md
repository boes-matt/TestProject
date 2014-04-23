# Test Project

Test Project is an example project structure for a Gradle based Android app with tests.

Outline of project structure:

+ app
  + src
    + main
    + androidTest

+ core
  + src
    + main
    + test

[com.boes.testproject.app](https://github.com/boes-matt/TestProject/tree/master/app/src/main/java/com/boes/testproject/app) is the main app package.<br/>
It is in the [app/src/main](https://github.com/boes-matt/TestProject/tree/master/app/src/main) directory.<br/>
Package includes 2 activities, a content provider, and a service to test.

[com.boes.testproject.app.test](https://github.com/boes-matt/TestProject/tree/master/app/src/androidTest/java/com/boes/testproject/app/test) is the Android-specific test package.<br/>
It is in the [app/src/androidTest](https://github.com/boes-matt/TestProject/tree/master/app/src/androidTest) directory.<br/>
Tests use both the stock [Android testing framework](http://developer.android.com/tools/testing/testing_android.html) and [Espresso](https://code.google.com/p/android-test-kit/wiki/Espresso) from the Android Test Kit.

Espresso is set up in [app/build.gradle](https://github.com/boes-matt/TestProject/blob/master/app/build.gradle) using Jake Wharton's [Double Espresso](https://github.com/JakeWharton/double-espresso) project.<br/>
See the Double Espresso page for details about any dependency exclusions needed in build.gradle for your project.
This project excludes the support library in its androidTestCompile because it is already included in the compile dependencies.<br/>
Take note: build.gradle also sets the testInstrumentationRunner in the defaultConfig to GoogleInstrumentationTestRunner.<br/>
Set up a test run configuration for this package in Android Studio.  I call it App Tests.  Specifically set the instrumentation runner to be the GoogleInstrumentationTestRunner here.

[com.boes.testproject.core](https://github.com/boes-matt/TestProject/tree/master/core/src/main/java/com/boes/testproject/core) is the Java library package for code that does not rely on the Android framework.<br/>
It is in the [core/src/main](https://github.com/boes-matt/TestProject/tree/master/core/src/main) directory.<br/>

[com.boes.testproject.core.test](https://github.com/boes-matt/TestProject/tree/master/core/src/test/java/com/boes/testproject/core/test) is the Java library test package with tests that run on the JVM.<br/>
It is in the [core/src/test](https://github.com/boes-matt/TestProject/tree/master/core/src/test) directory.<br/>
Set up a JUnit 4 run configuration for this package in Android Studio.  I call it Core Tests.
