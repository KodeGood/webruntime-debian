inherit dpkg

SUMMARY = "Generate Ninja"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0fca02217a5d49a14dfe2d11837bb34d"

S = "${WORKDIR}/git"

SRC_URI = "git://gn.googlesource.com/gn.git;protocol=https;branch=main \
    file://Unbundling-version-from-git.patch \
    file://hardening.patch \
    file://debian"
SRCREV = "487f8353f15456474437df32bb186187b0940b45"

# DEBIAN_PROVIDES = ""

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp -r ${WORKDIR}/debian ${S}/
    deb_add_changelog
}

