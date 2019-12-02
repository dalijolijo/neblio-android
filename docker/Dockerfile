# Use an official Ubuntu runtime as a parent image
FROM ubuntu:16.04

USER root

# Change sh to bash
SHELL ["/bin/bash", "-c"]

ENV ANDROID_HOME="/opt/android-sdk-linux"
ENV JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre"

# Running updates and installing required packages
RUN echo '*** Running updates and installing required packages ***' && \
    apt-get update -y && \
apt-get install -y openjdk-8-jdk \
                        curl \
                        git \
                        vim \
                        wget \
                        zip \
                        unzip

# create sdk folder
RUN mkdir -p $ANDROID_HOME

# install openjdk
#RUN wget -qO - https://deb.opera.com/archive.key | sudo apt-key add -
#RUN add-apt-repository ppa:openjdk-r/ppa && \
#    apt-get update && \
#    apt install openjdk-8-jdk

# set JAVA_HOME and ANDROID_HOME
RUN echo 'JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre"' >> /etc/environment && \
    echo 'ANDROID_HOME="/opt/android-sdk-linux"' >> /etc/environment && \
    source /etc/environment && \
    cat /etc/environment

# download android sdk
RUN cd $ANDROID_HOME && \
    wget https://dl.google.com/android/repository/tools_r25.2.3-linux.zip && \
    unzip tools_r25.2.3-linux.zip

# install all sdk packages
RUN cd ${ANDROID_HOME}/tools && \
    ./android update sdk --no-ui

# set path
RUN export PATH=${PATH}:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools:${ANDROID_HOME}/build-tools/29.0.2/ && \
    source /etc/profile

# accept license
RUN echo y | /opt/android-sdk-linux/tools/bin/sdkmanager "platforms;android-23" && \
    echo y | /opt/android-sdk-linux/tools/bin/sdkmanager "build-tools;28.0.3"
#RUN echo yes | /opt/android-sdk-linux/tools/bin/sdkmanager --licenses

# build APK
RUN cd && git clone -b btx-reduced https://github.com/dalijolijo/neblio-android.git
RUN export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8 && \
    cd  ~/neblio-android && \
    ./gradlew && \
    ./gradlew assembleRelease

RUN echo "Find APK in: /root/neblio-android/wallet/build/outputs/apk/release/wallet-release-unsigned.apk"

ENV TERM linux
CMD ["/bin/bash"]
