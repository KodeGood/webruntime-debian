inherit dpkg-raw

DESCRIPTION = "Weston Compositor Initialization"

DEBIAN_DEPENDS = "libpam-systemd, systemd, weston"

SRC_URI = " \
    file://weston-init/weston-autologin \
    file://weston-init/weston-socket.sh \
    file://weston-init/weston.env \
    file://weston-init/weston.ini \
    file://weston-init/weston.service \
    file://weston-init/weston.socket"

do_install() {
    install -v -d ${D}/lib/systemd/system/
    install -v -m 644 ${WORKDIR}/weston-init/weston.service ${D}/lib/systemd/system/
    install -v -m 644 ${WORKDIR}/weston-init/weston.socket ${D}/lib/systemd/system/

    install -v -d ${D}/etc/pam.d/
    install -v -m 644 ${WORKDIR}/weston-init/weston-autologin ${D}/etc/pam.d/

    install -v -d ${D}/etc/profile.d/
    install -v -m 644 ${WORKDIR}/weston-init/weston-socket.sh ${D}/etc/profile.d/

    install -v -d ${D}/etc/default/
    install -v -m 644 ${WORKDIR}/weston-init/weston.env ${D}/etc/default/weston

    install -v -d ${D}/etc/xdg/weston/
    install -v -m 644 ${WORKDIR}/weston-init/weston.ini ${D}/etc/xdg/weston/
}
