inherit dpkg

PR = "0"

S = "${WORKDIR}/simdutf-${PV}"

SRC_URI = "https://github.com/simdutf/simdutf/archive/refs/tags/v${PV}.tar.gz;name=simdutf; \
    file://rules"
SRC_URI[simdutf.sha256sum] = "ff5ee7fa9a02372819ca9fbb78983dd6e9a2140a13507c98fd9b91d2766bf9b5"

DEBIAN_PROVIDES = "simdutf, simdutf-dev"

DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends},"

DEBIAN_BUILD_DEPENDS = " \
    cmake, \
    ninja-build"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    deb_debianize
}

