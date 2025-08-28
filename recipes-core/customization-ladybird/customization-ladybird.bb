inherit dpkg-raw

DESCRIPTION = "Debian Webruntime Ladybird Customization"

DEBIAN_DEPENDS = "plymouth, systemd, weston"

SRC_URI = " \
    file://bbb.html \
    file://bbb.ogg \
    file://weston.service.d/override.conf \
    file://webruntime-app-aquarium.png \
    file://webruntime-app-bigbuckbunny.png \
    file://webruntime-app-duckduckgo.png \
    file://webruntime-app-motionmark.png \
    file://webruntime-app-useragent.png \
    file://webruntime-logo-ladybird.png \
    file://webruntime-splash-ladybird.png \
    file://weston-ladybird.ini.tmpl"

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

TEMPLATE_FILES += "weston-ladybird.ini.tmpl"
TEMPLATE_VARS += "LIB_ARCH"

do_install() {
    install -v -d ${D}/etc/xdg/weston/
    install -v -m 644 ${WORKDIR}/weston-ladybird.ini ${D}/etc/xdg/weston/

    
    install -v -d ${D}/usr/share/ladybird/
    install -v -m 644 ${WORKDIR}/*.html ${D}/usr/share/ladybird/

    install -v -d ${D}/usr/share/ladybird/
    install -v -m 644 ${WORKDIR}/*.ogg ${D}/usr/share/ladybird/
    
    install -v -d ${D}/usr/share/weston/
    install -v -m 644 ${WORKDIR}/*.png ${D}/usr/share/weston/

    install -d ${D}/usr/lib/systemd/system/weston.service.d
    install -m 0644 ${WORKDIR}/weston.service.d/override.conf \
        ${D}/usr/lib//systemd/system/weston.service.d/

    install -v -d ${D}/usr/share/plymouth/themes/spinner/
    install -v -m 0644 ${WORKDIR}/webruntime-splash-ladybird.png ${D}/usr/share/plymouth/themes/spinner/background-tile.png
}

