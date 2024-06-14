package es.iesmm.GlobalChatAPI.logic;

import es.iesmm.GlobalChatAPI.models.Mensaje;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;

public class Traductor {
    public static String translate(String str, Language idioma) {

        return Translator.translate(idioma, str);

    }
}
