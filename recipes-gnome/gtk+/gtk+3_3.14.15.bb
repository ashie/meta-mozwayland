require gtk+3.inc

MAJ_VER = "${@oe.utils.trim_version("${PV}", 2)}"

SRC_URI = "http://ftp.gnome.org/pub/gnome/sources/gtk+/${MAJ_VER}/gtk+-${PV}.tar.xz \
           file://hardcoded_libtool.patch \
           file://fix-flags-for-native.patch \
           file://fix-extract-string-cross-build-error.patch \
           file://fix-updateiconcache-build-error.patch \
          "

SRC_URI[md5sum] = "7ce5d060885bf344ae23f308e55e93df"
SRC_URI[sha256sum] = "3ac87659112ced9e5ee5bd55d055faa881aafd040f26ca40b0d8ba0fa6509c83"

S = "${WORKDIR}/gtk+-${PV}"

LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
                    file://gtk/gtk.h;endline=25;md5=1d8dc0fccdbfa26287a271dce88af737 \
                    file://gdk/gdk.h;endline=25;md5=c920ce39dc88c6f06d3e7c50e08086f2 \
                    file://tests/testgtk.c;endline=25;md5=cb732daee1d82af7a2bf953cf3cf26f1"
