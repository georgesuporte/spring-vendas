# =============================================================================
#
# Set Image ALPINE 3.8
# 
# =============================================================================
FROM alpine:3.8

# =============================================================================
# Set Variable
# =============================================================================
ARG uid=1000
ARG gid=1000

# =============================================================================
# Set environment
# =============================================================================
ARG JAVA_HOME_DOCKER
ARG MAVEN 
ARG USER_HOME_DIR="/root"

ENV PATH ${PATH}:${JAVA_HOME_DOCKER}/bin
ENV MAVEN_HOME = ${MAVEN}
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# =============================================================================
# Install package linux Dependency 
# =============================================================================
RUN apk update \
    && apk add --no-cache --virtual .build-deps \
    bash \
    wget \
    curl \
    tar \
    xz \
    bzip2 \
    zlib-dev \
    ca-certificates \
    paxctl \
    git \
    openssh-client

# =============================================================================
# Install glibc-2.29
# =============================================================================
RUN wget -q -O /etc/apk/keys/sgerrand.rsa.pub https://alpine-pkgs.sgerrand.com/sgerrand.rsa.pub \
    && curl -Lso /tmp/glibc-2.29-r0.apk https://github.com/sgerrand/alpine-pkg-glibc/releases/download/2.29-r0/glibc-2.29-r0.apk -O \
    && apk add /tmp/glibc-2.29-r0.apk

# =============================================================================
# Install libz
# =============================================================================
RUN curl -Lso /tmp/libz.tar.xz https://www.archlinux.org/packages/core/x86_64/zlib/download -O \
    && mkdir -p /tmp/libz \
    && tar -xf /tmp/libz.tar.xz -C /tmp/libz \
    && cp /tmp/libz/usr/lib/libz.so.* /usr/glibc-compat/lib

# =============================================================================
# Install Java SDK 11.0.4
# =============================================================================
# @TODO Linha comentada download automatico.
# RUN curl -sfLo  /tmp/jdk-11.0.4_linux-x64_bin.tar.gz  -b "oraclelicense=a" http://download.oracle.com/otn-pub/java/jdk/11.0.2+9/f51449fcd52f4d52b93a989c5c56ed3c/jdk-11.0.2_linux-x64_bin.tar.gz -O \

ADD jdk/ /tmp/
RUN mkdir -p /opt/java \
    && tar -zxvf /tmp/jdk-11.0.4_linux-x64_bin.tar.gz  -C /opt/java \
    && ln -s /opt/java/jdk-11.0.4 /opt/java/current \
    && touch /etc/profile.d/java.sh | echo export JAVA_HOME=${JAVA_HOME_DOCKER} >> /etc/profile.d/java.sh | echo export PATH=${PATH} >> /etc/profile.d/java.sh \
    && sh /etc/profile.d/java.sh


# Config maven
ADD mvn/ /tmp/
RUN tar -xvzf /tmp/apache-maven-3.6.2-bin.tar.gz -C /opt/ \
    && touch /etc/profile.d/maven.sh | echo export M2_HOME=${MAVEN} >> /etc/profile.d/maven.sh | echo export PATH=${MAVEN}/bin >> /etc/profile.d/maven.sh \
    && sh /etc/profile.d/maven.sh \
    && ln -s ${MAVEN}/bin/mvn /usr/bin/mvn

# Config git
ADD .ssh/ /root/.ssh/
RUN chmod 600 -R /root/.ssh/
RUN cd /tmp \
    && git clone git@github.com:georgesuporte/spring-vendas.git
# Generate package  war
RUN cd /tmp/spring-vendas/ \
    && mvn package
# && mvn clean install \

# RUN mkdir -p /opt/app 

# RUN cp /tmp/spring-vendas/target/*.war /opt/app

EXPOSE 8080


# =============================================================================
# Clear Folder Tmp
# =============================================================================
# RUN rm -rf /tmp/*
# RUN rm -rf ${MAVEN_CONFIG}/*

WORKDIR /
# ENTRYPOINT ["/bin/sh", "-c", "bash"]
CMD ["java -jar /tmp/spring-vendas/target/spring-vendas-0.0.1-SNAPSHOT.war"]