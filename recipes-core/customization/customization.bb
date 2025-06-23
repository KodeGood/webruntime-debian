inherit dpkg-raw

DESCRIPTION = "Debian Webruntime Customization"

DEBIAN_DEPENDS = "plymouth, systemd, weston"

SRC_URI = " \
    file://20-dhcp.network \
    file://50-webruntime.rules \
    file://postinst"

do_install() {
    install -v -d ${D}/etc/systemd/network/
    install -v -m 644 ${WORKDIR}/20-dhcp.network ${D}/etc/systemd/network/

    install -v -d ${D}/etc/polkit-1/rules.d
    install -v -m 644 ${WORKDIR}/50-webruntime.rules ${D}/etc/polkit-1/rules.d/
}
