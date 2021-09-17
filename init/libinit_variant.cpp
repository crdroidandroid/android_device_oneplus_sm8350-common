/*
 * Copyright (C) 2021 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include <android-base/properties.h>
#include <libinit_utils.h>

#include <libinit_variant.h>

using android::base::GetProperty;

void set_variant_props(const variant_info_t variant) {
    set_ro_build_prop("brand", variant.brand, true);
    set_ro_build_prop("manufacturer", variant.brand, true);
    set_ro_build_prop("device", variant.device, true);
    set_ro_build_prop("name", variant.name, true);
    set_ro_build_prop("model", variant.model, true);
    set_ro_build_prop("product", variant.model, false);
    set_ro_build_prop("fingerprint", variant.build_fingerprint, false);
    set_ro_build_prop("description", fingerprint_to_description(variant.build_fingerprint), false);

    property_override("ro.vendor.product.manufacturer.db", "OP_PHONE");
    property_override("ro.vendor.product.device.db", "OP_DEVICE");
}
