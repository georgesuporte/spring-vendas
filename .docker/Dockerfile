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
ARG JAVA_HOME_DOCKER=/opt/java/current
ENV PATH ${PATH}:${JAVA_HOME_DOCKER}/bin
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
    paxctl 

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

# =============================================================================
# Config Java
# =============================================================================
# RUN update-java-alternatives -s java-8-oracle
# RUN echo "export ${PATH}" >> ~/.bashrc
# RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# =============================================================================
# Clear Folder Tmp
# =============================================================================
RUN rm -rf /tmp/*

WORKDIR /
ENTRYPOINT ["/bin/sh", "-c", "bash"]
CMD ["/bin/sh"]