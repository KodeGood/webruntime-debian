inherit dpkg

SRC_URI = "git://github.com/LadybirdBrowser/ladybird.git;protocol=https;branch=master; \
    file://0001-Downgrade-icu-version-requirement.patch \
    file://0002-Support-OpenSSL-3.2.patch \
    file://0003-Build-Lagom-tools-when-cross-compiling.patch \
    file://0004-Hack-frameless-Qt-BrowserWindow.patch \
    file://rules"
SRCREV = "e2c935475f615cc7b5ebf83a2aec806d11be394f"

S = "${WORKDIR}/git"

SBUILD_FLAVOR="clang"

DEPENDS = "angle simdutf skia"

DEBIAN_DEPENDS =. " \
    libangle, \
    libavif16, \
    libskia, \
    libtommath1, \
    simdutf, \
    qt6-wayland, \
    \${shlibs:Depends}, \
    \${misc:Depends}"

DEBIAN_BUILD_DEPENDS = " \
    cmake, \
    fonts-liberation2, \
    libangle-dev, \
    libavcodec-dev, \
    libavformat-dev, \
    libavif-dev, \
    libcurl4-openssl-dev, \
    libdrm-dev, \
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
    libsqlite3-dev, \
    libtommath-dev, \
    libwebp-dev, \
    libwoff-dev, \
    libxkbcommon-dev, \
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
