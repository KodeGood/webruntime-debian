
inherit dpkg

PR = "0"

S = "${WORKDIR}/icu"

def icu_download_version(d):
    pvsplit = d.getVar('PV').split('.')
    return pvsplit[0] + "_" + pvsplit[1]

def icu_download_folder(d):
    pvsplit = d.getVar('PV').split('.')
    return pvsplit[0] + "-" + pvsplit[1]

ICU_PV = "${@icu_download_version(d)}"
ICU_FOLDER = "${@icu_download_folder(d)}"

SRC_URI = "https://github.com/unicode-org/icu/releases/download/release-${ICU_FOLDER}/icu4c-${ICU_PV}-src.tgz;name=icu; \
    file://debian"
SRC_URI[icu.sha256sum] = "dfacb46bfe4747410472ce3e1144bf28a102feeaa4e3875bac9b4c6cf30f4f3e"

# DEBIAN_PROVIDES = "libicu76, libicu-dev"

# DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends},"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cp -r ${WORKDIR}/debian ${S}
    deb_add_changelog
}
