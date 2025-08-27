inherit dpkg

PR = "0"

S = "${WORKDIR}/git"

SRC_URI = "git://skia.googlesource.com/skia.git;protocol=https;branch=chrome/m129;name=skia; \
    file://skia.pc.tmpl \
    file://debian"
SRCREV = "f406b708b8c0d31e1bfad101fc3d1ff00e7fb19e"

DEPENDS:append:debian12 = "vulkan-memory-allocator"

def distro_to_lib_arch(d):
    DISTRO_TO_LIB_ARCH = {
        "amd64": "x86_64-linux-gnu",
        "arm64": "aarch64-linux-gnu",
        "armf": "arm-linux-gnu",
        "i386": "i386-linux-gnu",
        "riscv64": "riscv64-linux-gnu",
    }
    distro_arch = d.getVar('DISTRO_ARCH')
    return DISTRO_TO_LIB_ARCH[distro_arch]

LIB_ARCH := "${@distro_to_lib_arch(d)}"

TEMPLATE_FILES += "skia.pc.tmpl"
TEMPLATE_VARS += "LIB_ARCH"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp ${WORKDIR}/skia.pc ${S}/
    cp -r ${WORKDIR}/debian ${S}
    deb_add_changelog
}

