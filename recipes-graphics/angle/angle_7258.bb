inherit dpkg

PR = "0"

S = "${WORKDIR}/angle_${PV}"

SRC_URI = "https://github.com/zhani/angle/releases/download/v7258/angle_${PV}.tar.xz;name=angle; \
    file://0001-Debianize-clang-toolchain-paths.patch \
    file://angle.pc.tmpl \
    file://debian"
SRC_URI[angle.sha256sum] = "97b097b8aab9f8d36ae0296fafe352c9933f8cf363f92a2e09148bb0b0371528"

DEPENDS += "generate-ninja"

SBUILD_FLAVOR="clang"

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

TEMPLATE_FILES += "angle.pc.tmpl"
TEMPLATE_VARS += "LIB_ARCH"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp ${WORKDIR}/angle.pc ${S}/
    cp -r ${WORKDIR}/debian ${S}
    deb_add_changelog
}
