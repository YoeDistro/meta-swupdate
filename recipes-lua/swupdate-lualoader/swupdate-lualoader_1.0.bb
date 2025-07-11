SUMMARY = "Loader for swupdate"
LICENSE = "MIT"
SECTION = "devel/lua"
DEPENDS = "lua"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/swupdate_handlers.lua;md5=354cf4af377edd962d2e8d78085d3ed7;beginline=1;endline=19"

SRC_URI = "file://swupdate_handlers.lua"

inherit pkgconfig

do_install() {
    LUAVER=$(pkg-config --modversion lua | grep -o '^[0-9]\+\.[0-9]\+')
    install -D -m 0644 ${UNPACKDIR}/swupdate_handlers.lua ${D}${libdir}/lua/$LUAVER/swupdate_handlers.lua
    sed -e 's,@libdir@,${libdir},g' \
        -i ${D}${libdir}/lua/$LUAVER/swupdate_handlers.lua

}

RDEPENDS:${PN} = "luafilesystem"
FILES:${PN} = "${libdir}/lua"
