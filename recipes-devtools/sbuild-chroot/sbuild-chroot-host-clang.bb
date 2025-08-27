DESCRIPTION = "Isar sbuild/schroot with Clang/LLVM toolchain for host"

SBUILD_FLAVOR = "clang"
CLANG_ARCH = "${HOST_ARCH}"

require recipes-devtools/sbuild-chroot/sbuild-chroot-host.bb
require sbuild-chroot-clang.inc

