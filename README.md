# Test Project

Test Project is an example of a Gradle-based, Android Studio project structure with regular Android tests, Espresso tests, and JVM JUnit 4 tests.

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
<br/>It is for application code that does not rely on the Android framework.

[com.boes.testproject.core.test](https://github.com/boes-matt/TestProject/tree/master/core/src/test/java/com/boes/testproject/core/test):
Java library test package located at [core/src/test](https://github.com/boes-matt/TestProject/tree/master/core/src/test)
<br/>It contains tests that run on the JVM.

## Gradle

  * Espresso is set up in [app/build.gradle](https://github.com/boes-matt/TestProject/blob/master/app/build.gradle) using Jake Wharton's [Double Espresso](https://github.com/JakeWharton/double-espresso) tool


  * See [Double Espresso](https://github.com/JakeWharton/double-espresso) README about any dependency exclusions needed in build.gradle for your project


  * This project excludes the support library in its androidTestCompile because it's already included from the compile dependencies in [app/build.gradle](https://github.com/boes-matt/TestProject/blob/master/app/build.gradle)


  * Set the testInstrumentationRunner in the defaultConfig to GoogleInstrumentationTestRunner in [app/build.gradle](https://github.com/boes-matt/TestProject/blob/master/app/build.gradle)


  * Exclude LICENSE.txt within packagingOptions in [app/build.gradle](https://github.com/boes-matt/TestProject/blob/master/app/build.gradle)


  * Add the Android-independent, core package library as a compile dependency in [app/build.gradle](https://github.com/boes-matt/TestProject/blob/master/app/build.gradle)

## Set up Android Studio run configurations

* <i>app</i>: Runs the app


* <i>App Tests</i>: Runs Android-dependent tests in [com.boes.testproject.app.test](https://github.com/boes-matt/TestProject/tree/master/app/src/androidTest/java/com/boes/testproject/app/test) on device
<br/>Specify instrumentation runner as GoogleInstrumentationTestRunner in setup.  Find by including non-project classes in search.


* <i>Core Tests</i>: Runs independent Java tests in [com.boes.testproject.core.test](https://github.com/boes-matt/TestProject/tree/master/core/src/test/java/com/boes/testproject/core/test) on development machine
<br/>Package contains JUnit 4 style test cases.
