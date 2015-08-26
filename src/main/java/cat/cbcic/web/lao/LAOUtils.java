package cat.cbcic.web.lao;

import cat.cbcic.web.dao.DAOEquips;
import cat.cbcic.web.models.Equip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class LAOUtils {

	@Autowired 
	private DAOEquips daoEquips;

	/** Escapes a String for inserting into a Javascript-literal String.
	 * Like ColdFusion's JSStringFormat function, but escapes ' to its
	 * unicode-representation rather than \', and additionally substitutes
	 * &lt; and &gt; by their unicode-representations.
	 * In detail, does:
	 * <table border="1">
	 * <tr><th>i</th><th>c</th><th>JSStringFormat(c)</th><th>&nbsp;</th></tr>
	 * <tr><td>8</td><td>BS</td><td>\b</td><td>CF</td></tr>
	 * <tr><td>9</td><td>TAB</td><td>\t</td><td>CF</td></tr>
	 * <tr><td>10</td><td>NL</td><td>\n</td><td>CF</td></tr>
	 * <tr><td>12</td><td>FF</td><td>\f</td><td>CF</td></tr>
	 * <tr><td>13</td><td>CR</td><td>\r</td><td>CF</td></tr>
	 * <tr><td>34</td><td>"</td><td>\u0022</td><td>CF</td></tr>
	 * <tr><td>39</td><td>'</td><td>\u0027</td><td>ours</td></tr>
	 * <tr><td>60</td><td>&lt;</td><td>\u003C</td><td>ours</td></tr>
	 * <tr><td>62</td><td>&gt;</td><td>\u003E</td><td>ours</td></tr>
	 * <tr><td>92</td><td>\</td><td>\\</td><td>CF</td></tr>
	 * </table>
	 * @param s The string to escape.
	 * @return The string with the replacements done.
	 */
	public static String JSStringFormat(String s) {
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			switch (c){
				case 8: buffer.append("\\b"); break;
				case 9: buffer.append("\\t"); break;
				case 10: buffer.append("\\n"); break;
				case 12: buffer.append("\\f"); break;
				case 13: buffer.append("\\r"); break;
				case 34: buffer.append("\\u0022"); break;
				case 39: buffer.append("\\u0027"); break;
				case 60: buffer.append("\\u003C"); break;
				case 62: buffer.append("\\u003E"); break;
				case 92: buffer.append("\\\\"); break;
				default: buffer.append(c); break;
			}//switch
		}//for
		return buffer.toString();
	}

    /** Escapes a String for inserting in HTML elements.
     * An exact re-implementation of ColdFusion's HTMLEdit function,
     * but independent of coldfusion-classes.
     * In detail, does:
     * <table border="1">
     * <tr><th>i</th><th>c</th><th>HTMLEditFormat(c)</th><th>Len(HTMLEditFormat(c))</th></tr>
     * <tr><td>13</td><td>CR</td><td>[empty String]</td><td>0</td></tr>
     * <tr><td>34</td><td>"</td><td>&amp;quot;</td><td>6</td></tr>
     * <tr><td>38</td><td>&</td><td>&amp;amp;</td><td>5</td></tr>
     * <tr><td>60</td><td><</td><td>&amp;lt;</td><td>4</td></tr>
     * <tr><td>62</td><td>></td><td>&amp;gt;</td><td>4</td></tr>
     * </table>
     * @param s The string to escape.
     * @return The string with the replacements done.
     */
    public static String HTMLEditFormat(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case 13: /* append "" to buffer */ break;
                case 34: buffer.append("&quot;"); break;
                case 38: buffer.append("&amp;"); break;
                case 60: buffer.append("&lt;"); break;
                case 62: buffer.append("&gt;"); break;
                default: buffer.append(c);
            }
        }//for
        return buffer.toString();
    }

	public static String StringToHTMLConverter(String str){

		return str.replaceAll("&", "&amp;")
				.replaceAll("\'", "&#39;")
                .replaceAll("\"", "&quot;")
                .replaceAll("€", "&euro;")
                .replaceAll("À", "&Agrave;")
                .replaceAll("È", "&Egrave;")
                .replaceAll("É", "&Eacute;")
                .replaceAll("Í", "&Iacute;")
                .replaceAll("Ò", "&Ograve;")
                .replaceAll("Ó", "&Oacute;")
                .replaceAll("Ú", "&Uacute;")
                .replaceAll("à", "&agrave;")
                .replaceAll("è", "&egrave;")
                .replaceAll("é", "&eacute;")
                .replaceAll("í", "&iacute;")
                .replaceAll("ò", "&ograve;")
                .replaceAll("ó", "&oacute;")
                .replaceAll("ú", "&uacute;")
                .replaceAll("Ï", "&Iuml;")
                .replaceAll("ï", "&iuml;")
                .replaceAll("Ü", "&Uuml;")
                .replaceAll("ü", "&uuml;")
                .replaceAll("Ç", "&Ccedil;")
                .replaceAll("ç", "&ccedil;")
                .replaceAll("·", "&middot;")
                .replaceAll("Ñ", "&Ntilde;")
                .replaceAll("ñ", "&ntilde;");
    }

	public static String HTMLToStringConverter(String str){

		return str.replaceAll("&#39;", "\'")
                .replaceAll("&rsquo;", "\'")
                .replaceAll("&lsquo;", "\'")
				.replaceAll("&quot;", "\"")
                .replaceAll("&euro;", "€")
                .replaceAll("&Agrave;", "À")
                .replaceAll("&Egrave;", "È")
                .replaceAll("&Eacute;", "É")
                .replaceAll("&Iacute;", "Í")
                .replaceAll("&Ograve;", "Ò")
                .replaceAll("&Oacute;", "Ó")
                .replaceAll("&Uacute;", "Ú")
                .replaceAll("&agrave;", "à")
                .replaceAll("&egrave;", "è")
                .replaceAll("&eacute;", "é")
                .replaceAll("&iacute;", "í")
                .replaceAll("&ograve;", "ò")
                .replaceAll("&oacute;", "ó")
                .replaceAll("&uacute;", "ú")
                .replaceAll("&Iuml;", "Ï")
                .replaceAll("&iuml;", "ï")
                .replaceAll("&Uuml;", "Ü")
                .replaceAll("&uuml;", "ü")
                .replaceAll("&Ccedil;", "Ç")
                .replaceAll("&ccedil;", "ç")
                .replaceAll("&middot;", "·")
                .replaceAll("&Ntilde;", "Ñ")
                .replaceAll("&ntilde;", "ñ")
                .replaceAll("&nbsp;", "")
                .replaceAll("&amp;", "&")
                .replaceAll("&nbsp;", "");
	}

}