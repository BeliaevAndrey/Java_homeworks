package additional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseRegs {

    String[] parseCpuLine(String cpuLine){
        String[] params = new String[3];
        Pattern brand = Pattern.compile("Intel|INTEL|AMD");
        Pattern socketI = Pattern.compile("1150|1155|1156|2011|775|988|G2|G3|Socket_P");
        Pattern socketA = Pattern.compile("AM[2-3][+]?|FM[2-3][+]?");
        Pattern family = Pattern.compile("Core[ -]i[3-9][ -/\\d\\w()]{2,15}|" +
                "Phenom[ IX12345678]{3}|" +
                "Athlon[ IX12345678]{3}|ATH[ IX12345678]{3}|AMD X4|" +
                "Sempron [\\d]{3,4} |" +
                "Core[ ]?[2][ ]?Duo|" +
                "Celeron Dual Core|" +
                "Celeron [MDG] ?[0-9]{3,5}J?|" +
                "Celeron [\\d]{3,4} |" +
                "Pentium[-]4 [\\d]{3,4}|" +
                "Pentium [MXGD \\d]{2,15} |" +
                "Xeon [ -/\\d\\w()]{2,15}");
//        Pattern family = Pattern.compile("Core");

        Matcher brandM = brand.matcher(cpuLine);
        Matcher familyM = family.matcher(cpuLine.replaceAll("[\\d.]GHz", ""));
        Matcher socketIM = socketI.matcher(cpuLine);
        Matcher socketAM = socketA.matcher(cpuLine);

        if (brandM.find()) {
            params[0] = cpuLine.substring(brandM.start(), brandM.end()).strip();
        }
        if (familyM.find()) {
            params[1] = cpuLine.substring(familyM.start(), familyM.end()).strip();
        }
        if (socketIM.find()) {
            params[2] = cpuLine.replaceAll("[\\d.]GHz", "").substring(socketIM.start(), socketIM.end()).strip();
        }
        if (socketAM.find()) {
            params[2] = cpuLine.substring(socketAM.start(), socketAM.end()).strip();
        }

        return params;
    }
}
