inherit dpkg

PR = "0"

S = "${WORKDIR}/git"

SRC_URI = "gitsm://chromium.googlesource.com/angle/angle;protocol=https;branch=chromium/7258;name=angle; \
    file://angle.pc \
    file://rules"
SRCREV = "7ab02e1d49a649adaba62b8a7fdfabf8144b313f"

# DEPENDS:debian12 += "vulkan-memory-allocator"

DEBIAN_PROVIDES = "libangle, libangle-dev"

DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends},"

DEBIAN_BUILD_DEPENDS = " \
    generate-ninja, \
    libgl1-mesa-dev, \
    ninja-build"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp ${WORKDIR}/angle.pc ${S}/
    deb_debianize
}

