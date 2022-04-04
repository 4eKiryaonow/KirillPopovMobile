# [Tutorial: How to run tests in the project](https://github.com/4eKiryaonow/KirillPopovMobile/blob/homework_2/README.md)
***
1. Run some AVD via Android Studio or connect Android physical device via USB.
2. Run Appium Server
3. Open cmd

#### To run tests for native app use:

   * $ mvn clean test -P native

#### To run tests for web app use:

   * $ mvn clean test -P web
***
If you use physical device you have to:
   1. Enable Developer options (tap 7 times at Build Number in Settings)
   2. Enable debugging mode
   3. Set USB configuration to MTP_
