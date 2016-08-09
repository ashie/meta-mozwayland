SUMMARY = "GTK+ icon theme"
HOMEPAGE = "http://ftp.gnome.org/pub/GNOME/sources/adwaita-icon-theme/"
BUGTRACKER = "https://bugzilla.gnome.org/"
SECTION = "x11/gnome"

LICENSE = "LGPL-3.0 | CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=c84cac88e46fc07647ea07e6c24eeb7c"

#inherit allarch autotools pkgconfig gettext gtk-icon-cache
inherit autotools pkgconfig gettext gtk-icon-cache

DEPENDS += "intltool-native"

MAJ_VER = "${@oe.utils.trim_version("${PV}", 2)}"
SRC_URI = "${GNOME_MIRROR}/${BPN}/${MAJ_VER}/${BPN}-${PV}.tar.xz \
          "

SRC_URI[md5sum] = "75ed0541d5939c415cb2e0e2010f639f"
SRC_URI[sha256sum] = "afacb6025a18be007e33a9663b92cee9d2745279bb00107a68e09b2806f9541f"

do_install_append() {
	# Build uses gtk-encode-symbolic-svg to create png versions:
        # no need to store the svgs anymore.
	rm -f ${D}${prefix}/share/icons/Adwaita/scalable/*/*-symbolic.svg \
	      ${D}${prefix}/share/icons/Adwaita/scalable/*/*-symbolic-rtl.svg
}

PACKAGES = "${PN}-cursors ${PN}-symbolic ${PN}-hires ${PN}"

RREPLACES_${PN} = "gnome-icon-theme"
RCONFLICTS_${PN} = "gnome-icon-theme"
RPROVIDES_${PN} = "gnome-icon-theme"

FILES_${PN}-cursors = "${prefix}/share/icons/Adwaita/cursors/"
FILES_${PN}-symbolic = "${prefix}/share/icons/Adwaita/*/*/*.symbolic.png"
FILES_${PN}-hires = "${prefix}/share/icons/Adwaita/256x256/"
FILES_${PN} = "${prefix}/share/icons/Adwaita/ \
               ${prefix}/share/pkgconfig/adwaita-icon-theme.pc"
