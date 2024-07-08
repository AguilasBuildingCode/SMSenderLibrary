package com.apisap.smsender.countries

sealed class CountriesCodes(val country: String, val code: String) {
    data object AF : CountriesCodes("Afghanistan", "93")
    data object AL : CountriesCodes("Albania", "355")
    data object DZ : CountriesCodes("Algeria", "213")
    data object AS : CountriesCodes("American Samoa", "1684")
    data object AD : CountriesCodes("Andorra", "376")
    data object AO : CountriesCodes("Angola", "244")
    data object AI : CountriesCodes("Anguilla", "1264")
    data object AQ : CountriesCodes("Antarctica", "672")
    data object AG : CountriesCodes("Antigua and Barbuda", "1268")
    data object AR : CountriesCodes("Argentina", "54")
    data object AM : CountriesCodes("Armenia", "374")
    data object AW : CountriesCodes("Aruba", "297")
    data object AU : CountriesCodes("Australia", "61")
    data object AT : CountriesCodes("Austria", "43")
    data object AZ : CountriesCodes("Azerbaijan", "994")
    data object BS : CountriesCodes("Bahamas", "1242")
    data object BH : CountriesCodes("Bahrain", "973")
    data object BD : CountriesCodes("Bangladesh", "880")
    data object BB : CountriesCodes("Barbados", "1246")
    data object BY : CountriesCodes("Belarus", "375")
    data object BE : CountriesCodes("Belgium", "32")
    data object BZ : CountriesCodes("Belize", "501")
    data object BJ : CountriesCodes("Benin", "229")
    data object BM : CountriesCodes("Bermuda", "1441")
    data object BT : CountriesCodes("Bhutan", "975")
    data object BO : CountriesCodes("Bolivia", "591")
    data object BA : CountriesCodes("Bosnia and Herzegovina", "387")
    data object BW : CountriesCodes("Botswana", "267")
    data object BR : CountriesCodes("Brazil", "55")
    data object IO : CountriesCodes("British Indian Ocean Territory", "246")
    data object VG : CountriesCodes("British Virgin Islands", "1284")
    data object BN : CountriesCodes("Brunei", "673")
    data object BG : CountriesCodes("Bulgaria", "359")
    data object BF : CountriesCodes("Burkina Faso", "226")
    data object MM : CountriesCodes("Myanmar", "95")
    data object BI : CountriesCodes("Burundi", "257")
    data object KH : CountriesCodes("Cambodia", "855")
    data object CM : CountriesCodes("Cameroon", "237")
    data object CA : CountriesCodes("Canada", "1")
    data object CV : CountriesCodes("Cape Verde", "238")
    data object KY : CountriesCodes("Cayman Islands", "1345")
    data object CF : CountriesCodes("Central African Republic", "236")
    data object TD : CountriesCodes("Chad", "235")
    data object CL : CountriesCodes("Chile", "56")
    data object CN : CountriesCodes("China", "86")
    data object CX : CountriesCodes("Christmas Island", "61")
    data object CC : CountriesCodes("Cocos Islands", "61")
    data object CO : CountriesCodes("Colombia", "57")
    data object KM : CountriesCodes("Comoros", "269")
    data object CG : CountriesCodes("Republic of the Congo", "242")
    data object CD : CountriesCodes("Democratic Republic of the Congo", "243")
    data object CK : CountriesCodes("Cook Islands", "682")
    data object CR : CountriesCodes("Costa Rica", "506")
    data object HR : CountriesCodes("Croatia", "385")
    data object CU : CountriesCodes("Cuba", "53")
    data object CW : CountriesCodes("Curacao", "599")
    data object CY : CountriesCodes("Cyprus", "357")
    data object CZ : CountriesCodes("Czech Republic", "420")
    data object DK : CountriesCodes("Denmark", "45")
    data object DJ : CountriesCodes("Djibouti", "253")
    data object DM : CountriesCodes("Dominica", "1767")
    data object DO809 : CountriesCodes("Dominican Republic", "1809")
    data object DO829 : CountriesCodes("Dominican Republic", "1829")
    data object DO849 : CountriesCodes("Dominican Republic", "1849")
    data object TL : CountriesCodes("East Timor", "670")
    data object EC : CountriesCodes("Ecuador", "593")
    data object EG : CountriesCodes("Egypt", "20")
    data object SV : CountriesCodes("El Salvador", "503")
    data object GQ : CountriesCodes("Equatorial Guinea", "240")
    data object ER : CountriesCodes("Eritrea", "291")
    data object EE : CountriesCodes("Estonia", "372")
    data object ET : CountriesCodes("Ethiopia", "251")
    data object FK : CountriesCodes("Falkland Islands", "500")
    data object FO : CountriesCodes("Faroe Islands", "298")
    data object FJ : CountriesCodes("Fiji", "679")
    data object FI : CountriesCodes("Finland", "358")
    data object FR : CountriesCodes("France", "33")
    data object PF : CountriesCodes("French Polynesia", "689")
    data object GA : CountriesCodes("Gabon", "241")
    data object GM : CountriesCodes("Gambia", "220")
    data object GE : CountriesCodes("Georgia", "995")
    data object DE : CountriesCodes("Germany", "49")
    data object GH : CountriesCodes("Ghana", "233")
    data object GI : CountriesCodes("Gibraltar", "350")
    data object GR : CountriesCodes("Greece", "30")
    data object GL : CountriesCodes("Greenland", "299")
    data object GD : CountriesCodes("Grenada", "1473")
    data object GU : CountriesCodes("Guam", "1671")
    data object GT : CountriesCodes("Guatemala", "502")
    data object GG : CountriesCodes("Guernsey", "441481")
    data object GN : CountriesCodes("Guinea", "224")
    data object GW : CountriesCodes("Guinea-Bissau", "245")
    data object GY : CountriesCodes("Guyana", "592")
    data object HT : CountriesCodes("Haiti", "509")
    data object HN : CountriesCodes("Honduras", "504")
    data object HK : CountriesCodes("Hong Kong", "852")
    data object HU : CountriesCodes("Hungary", "36")
    data object IS : CountriesCodes("Iceland", "354")
    data object IN : CountriesCodes("India", "91")
    data object ID : CountriesCodes("Indonesia", "62")
    data object IR : CountriesCodes("Iran", "98")
    data object IQ : CountriesCodes("Iraq", "964")
    data object IE : CountriesCodes("Ireland", "353")
    data object IM : CountriesCodes("Isle of Man", "441624")
    data object IL : CountriesCodes("Israel", "972")
    data object IT : CountriesCodes("Italy", "39")
    data object CI : CountriesCodes("Ivory Coast", "225")
    data object JM : CountriesCodes("Jamaica", "1876")
    data object JP : CountriesCodes("Japan", "81")
    data object JE : CountriesCodes("Jersey", "441534")
    data object JO : CountriesCodes("Jordan", "962")
    data object KZ : CountriesCodes("Kazakhstan", "7")
    data object KE : CountriesCodes("Kenya", "254")
    data object KI : CountriesCodes("Kiribati", "686")
    data object XK : CountriesCodes("Kosovo", "383")
    data object KW : CountriesCodes("Kuwait", "965")
    data object KG : CountriesCodes("Kyrgyzstan", "996")
    data object LA : CountriesCodes("Laos", "856")
    data object LV : CountriesCodes("Latvia", "371")
    data object LB : CountriesCodes("Lebanon", "961")
    data object LS : CountriesCodes("Lesotho", "266")
    data object LR : CountriesCodes("Liberia", "231")
    data object LY : CountriesCodes("Libya", "218")
    data object LI : CountriesCodes("Liechtenstein", "423")
    data object LT : CountriesCodes("Lithuania", "370")
    data object LU : CountriesCodes("Luxembourg", "352")
    data object MO : CountriesCodes("Macau", "853")
    data object MK : CountriesCodes("Macedonia", "389")
    data object MG : CountriesCodes("Madagascar", "261")
    data object MW : CountriesCodes("Malawi", "265")
    data object MY : CountriesCodes("Malaysia", "60")
    data object MV : CountriesCodes("Maldives", "960")
    data object ML : CountriesCodes("Mali", "223")
    data object MT : CountriesCodes("Malta", "356")
    data object MH : CountriesCodes("Marshall Islands", "692")
    data object MR : CountriesCodes("Mauritania", "222")
    data object MU : CountriesCodes("Mauritius", "230")
    data object YT : CountriesCodes("Mayotte", "262")
    data object MX : CountriesCodes("Mexico", "52")
    data object FM : CountriesCodes("Micronesia", "691")
    data object MD : CountriesCodes("Moldova", "373")
    data object MC : CountriesCodes("Monaco", "377")
    data object MN : CountriesCodes("Mongolia", "976")
    data object ME : CountriesCodes("Montenegro", "382")
    data object MS : CountriesCodes("Montserrat", "1664")
    data object MA : CountriesCodes("Morocco", "212")
    data object MZ : CountriesCodes("Mozambique", "258")
    data object NA : CountriesCodes("Namibia", "264")
    data object NR : CountriesCodes("Nauru", "674")
    data object NP : CountriesCodes("Nepal", "977")
    data object NL : CountriesCodes("Netherlands", "31")
    data object AN : CountriesCodes("Netherlands Antilles", "599")
    data object NC : CountriesCodes("New Caledonia", "687")
    data object NZ : CountriesCodes("New Zealand", "64")
    data object NI : CountriesCodes("Nicaragua", "505")
    data object NE : CountriesCodes("Niger", "227")
    data object NG : CountriesCodes("Nigeria", "234")
    data object NU : CountriesCodes("Niue", "683")
    data object MP : CountriesCodes("Northern Mariana Islands", "1670")
    data object KP : CountriesCodes("North Korea", "850")
    data object NO : CountriesCodes("Norway", "47")
    data object OM : CountriesCodes("Oman", "968")
    data object PK : CountriesCodes("Pakistan", "92")
    data object PW : CountriesCodes("Palau", "680")
    data object PS : CountriesCodes("Palestine", "970")
    data object PA : CountriesCodes("Panama", "507")
    data object PG : CountriesCodes("Papua New Guinea", "675")
    data object PY : CountriesCodes("Paraguay", "595")
    data object PE : CountriesCodes("Peru", "51")
    data object PH : CountriesCodes("Philippines", "63")
    data object PN : CountriesCodes("Pitcairn", "64")
    data object PL : CountriesCodes("Poland", "48")
    data object PT : CountriesCodes("Portugal", "351")
    data object PR787 : CountriesCodes("Puerto Rico", "1787")
    data object PR939 : CountriesCodes("Puerto Rico", "1939")
    data object QA : CountriesCodes("Qatar", "974")
    data object RE : CountriesCodes("Reunion", "262")
    data object RO : CountriesCodes("Romania", "40")
    data object RU : CountriesCodes("Russia", "7")
    data object RW : CountriesCodes("Rwanda", "250")
    data object BL : CountriesCodes("Saint Barthelemy", "590")
    data object WS : CountriesCodes("Samoa", "685")
    data object SM : CountriesCodes("San Marino", "378")
    data object ST : CountriesCodes("Sao Tome and Principe", "239")
    data object SA : CountriesCodes("Saudi Arabia", "966")
    data object SN : CountriesCodes("Senegal", "221")
    data object RS : CountriesCodes("Serbia", "381")
    data object SC : CountriesCodes("Seychelles", "248")
    data object SL : CountriesCodes("Sierra Leone", "232")
    data object SG : CountriesCodes("Singapore", "65")
    data object SX : CountriesCodes("Sint Maarten", "1721")
    data object SK : CountriesCodes("Slovakia", "421")
    data object SI : CountriesCodes("Slovenia", "386")
    data object SB : CountriesCodes("Solomon Islands", "677")
    data object SO : CountriesCodes("Somalia", "252")
    data object ZA : CountriesCodes("South Africa", "27")
    data object KR : CountriesCodes("South Korea", "82")
    data object SS : CountriesCodes("South Sudan", "211")
    data object ES : CountriesCodes("Spain", "34")
    data object LK : CountriesCodes("Sri Lanka", "94")
    data object SH : CountriesCodes("Saint Helena", "290")
    data object KN : CountriesCodes("Saint Kitts and Nevis", "1869")
    data object LC : CountriesCodes("Saint Lucia", "1758")
    data object MF : CountriesCodes("Saint Martin", "590")
    data object PM : CountriesCodes("Saint Pierre and Miquelon", "508")
    data object VC : CountriesCodes("Saint Vincent and the Grenadines", "1784")
    data object SD : CountriesCodes("Sudan", "249")
    data object SR : CountriesCodes("Suriname", "597")
    data object SJ : CountriesCodes("Svalbard and Jan Mayen", "47")
    data object SZ : CountriesCodes("Swaziland", "268")
    data object SE : CountriesCodes("Sweden", "46")
    data object CH : CountriesCodes("Switzerland", "41")
    data object SY : CountriesCodes("Syria", "963")
    data object TW : CountriesCodes("Taiwan", "886")
    data object TJ : CountriesCodes("Tajikistan", "992")
    data object TZ : CountriesCodes("Tanzania", "255")
    data object TH : CountriesCodes("Thailand", "66")
    data object TG : CountriesCodes("Togo", "228")
    data object TK : CountriesCodes("Tokelau", "690")
    data object TO : CountriesCodes("Tonga", "676")
    data object TT : CountriesCodes("Trinidad and Tobago", "1868")
    data object TN : CountriesCodes("Tunisia", "216")
    data object TR : CountriesCodes("Turkey", "90")
    data object TM : CountriesCodes("Turkmenistan", "993")
    data object TC : CountriesCodes("Turks and Caicos Islands", "1649")
    data object TV : CountriesCodes("Tuvalu", "688")
    data object AE : CountriesCodes("United Arab Emirates", "971")
    data object UG : CountriesCodes("Uganda", "256")
    data object GB : CountriesCodes("United Kingdom ", "44")
    data object UA : CountriesCodes("Ukraine", "380")
    data object UY : CountriesCodes("Uruguay", "598")
    data object US : CountriesCodes("United States", "1")
    data object UZ : CountriesCodes("Uzbekistan", "998")
    data object VU : CountriesCodes("Vanuatu", "678")
    data object VA : CountriesCodes("Vatican", "379")
    data object VE : CountriesCodes("Venezuela", "58")
    data object VN : CountriesCodes("Vietnam", "84")
    data object VI : CountriesCodes("U.S. Virgin Islands", "1340")
    data object WF : CountriesCodes("Wallis and Futuna", "681")
    data object EH : CountriesCodes("Western Sahara", "212")
    data object YE : CountriesCodes("Yemen", "967")
    data object ZM : CountriesCodes("Zambia", "260")
    data object ZW : CountriesCodes("Zimbabwe", "263")
    companion object {
        fun values(): Array<CountriesCodes> {
            return arrayOf(
                AF,
                AL,
                DZ,
                AS,
                AD,
                AO,
                AI,
                AQ,
                AG,
                AR,
                AM,
                AW,
                AU,
                AT,
                AZ,
                BS,
                BH,
                BD,
                BB,
                BY,
                BE,
                BZ,
                BJ,
                BM,
                BT,
                BO,
                BA,
                BW,
                BR,
                IO,
                VG,
                BN,
                BG,
                BF,
                MM,
                BI,
                KH,
                CM,
                CA,
                CV,
                KY,
                CF,
                TD,
                CL,
                CN,
                CX,
                CC,
                CO,
                KM,
                CG,
                CD,
                CK,
                CR,
                HR,
                CU,
                CW,
                CY,
                CZ,
                DK,
                DJ,
                DM,
                DO809,
                DO829,
                DO849,
                TL,
                EC,
                EG,
                SV,
                GQ,
                ER,
                EE,
                ET,
                FK,
                FO,
                FJ,
                FI,
                FR,
                PF,
                GA,
                GM,
                GE,
                DE,
                GH,
                GI,
                GR,
                GL,
                GD,
                GU,
                GT,
                GG,
                GN,
                GW,
                GY,
                HT,
                HN,
                HK,
                HU,
                IS,
                IN,
                ID,
                IR,
                IQ,
                IE,
                IM,
                IL,
                IT,
                CI,
                JM,
                JP,
                JE,
                JO,
                KZ,
                KE,
                KI,
                XK,
                KW,
                KG,
                LA,
                LV,
                LB,
                LS,
                LR,
                LY,
                LI,
                LT,
                LU,
                MO,
                MK,
                MG,
                MW,
                MY,
                MV,
                ML,
                MT,
                MH,
                MR,
                MU,
                YT,
                MX,
                FM,
                MD,
                MC,
                MN,
                ME,
                MS,
                MA,
                MZ,
                NA,
                NR,
                NP,
                NL,
                AN,
                NC,
                NZ,
                NI,
                NE,
                NG,
                NU,
                MP,
                KP,
                NO,
                OM,
                PK,
                PW,
                PS,
                PA,
                PG,
                PY,
                PE,
                PH,
                PN,
                PL,
                PT,
                PR787,
                PR939,
                QA,
                RE,
                RO,
                RU,
                RW,
                BL,
                WS,
                SM,
                ST,
                SA,
                SN,
                RS,
                SC,
                SL,
                SG,
                SX,
                SK,
                SI,
                SB,
                SO,
                ZA,
                KR,
                SS,
                ES,
                LK,
                SH,
                KN,
                LC,
                MF,
                PM,
                VC,
                SD,
                SR,
                SJ,
                SZ,
                SE,
                CH,
                SY,
                TW,
                TJ,
                TZ,
                TH,
                TG,
                TK,
                TO,
                TT,
                TN,
                TR,
                TM,
                TC,
                TV,
                AE,
                UG,
                GB,
                UA,
                UY,
                US,
                UZ,
                VU,
                VA,
                VE,
                VN,
                VI,
                WF,
                EH,
                YE,
                ZM,
                ZW
            )
        }

        fun valueOf(value: String): CountriesCodes {
            return when (value) {
                "AF" -> AF
                "AL" -> AL
                "DZ" -> DZ
                "AS" -> AS
                "AD" -> AD
                "AO" -> AO
                "AI" -> AI
                "AQ" -> AQ
                "AG" -> AG
                "AR" -> AR
                "AM" -> AM
                "AW" -> AW
                "AU" -> AU
                "AT" -> AT
                "AZ" -> AZ
                "BS" -> BS
                "BH" -> BH
                "BD" -> BD
                "BB" -> BB
                "BY" -> BY
                "BE" -> BE
                "BZ" -> BZ
                "BJ" -> BJ
                "BM" -> BM
                "BT" -> BT
                "BO" -> BO
                "BA" -> BA
                "BW" -> BW
                "BR" -> BR
                "IO" -> IO
                "VG" -> VG
                "BN" -> BN
                "BG" -> BG
                "BF" -> BF
                "MM" -> MM
                "BI" -> BI
                "KH" -> KH
                "CM" -> CM
                "CA" -> CA
                "CV" -> CV
                "KY" -> KY
                "CF" -> CF
                "TD" -> TD
                "CL" -> CL
                "CN" -> CN
                "CX" -> CX
                "CC" -> CC
                "CO" -> CO
                "KM" -> KM
                "CG" -> CG
                "CD" -> CD
                "CK" -> CK
                "CR" -> CR
                "HR" -> HR
                "CU" -> CU
                "CW" -> CW
                "CY" -> CY
                "CZ" -> CZ
                "DK" -> DK
                "DJ" -> DJ
                "DM" -> DM
                "DO809" -> DO809
                "DO829" -> DO829
                "DO849" -> DO849
                "TL" -> TL
                "EC" -> EC
                "EG" -> EG
                "SV" -> SV
                "GQ" -> GQ
                "ER" -> ER
                "EE" -> EE
                "ET" -> ET
                "FK" -> FK
                "FO" -> FO
                "FJ" -> FJ
                "FI" -> FI
                "FR" -> FR
                "PF" -> PF
                "GA" -> GA
                "GM" -> GM
                "GE" -> GE
                "DE" -> DE
                "GH" -> GH
                "GI" -> GI
                "GR" -> GR
                "GL" -> GL
                "GD" -> GD
                "GU" -> GU
                "GT" -> GT
                "GG" -> GG
                "GN" -> GN
                "GW" -> GW
                "GY" -> GY
                "HT" -> HT
                "HN" -> HN
                "HK" -> HK
                "HU" -> HU
                "IS" -> IS
                "IN" -> IN
                "ID" -> ID
                "IR" -> IR
                "IQ" -> IQ
                "IE" -> IE
                "IM" -> IM
                "IL" -> IL
                "IT" -> IT
                "CI" -> CI
                "JM" -> JM
                "JP" -> JP
                "JE" -> JE
                "JO" -> JO
                "KZ" -> KZ
                "KE" -> KE
                "KI" -> KI
                "XK" -> XK
                "KW" -> KW
                "KG" -> KG
                "LA" -> LA
                "LV" -> LV
                "LB" -> LB
                "LS" -> LS
                "LR" -> LR
                "LY" -> LY
                "LI" -> LI
                "LT" -> LT
                "LU" -> LU
                "MO" -> MO
                "MK" -> MK
                "MG" -> MG
                "MW" -> MW
                "MY" -> MY
                "MV" -> MV
                "ML" -> ML
                "MT" -> MT
                "MH" -> MH
                "MR" -> MR
                "MU" -> MU
                "YT" -> YT
                "MX" -> MX
                "FM" -> FM
                "MD" -> MD
                "MC" -> MC
                "MN" -> MN
                "ME" -> ME
                "MS" -> MS
                "MA" -> MA
                "MZ" -> MZ
                "NA" -> NA
                "NR" -> NR
                "NP" -> NP
                "NL" -> NL
                "AN" -> AN
                "NC" -> NC
                "NZ" -> NZ
                "NI" -> NI
                "NE" -> NE
                "NG" -> NG
                "NU" -> NU
                "MP" -> MP
                "KP" -> KP
                "NO" -> NO
                "OM" -> OM
                "PK" -> PK
                "PW" -> PW
                "PS" -> PS
                "PA" -> PA
                "PG" -> PG
                "PY" -> PY
                "PE" -> PE
                "PH" -> PH
                "PN" -> PN
                "PL" -> PL
                "PT" -> PT
                "PR787" -> PR787
                "PR939" -> PR939
                "QA" -> QA
                "RE" -> RE
                "RO" -> RO
                "RU" -> RU
                "RW" -> RW
                "BL" -> BL
                "WS" -> WS
                "SM" -> SM
                "ST" -> ST
                "SA" -> SA
                "SN" -> SN
                "RS" -> RS
                "SC" -> SC
                "SL" -> SL
                "SG" -> SG
                "SX" -> SX
                "SK" -> SK
                "SI" -> SI
                "SB" -> SB
                "SO" -> SO
                "ZA" -> ZA
                "KR" -> KR
                "SS" -> SS
                "ES" -> ES
                "LK" -> LK
                "SH" -> SH
                "KN" -> KN
                "LC" -> LC
                "MF" -> MF
                "PM" -> PM
                "VC" -> VC
                "SD" -> SD
                "SR" -> SR
                "SJ" -> SJ
                "SZ" -> SZ
                "SE" -> SE
                "CH" -> CH
                "SY" -> SY
                "TW" -> TW
                "TJ" -> TJ
                "TZ" -> TZ
                "TH" -> TH
                "TG" -> TG
                "TK" -> TK
                "TO" -> TO
                "TT" -> TT
                "TN" -> TN
                "TR" -> TR
                "TM" -> TM
                "TC" -> TC
                "TV" -> TV
                "AE" -> AE
                "UG" -> UG
                "GB" -> GB
                "UA" -> UA
                "UY" -> UY
                "US" -> US
                "UZ" -> UZ
                "VU" -> VU
                "VA" -> VA
                "VE" -> VE
                "VN" -> VN
                "VI" -> VI
                "WF" -> WF
                "EH" -> EH
                "YE" -> YE
                "ZM" -> ZM
                "ZW" -> ZW
                else -> throw IllegalArgumentException("No object com.apisap.smsender.countries.CountriesCodes.$value")
            }
        }
    }

}