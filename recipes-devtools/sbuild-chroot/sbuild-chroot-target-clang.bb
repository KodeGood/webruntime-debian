DESCRIPTION = "Isar sbuild/schroot with Clang/LLVM toolchain for target"

SBUILD_FLAVOR = "clang"
CLANG_ARCH = "${DISTRO_ARCH}"

require recipes-devtools/sbuild-chroot/sbuild-chroot-target.bb
require sbuild-chroot-clang.inc

