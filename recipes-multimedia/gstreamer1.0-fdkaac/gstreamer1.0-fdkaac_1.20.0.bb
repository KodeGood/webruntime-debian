inherit dpkg

PR = "0"

S = "${WORKDIR}/gst-plugins-bad-${PV}"

SRC_URI = "https://gstreamer.freedesktop.org/src/gst-plugins-bad/gst-plugins-bad-${PV}.tar.xz;name=gst-plugins-bad; \
    file://0001-fdkaac-Add-support-for-LATM.patch \
    file://0002-fdkaacdec-Do-not-report-decoding-error-for-flush-req.patch \
    file://0003-fdkaac-Add-support-for-LOAS.patch \
    file://0004-fdkaacenc-Add-support-for-setting-header-period.patch \
    file://0005-fdkaacenc-Add-support-for-enabling-afterburner.patch \
    file://0006-fdkaacenc-Add-support-for-setting-bitrate-mode.patch \
    file://0007-fdkaacenc-Add-support-for-setting-peak-bitrate.patch \
    file://debian"
SRC_URI[gst-plugins-bad.sha256sum] = "015b8d4d9a395ebf444d40876867a2034dd3304b3ad48bc3a0dd0c1ee71dc11d"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp -r ${WORKDIR}/debian ${S}/
    deb_add_changelog
}
