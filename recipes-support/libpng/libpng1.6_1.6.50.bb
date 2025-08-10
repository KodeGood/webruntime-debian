inherit dpkg

PR = "0"

S = "${WORKDIR}/libpng-${PV}"

SRC_URI = "http://prdownloads.sourceforge.net/libpng/libpng-1.6.50.tar.xz;name=libpng; \
    file://libpng-1.6.50-apng.patch \
    file://libpng-config.patch \
    file://debian-1.6.50"
SRC_URI[libpng.sha256sum] = "4df396518620a7aa3651443e87d1b2862e4e88cad135a8b93423e01706232307"

PROVIDES = "libpng-apng"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp -r ${WORKDIR}/debian-1.6.50 ${S}/debian
    deb_add_changelog
}

