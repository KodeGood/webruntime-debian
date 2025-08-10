inherit dpkg

PR = "0"

S = "${WORKDIR}/VulkanMemoryAllocator-${PV}"

SRC_URI = "https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator/archive/refs/tags/v3.2.1.tar.gz;name=vma; \
    file://rules"
SRC_URI[vma.sha256sum] = "5e7749504cb802427ffb7bec38a0b6a15db46ae253f00560acb3e624d9fe695c"

DEBIAN_PROVIDES = "libvulkan-memory-allocator, libvulkan-memory-allocator-dev"

DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends},"

DEBIAN_BUILD_DEPENDS = " \
    cmake, \
    libvulkan-dev"


do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    deb_debianize
}

