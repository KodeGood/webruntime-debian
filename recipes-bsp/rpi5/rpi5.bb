inherit dpkg-raw

DESCRIPTION = "Raspberry PI 5 specific packages and configs"

SRC_URI = "file://config.txt \
	   file://cmdline.txt.tmpl \
     file://postinst"

DEBIAN_DEPENDS = "base-files"

TEMPLATE_VARS = "MACHINE_SERIAL BAUDRATE_TTY"
TEMPLATE_FILES = "cmdline.txt.tmpl"

do_install() {
    install -v -d ${D}/boot/firmware/
    install -v -m 644 ${WORKDIR}/config.txt ${D}/boot/firmware/
    if [ -f "${WORKDIR}/cmdline.txt" ]; then
        install -v -m 644 ${WORKDIR}/cmdline.txt ${D}/boot/firmware/
    fi
}

COMPATIBLE_MACHINE = "rpi"
