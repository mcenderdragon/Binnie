package binnie.core.util;

import java.util.IllegalFormatException;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

public class I18N {
	
	public static String localiseOrBlank(String key) {
		String trans = localise(key);
		return trans.equals(key) ? "" : trans;
	}
	
	@SuppressWarnings("deprecation")
	public static String localise(String key) {
		if (I18n.canTranslate(key)) {
			return I18n.translateToLocal(key);
		} else {
			return I18n.translateToFallback(key);
		}
	}

	public static String localise(ResourceLocation key) {
		return localise(key.getResourceDomain() + "." + key.getResourcePath());
	}
	
	@SuppressWarnings("deprecation")
	public static boolean canLocalise(String key) {
		return I18n.canTranslate(key);
	}
	
	public static String localise(String key, Object... format) {
		String s = localise(key);
		try {
			return String.format(s, format);
		} catch (IllegalFormatException e) {
			String errorMessage = "Format error: " + s;
			Log.error(errorMessage, e);
			return errorMessage;
		}
	}

	public static String localise(ResourceLocation key, Object... format) {
		return localise(key.getResourceDomain() + "." + key.getResourcePath(), format);
	}
}
