package com.assistivekart.util;

/**
 * The real e_commerce schema has no slug columns (categories only has
 * category_name, for example). The frontend still routes/filter by slug,
 * so we derive one consistently from the display name instead of storing it.
 */
public final class SlugUtil {

    private SlugUtil() {}

    public static String toSlug(String input) {
        if (input == null) return "";
        return input.trim()
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-+|-+$)", "");
    }
}
