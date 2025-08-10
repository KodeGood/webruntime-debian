inherit dpkg

PR = "0"

S = "${WORKDIR}/git"

SRC_URI = "git://skia.googlesource.com/skia.git;protocol=https;branch=chrome/m129;name=skia; \
    file://skia.pc \
    file://rules"
SRCREV = "f406b708b8c0d31e1bfad101fc3d1ff00e7fb19e"

DEPENDS:debian12 += "vulkan-memory-allocator"

DEBIAN_PROVIDES = "libskia, libskia-dev"

DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends},"

DEBIAN_BUILD_DEPENDS = " \
    generate-ninja, \
    libfontconfig-dev, \
    libgl1-mesa-dev, \
    libharfbuzz-dev, \
    libjpeg-dev, \
    libvulkan-dev, \
    libvulkan-memory-allocator-dev, \
    libwebp-dev, \
    ninja-build"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp ${WORKDIR}/skia.pc ${S}/
    deb_debianize
}

