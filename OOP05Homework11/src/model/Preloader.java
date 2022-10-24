package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Preloader {
    HashMap<String, List<String>> parts = new HashMap<>();

    public static void main(String[] args) {
        Preloader parse = new Preloader();
        parse.parser();
    }

    void parser() {

        this.parts.put("hdd", Arrays.asList(hardDrv.split("\n")));
        this.parts.put("ssd", Arrays.asList(diskSsd.split("\n")));
        this.parts.put("cpu", Arrays.asList(processor.split("\n")));
        this.parts.put("ram", Arrays.asList(memory.split("\n")));
        this.parts.put("chassis", Arrays.asList(box.split("\n")));
        this.parts.put("vCard", Arrays.asList(videoC.split("\n")));
        this.parts.put("powerSupply", Arrays.asList(powerSup.split("\n")));
        this.parts.put("mainBoard", Arrays.asList(mainB.split("\n")));
    }


    String mainB = "" +
            "Asus;H97-PRO;1150;iH97;DDR3;ATX\n" +
            "Asus;Z97-PRO;1150;iZ97;DDR3;ATX\n" +
            "ASUS;B85M-E;1150;B85;DDR3;microATX\n" +
            "ASUS;B85M-G;1150;B85;DDR3;mATX\n" +
            "ASUS;B85-PLUS;1150;B85;DDR3;ATX\n" +
            "ASUS;H81M-A;1150;H81;DDR3;mATX\n" +
            "ASUS;M5A78L-M LX3;AM3+;AMD 760G;DDR3;mATX\n" +
            "ASUS;SABERTOOTH 990FX R2.0;AM3+;AMD 990FX;DDR3;ATX\n" +
            "Biostar;A780L3B;AM3;HT5.2GT/s;DDR3;Micro ATX\n" +
            "ASUS;M5A97 R2.0;AM3+;AMD 970;DDR3;ATX\n" +
            "MSI;H61I-E35/W8;1155;Intel H61 B3;DDR3;Mini-ITX\n" +
            "EliteGroup (ECS);H61H2-I2 (B3);1155;H61;DDR3;miniITX\n" +
            "ASUS;X79-DELUXE;2011;Intel X79;DDR3;ATX\n" +
            "Intel;BLKDQ77KB;1155;Intel Q77;DDR3;Thin Mini-ITX\n";

    String processor = "" +
            "AMD;Phenom II X4 925;AM3\n" +
            "AMD;Athlon II X2 220;Socket AM3\n" +
            "AMD;Phenom II X4 Deneb 945;AM3\n" +
            "AMD;Phenom X4 FX-4350;AM3+;(FD4350FRW4KHK) (4.2/5200/8Mb) OEM\n" +
            "AMD;Athlon II X3 455;AM3;(3.30ГГц, 3x512КБ, HT2000МГц) (96506)\n" +
            "AMD;FX-8120;AM3;(3.10ГГц, 4x2048КБ+8МБ, HT2000МГц)oem\n" +
            "INTEL;Core i7 4960X;2011;BX80633I74960X 3.60/15M Box\n" +
            "Intel;Core i5 4570;1150;(3.2GHz) 6MB OEM (SR14E)\n" +
            "INTEL;Core i7 4960X;2011;CM8063301292500 3.60/15M Tray\n" +
            "Intel;Core i3-3240;1155;(3.40ГГц, 2x256КБ+3МБ, EM64T, GPU) (109600)";

    String memory = "" +
            "4GB;DDR2;Kingston for HP/Compaq (375004-B21) DIMM (PC-3200) 400MHz ECC Registered Dual Rank Kit (2 x 2Gb) (KTH-MLG4/4G)\n" +
            "2GB;DDR2;Kingston DIMM (PC-3200) 400MHz ECC Registered Dual Rank Kit (2 x 2Gb) (KTH-MLG4/4G)\n" +
            "16GB;DDR3;(1x16GB) 2Rx4 PC3L-10600R-9 Low Voltage Registered DIMM for DL360p/380pGen8, ML350pGen8, BL460cGen8, SL230s/250sGen8 (647901-B21)\n" +
            "16GB;DDR3;(1x16GB) 2Rx4 PC3-12800R-11 Registered DIMM for DL360p/380pGen8, ML350pGen8, BL460cGen8, SL230sGen8 (672631-B21)\n" +
            "4GB;DDR3;IBM (1x4GB, 1Rx4, 1.35V) PC3L-10600 CL9 ECC 1333MHz VLP RDIMM (HS22/HS22V) (46C0563)\n" +
            "8GB;DDR3;IBM (1x8GB 2Rx4 1.5V) PC3-12800 CL11 ECC 1600MHz LP RDIMM (x3550 M4/x3650 M4) (90Y3109)\n" +
            "1GB;DDR3;IBM (fake module) PC3-800\n" +
            "4GB;DDR3;(1x4GB) 1Rx4 PC3L-10600R-9 Low Voltage Registered DIMM for DL360p/380pGen8, ML350pGen8, BL460cGen8, SL230s/250sGen8 (647893-B21)";

    String diskSsd = "" +
            "120ГБ;2.5 Intel 530 SSDSC2BW120A4K5 (SATA III)\n" +
            "500ГБ;2.5 Samsung 840 EVO MZ-7TE500BW (SATA III)\n" +
            "512ГБ;2.5 Samsung 840 PRO MZ-7PD512BW (SATA III)\n" +
            "128ГБ;2.5 Samsung 840 PRO MZ-7PD128BW (SATA III)\n" +
            "80 Gb;SATA 6Gb/s Intel 530 Series SSDSC2BW080A401 2.5 MLC\n" +
            "240Gb;Crucial Original SATA-III CT240M500SSD1 2.5 w175Mb/s\n" +
            "120ГБ;2.5 Kingston SSDNow V300 SV300S3N7A/120G (SATA III)\n" +
            "256Gb;Sandisk SATA-III SDSSDP-256G-G25 2.5 w350Mb/s r490Mb/s\n" +
            "120Gb;OCZ Original SATA-III VTR150-25SAT3-120G Vector 150 2.5\n" +
            "128Gb;Crucial SATA-III CT128M550SSD1 M550 2.5 w500Mb/s r550Mb/s";

    String hardDrv = "" +
            "1TB;HP 2,5(SFF) SATA 7.2K 3G Pluggable Midline HDD (For SAS Models servers and storage systems) (625609-B21)\n" +
            "1TB;HP 3.5(LFF) SATA 7,2k 6G Pluggable w Smart Drive SC Midline (for HP Proliant Gen8 servers) (657750-B21)\n" +
            "1TB;3.5(LFF) SAS 7,2K 6G HotPlug w Smart Drive SC Midline (for HP Proliant Gen8 servers)(652753-B21)\n" +
            "500GB;HP 3.5(LFF) SATA 7,2k 6G Pluggable w Smart Drive SC Midline (for HP Proliant Gen8 servers) (658071-B21)\n" +
            "1TB;HDD SATA 6Gb/s 7200 HDD (Z210) (LQ037AA)\n" +
            "500GB;HDD SATA 6Gb/s 7200 HDD (Z210) (LQ036AA)";


    String videoC = "" +
            "PNY Quadro 2000D 1GB PCIE 2xDVI Retail\n" +
            "PNY Quadro K2000D 2GB PCIE 2xDP DVI OEM\n" +
            "Point Of View GT640 1GB (F-V640-1024B) OEM\n" +
            "ASUS GTX760-DC2-2GD5 // GTX760,2DVI,HDMI,DP\n" +
            "PNY Quadro K4000 3GB PCIE 2xDP DVI-I Stereo\n" +
            "ASUS STRIX-GTX970-DC2OC-4GD5, (DVI*2,HDMI,DP)";

    String powerSup = "" +
            "600W;FSP;ATX 600PNR 20+4pin, 120mm fan, I/O Switch, 6*SATA\n" +
            "700W;FSP;ATX Epsilon 85+ 24+8 pin, APFC, 120mm fan, 6*SATA\n" +
            "620W;3Y;YH6621-1BAR 2U Redundant EPS (YH-6621B) (9YR6200300)\n" +
            "400W;FSP;FSP400-60TOFD PC,ATX V2.3,EPS V2.92(80+ GOLD), FANLESS\n" +
            "400W;FSP;ATX 400PNF 12V (24pin) 120mm fan rev2.0 W/P4  I/O Switch W/SATA (47021)\n" +
            "700W;FSP;ATX Everest 85+ 24+8 pin, APFC, 120mm fan, Cable Management RTL\n" +
            "800W;Fake;ATX, APFC, 120mm fan, Cable Management OEM\n" +
            "900W;Fake;ATX, APFC, 120mm fan, Cable Management OEM";

    String box = "" +
            "Midi Tower;InWin;EC022Black 450W USB+Audio ATX (6020428)\n" +
            "Midi Tower;InWin;EC022Black No Power Supply USB+Audio ATX (6020428)\n" +
            "Midi Tower;InWin;EC027Black 450W USB+Audio ATX (6026950)\n" +
            "Midi Tower;InWin;EC027Black No Power Supply USB+Audio ATX (6026950)\n" +
            "Mini Tower;InWin;ENR027 Black RB-S400T70 No Power Supply 2*USB+AirDuct+Audio mATX\n" +
            "Full Tower;InWin;BX141 BLack 600W U2AF4+U3.0 GRONE (6102963)\n" +
            "Full Tower;InWin;BX141 BLack No Power Supply U2AF4+U3.0 GRONE (6102963)";

}
