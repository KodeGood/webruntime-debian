inherit dpkg

SRC_URI = "git://github.com/LadybirdBrowser/ladybird.git;protocol=https;branch=master; \
    file://0001-Downgrade-icu-version-requirement.patch \
    file://rules"
SRCREV = "05ee3f187696e2a3ef52eba3a11c180b6e346d1d"

S = "${WORKDIR}/git"

DEPENDS = "angle libpng-apng simdutf skia"

# DEPENDS:debian12 += "icu"

DEBIAN_BUILD_DEPENDS = " \
    cmake, \
    fonts-liberation2, \
    libangle-dev, \
    libavcodec-dev, \
    libavformat-dev, \
    libavif-dev, \
    libfast-float-dev, \
    libfontconfig-dev, \
    libgl1-mesa-dev, \
    libharfbuzz-dev, \
    libicu-dev, \
    libjpeg-dev, \
    libjxl-dev, \
    libpng-dev, \
    libpulse-dev, \
    libskia-dev, \
    libssl-dev, \
    libtommath-dev, \
    libwebp-dev, \
    libwoff-dev, \
    nasm, \
    ninja-build, \
    pkg-config, \
    qt6-base-dev, \
    qt6-tools-dev-tools, \
    simdutf-dev"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    deb_debianize
}
