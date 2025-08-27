inherit dpkg

DESCRIPTION = "Weston Webruntime Modules"

SRC_URI = "git://git@github.com/zhani/weston-webruntime-modules.git;protocol=https;branch=main; \
            file://assets \
            file://rules"
SRCREV = "803b23b4bd392f77aa835c2d2f4d30e9828ecfe3"

S = "${WORKDIR}/git"

DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends}"
DEBIAN_BUILD_DEPENDS = " \
    cmake, \
    libcairo2-dev, \
    pkgconf, \
    weston-dev"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build[cleandirs] += "${S}/assets"
do_prepare_build() {
    cp -r ${WORKDIR}/assets ${S}/
    deb_debianize
}
