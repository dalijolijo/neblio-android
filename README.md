Neblio Wallet
===============


## Building the app

Install [Android Studio](https://developer.android.com/sdk/installing/studio.html). Once it is
running, import neblio-android by navigating to where you cloned or downloaded it and selecting
settings.gradle. When it is finished importing, click on the SDK Manager ![SDK Manager](https://developer.android.com/images/tools/sdk-manager-studio.png). You will need to install SDK version 23.

<br/>
Make sure that you have JDK 7 installed before building. You can get it [Here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). **The project will not build with JDK 8**.

<br/>
Once it is finished installing, you will need to enable developer options on your phone. To do so,
go into settings, About Phone, locate your Build Number, and tap it 7 times, or until it says
"You are now a Developer". Then, go back to the main Settings screen and scroll once again to the
bottom. Select Developer options and enable USB Debugging.

<br/>
Then plug your phone into your computer and hit the large green play button at the top of
Android Studio. It will load for a moment before prompting you to select which device to install
it on. Select your device from the list, and hit continue.

**NOTE**
If you are attempting to build on a Lollipop emulator, please ensure that you are using *Android 5.*.* armeabi-v7*. It will not build on an x86/x86_64 emulator.


# BTX support

## Ressources
* https://gist.github.com/guipmourao/3e7edc951b043f6de30ca15a5cc2be40
* https://gist.github.com/eagletmt/73a0d33d3d9c2aeb31c30ee05fed528b
* https://linoxide.com/ubuntu-how-to/install-android-sdk-manager-linux-ubuntu-16-04/


### create sdk folder
```sh
export ANDROID_HOME=/opt/android-sdk-linux
mkdir -p $ANDROID_HOME
```

### install openjdk
```sh
add-apt-repository ppa:openjdk-r/ppa
apt-get update
apt-get install -y openjdk-7-jdk
update-alternatives --config java
```

optional (check "echo $JAVA_HOME")
```sh
vi /etc/environment
JAVA_HOME="..."
source /etc/environment
```

### download android sdk
* https://en.wikipedia.org/wiki/Android_version_history
* https://gist.github.com/eagletmt/73a0d33d3d9c2aeb31c30ee05fed528b
* Lollipop 	5.0 – 5.1.1 	(November 12, 2014) 	API level: 21 – 22 https://dl.google.com/android/repository/android-21_r02.zip
* Marshmallow 	6.0 – 6.0.1 	(October 5, 2015) 	API level: 23 https://dl.google.com/android/repository/platform-23_r03.zip

```sh
cd $ANDROID_HOME
wget https://dl.google.com/android/repository/tools_r25.2.3-linux.zip
unzip tools_r25.2.3-linux.zip
cd tools
```

### install all sdk packages
```sh
./android update sdk --no-ui
```

### set path
```sh
export PATH=${PATH}:$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$ANDROID_HOME/build-tools/29.0.2/
source /etc/profile
```

### check java version
```sh
root@dockerhost-ubuntu:~/groestlcoinomi# grep -r JavaVersion
Binary file gradle-4.6-all.zip matches
wallet/build.gradle:        sourceCompatibility=JavaVersion.VERSION_1_7
wallet/build.gradle:        targetCompatibility=JavaVersion.VERSION_1_7
```

```sh
root@dockerhost-ubuntu:~/groestlcoinomi# java -version
java version "1.7.0_95"
OpenJDK Runtime Environment (IcedTea 2.6.4) (7u95-2.6.4-3)
OpenJDK 64-Bit Server VM (build 24.95-b01, mixed mode)
```

### Accept licence
```sh
/opt/android-sdk-linux/tools/bin/sdkmanager "build-tools;28.0.3"
```

### build APK
```sh
cd  ~/neblio-android
./gradlew 
./gradlew assembleRelease
```
