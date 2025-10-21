# Debian Web Runtime Demo

**Blog Posts (Full Story & Details):**

[Build Embedded Debian Web Runtime with the Power of Isar](https://medium.com/kodegood/build-embedded-debian-web-runtime-with-the-power-of-isar-d82df0a91ae2)
[Ladybird Browser in an Embedded Web Runtime](https://medium.com/kodegood/ladybird-browser-in-an-embedded-web-runtime-46308082af4a)

## Prerequisites

Before building the system, you need to install Docker on the build host.
For example, on Ubuntu Linux:
```shell
sudo apt install docker.io
```

Make sure you have the required permissions to start containers.
See the [Docker post-installation steps](https://docs.docker.com/engine/install/linux-postinstall/)

## Building Images

Invoke the configuration menu to select the desired image configuration and start the build:
```shell
./kas-container menu
```


After the build is complete, the final target image will be located under:
```shell
build/tmp/deploy/images/<board>/
```

### Known issues

Some distributions use **AppArmor** and in some cases **AppArmor** user namespace creation restrictions cause our platform build to fail with permission errors.
This happens at least on **Ubuntu 24.04** and **Ubuntu 25.04**.

If you encounter this issue, apply the following workaround:

**Temporary solution**

`sudo sysctl -w kernel.apparmor_restrict_unprivileged_userns=0`

**To make it permanent**

`echo 'kernel.apparmor_restrict_unprivileged_userns = 0' | sudo tee /etc/sysctl.d/20-apparmor-donotrestrict.conf`
