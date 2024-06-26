
USE_DEVFS = "1"

# This variable is triggered to check if sysvinit must be overwritten by a single rcS
export SYSVINIT = "no"

VIRTUAL-RUNTIME_initscripts-swupdate = 'initscripts-swupdate'

IMAGE_INSTALL = "base-files \
		base-passwd \
		busybox \
		mtd-utils \
		mtd-utils-ubifs \
		libconfig \
		swupdate \
		swupdate-www \
                ${@bb.utils.contains('SWUPDATE_INIT', 'tiny', '${VIRTUAL-RUNTIME_initscripts-swupdate}', 'initscripts sysvinit', d)} \
		util-linux-sfdisk \
		 "

IMAGE_FSTYPES = "ext4.gz.u-boot"

inherit image

IMAGE_LINGUAS = " "
