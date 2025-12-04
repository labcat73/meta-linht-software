SUMMARY = "SoapyAudio project"
DESCRIPTION = " Soapy SDR plugin for Audio devices."
HOMEPAGE = "https://github.com/pothosware/SoapyAudio"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=76c8dd204c0791e9a30c30d0406b75da"

SRCREV = "63b22ec6ebf90a3a2732db66c588de0cc0b8a378"
SRC_URI = "git://github.com/pothosware/SoapyAudio.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/SoapySDR/modules0.8/*"
DEPENDS += "soapysdr alsa-lib"
RDEPENDS:${PN}-module = "soapysdr alsa-lib"

EXTRA_OECMAKE += "\
    -DUSE_AUDIO_PULSE=OFF \
    -DUSE_AUDIO_JACK=OFF \
    -DUSE_AUDIO_ALSA=ON \
    -DUSE_AUDIO_OSS=OFF \
    -DALSA_INCLUDE_DIR=${STAGING_INCDIR} \
    -DALSA_LIB_DIR=${STAGING_LIBDIR} \
"

inherit cmake
