# Test Project

Test Project is an example project structure for a Gradle-based Android app with tests.

## Outline

* [app/src/main](https://github.com/boes-matt/TestProject/tree/master/app/src/main)
* [app/src/androidTest](https://github.com/boes-matt/TestProject/tree/master/app/src/androidTest)
* [core/src/main](https://github.com/boes-matt/TestProject/tree/master/core/src/main)
* [core/src/test](https://github.com/boes-matt/TestProject/tree/master/core/src/test)

## Packages

[com.boes.testproject.app](https://github.com/boes-matt/TestProject/tree/master/app/src/main/java/com/boes/testproject/app):
main app package located at [app/src/main](https://github.com/boes-matt/TestProject/tree/master/app/src/main)
<br/>Package includes 2 activities, a content provider, and a service to test.


[com.boes.testproject.app.test](https://github.com/boes-matt/TestProject/tree/master/app/src/androidTest/java/com/boes/testproject/app/test):
Android-specific test package located at [app/src/androidTest](https://github.com/boes-matt/TestProject/tree/master/app/src/androidTest)
<br/>Tests use both the stock [Android testing framework](http://developer.android.com/tools/testing/testing_android.html) and [Espresso](https://code.google.com/p/android-test-kit/wiki/Espresso).


[com.boes.testproject.core](https://github.com/boes-matt/TestProject/tree/master/core/src/main/java/com/boes/testproject/core):
Java library package located at [core/src/main](https://github.com/boes-matt/TestProject/tree/master/core/src/main)
<br/>It is for code that does not rely on the Android framework.

[com.boes.testproject.core.test](https://github.com/boes-matt/TestProject/tree/master/core/src/test/java/com/boes/testproject/core/test):
Java library test package located at [core/src/test](https://github.com/boes-matt/TestProject/tree/master/core/src/test)
<br/>It contains tests that run on the JVM.

## Gradle

  * Espresso is set up in [app/build.gradle](https://github.com/boes-matt/TestProject/blob/master/app/build.gradle) using Jake Wharton's [Double Espresso](https://github.com/JakeWharton/double-espresso) tool


  * See Double Espresso README about any dependency exclusions needed in build.gradle for your project


  * This project excludes the support library in its androidTestCompile because it's already included from the compile dependencies


  * In build.gradle, set the testInstrumentationRunner in the defaultConfig to GoogleInstrumentationTestRunner


  * In build.gradle, exclude LICENSE.txt within packagingOptions


## Set up Android Studio run configurations

* <i>app</i>: Runs the app


* <i>App Tests</i>: Runs Android-dependent tests in the com.boes.testproject.app.test package on the device
<br/>Specify instrumentation runner as GoogleInstrumentationTestRunner (Find by including non-project classes in search).


* <i>Core Tests</i>: Runs independent Java tests in the com.boes.testproject.core.test package on your development machine
<br/>Package contains JUnit 4 style test cases.
