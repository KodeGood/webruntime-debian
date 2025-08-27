CLANG_ARCH ??= "amd64"

python() {
    distro_clang = d.getVar('DISTRO_CLANG')
    distro_arch = d.getVar('DISTRO_ARCH')
    clang_arch = d.getVar('CLANG_ARCH')

    if d.getVar('DISTRO_CLANG'):
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" clang-{distro_clang}:{clang_arch}")
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" clang-tools-{distro_clang}:{clang_arch}")
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" libclang-rt-{distro_clang}-dev:{distro_arch}")
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" lld-{distro_clang}:{clang_arch}")
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" llvm-{distro_clang}:{clang_arch}")
    else:
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" clang:{clang_arch}")
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" clang-tools:{clang_arch}")
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" libclang-rt-dev:{distro_arch}")
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" lld:{clang_arch}")
        d.appendVar('SBUILD_CHROOT_PREINSTALL_EXTRA',
                    f" llvm:{clang_arch}")
}
