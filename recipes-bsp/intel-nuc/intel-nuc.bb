inherit dpkg-raw

DESCRIPTION = "Intel NUC specific packages and configs"

SRC_URI = " \
    file://postinst"

DEBIAN_DEPENDS = "initramfs-tools"
