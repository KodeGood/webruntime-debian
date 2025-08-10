inherit dpkg

PR = "3"

S = "${WORKDIR}/libpng-${PV}"

SRC_URI = "http://prdownloads.sourceforge.net/libpng/libpng-1.6.39.tar.xz;name=libpng; \
    file://libpng-1.6.39-apng.patch \
    file://libpng-config.patch \
    file://debian-1.6.39"
SRC_URI[libpng.sha256sum] = "1f4696ce70b4ee5f85f1e1623dc1229b210029fa4b7aee573df3e2ba7b036937"

PROVIDES = "libpng-apng"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    mkdir -p ${S}/debian
    cp -r ${WORKDIR}/debian-1.6.39/. ${S}/debian/
    deb_add_changelog
}

