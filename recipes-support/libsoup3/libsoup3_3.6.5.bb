inherit dpkg

PR = "0"

S = "${WORKDIR}/libsoup-${PV}"

SHRT_VER = "${@d.getVar('PV').split('.')[0]}.${@d.getVar('PV').split('.')[1]}"

SRC_URI = "https://download.gnome.org/sources/libsoup/${SHRT_VER}/libsoup-${PV}.tar.xz;name=libsoup; \
    file://debian"
SRC_URI[libsoup.sha256sum] = "6891765aac3e949017945c3eaebd8cc8216df772456dc9f460976fbdb7ada234"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp -r ${WORKDIR}/debian ${S}
    deb_add_changelog
}
