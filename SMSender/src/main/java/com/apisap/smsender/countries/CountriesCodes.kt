package com.apisap.smsender.countries

/**
 * [CountriesCodes] define all possible Countries Codes. Usually you can find out your country with
 * two letters (XX), however, many Countries has two or more codes.
 *
 * One code:
 * * Mexico [MX]
 * * [...]
 *
 * Two or more:
 * * Dominican Republic [DO809]
 * * Dominican Republic [DO829]
 * * Dominican Republic [DO849]
 *
 * * Puerto Rico [PR787]
 * * Puerto Rico [PR939]
 */
sealed class CountriesCodes(val country: String, val code: String) {

    /**
     * [AF] Country: "Afghanistan", code: 93
     */
    data object AF : CountriesCodes("Afghanistan", "93")

    /**
     * [AL] Country: "Albania", code: 355
     */
    data object AL : CountriesCodes("Albania", "355")

    /**
     * [DZ] Country: "Algeria", code: 213
     */
    data object DZ : CountriesCodes("Algeria", "213")

    /**
     * [AS] Country: "American Samoa", code: 1684
     */
    data object AS : CountriesCodes("American Samoa", "1684")

    /**
     * [AD] Country: "Andorra", code: 376
     */
    data object AD : CountriesCodes("Andorra", "376")

    /**
     * [AO] Country: "Angola", code: 244
     */
    data object AO : CountriesCodes("Angola", "244")

    /**
     * [AI] Country: "Anguilla", code: 1264
     */
    data object AI : CountriesCodes("Anguilla", "1264")

    /**
     * [AQ] Country: "Antarctica", code: 672
     */
    data object AQ : CountriesCodes("Antarctica", "672")

    /**
     * [AG] Country: "Antigua and Barbuda", code: 1268
     */
    data object AG : CountriesCodes("Antigua and Barbuda", "1268")

    /**
     * [AR] Country: "Argentina", code: 54
     */
    data object AR : CountriesCodes("Argentina", "54")

    /**
     * [AM] Country: "Armenia", code: 374
     */
    data object AM : CountriesCodes("Armenia", "374")

    /**
     * [AW] Country: "Aruba", code: 297
     */
    data object AW : CountriesCodes("Aruba", "297")

    /**
     * [AU] Country: "Australia", code: 61
     */
    data object AU : CountriesCodes("Australia", "61")

    /**
     * [AT] Country: "Austria", code: 43
     */
    data object AT : CountriesCodes("Austria", "43")

    /**
     * [AZ] Country: "Azerbaijan", code: 994
     */
    data object AZ : CountriesCodes("Azerbaijan", "994")

    /**
     * [BS] Country: "Bahamas", code: 1242
     */
    data object BS : CountriesCodes("Bahamas", "1242")

    /**
     * [BH] Country: "Bahrain", code: 973
     */
    data object BH : CountriesCodes("Bahrain", "973")

    /**
     * [BD] Country: "Bangladesh", code: 880
     */
    data object BD : CountriesCodes("Bangladesh", "880")

    /**
     * [BB] Country: "Barbados", code: 1246
     */
    data object BB : CountriesCodes("Barbados", "1246")

    /**
     * [BY] Country: "Belarus", code: 375
     */
    data object BY : CountriesCodes("Belarus", "375")

    /**
     * [BE] Country: "Belgium", code: 32
     */
    data object BE : CountriesCodes("Belgium", "32")

    /**
     * [BZ] Country: "Belize", code: 501
     */
    data object BZ : CountriesCodes("Belize", "501")

    /**
     * [BJ] Country: "Benin", code: 229
     */
    data object BJ : CountriesCodes("Benin", "229")

    /**
     * [BM] Country: "Bermuda", code: 1441
     */
    data object BM : CountriesCodes("Bermuda", "1441")

    /**
     * [BT] Country: "Bhutan", code: 975
     */
    data object BT : CountriesCodes("Bhutan", "975")

    /**
     * [BO] Country: "Bolivia", code: 591
     */
    data object BO : CountriesCodes("Bolivia", "591")

    /**
     * [BA] Country: "Bosnia and Herzegovina", code: 387
     */
    data object BA : CountriesCodes("Bosnia and Herzegovina", "387")

    /**
     * [BW] Country: "Botswana", code: 267
     */
    data object BW : CountriesCodes("Botswana", "267")

    /**
     * [BR] Country: "Brazil", code: 55
     */
    data object BR : CountriesCodes("Brazil", "55")

    /**
     * [IO] Country: "British Indian Ocean Territory", code: 246
     */
    data object IO : CountriesCodes("British Indian Ocean Territory", "246")

    /**
     * [VG] Country: "British Virgin Islands", code: 1284
     */
    data object VG : CountriesCodes("British Virgin Islands", "1284")

    /**
     * [BN] Country: "Brunei", code: 673
     */
    data object BN : CountriesCodes("Brunei", "673")

    /**
     * [BG] Country: "Bulgaria", code: 359
     */
    data object BG : CountriesCodes("Bulgaria", "359")

    /**
     * [BF] Country: "Burkina Faso", code: 226
     */
    data object BF : CountriesCodes("Burkina Faso", "226")

    /**
     * [MM] Country: "Myanmar", code: 95
     */
    data object MM : CountriesCodes("Myanmar", "95")

    /**
     * [BI] Country: "Burundi", code: 257
     */
    data object BI : CountriesCodes("Burundi", "257")

    /**
     * [KH] Country: "Cambodia", code: 855
     */
    data object KH : CountriesCodes("Cambodia", "855")

    /**
     * [CM] Country: "Cameroon", code: 237
     */
    data object CM : CountriesCodes("Cameroon", "237")

    /**
     * [CA] Country: "Canada", code: 1
     */
    data object CA : CountriesCodes("Canada", "1")

    /**
     * [CV] Country: "Cape Verde", code: 238
     */
    data object CV : CountriesCodes("Cape Verde", "238")

    /**
     * [KY] Country: "Cayman Islands", code: 1345
     */
    data object KY : CountriesCodes("Cayman Islands", "1345")

    /**
     * [CF] Country: "Central African Republic", code: 236
     */
    data object CF : CountriesCodes("Central African Republic", "236")

    /**
     * [TD] Country: "Chad", code: 235
     */
    data object TD : CountriesCodes("Chad", "235")

    /**
     * [CL] Country: "Chile", code: 56
     */
    data object CL : CountriesCodes("Chile", "56")

    /**
     * [CN] Country: "China", code: 86
     */
    data object CN : CountriesCodes("China", "86")

    /**
     * [CX] Country: "Christmas Island", code: 61
     */
    data object CX : CountriesCodes("Christmas Island", "61")

    /**
     * [CC] Country: "Cocos Islands", code: 61
     */
    data object CC : CountriesCodes("Cocos Islands", "61")

    /**
     * [CO] Country: "Colombia", code: 57
     */
    data object CO : CountriesCodes("Colombia", "57")

    /**
     * [KM] Country: "Comoros", code: 269
     */
    data object KM : CountriesCodes("Comoros", "269")

    /**
     * [CG] Country: "Republic of the Congo", code: 242
     */
    data object CG : CountriesCodes("Republic of the Congo", "242")

    /**
     * [CD] Country: "Democratic Republic of the Congo", code: 243
     */
    data object CD : CountriesCodes("Democratic Republic of the Congo", "243")

    /**
     * [CK] Country: "Cook Islands", code: 682
     */
    data object CK : CountriesCodes("Cook Islands", "682")

    /**
     * [CR] Country: "Costa Rica", code: 506
     */
    data object CR : CountriesCodes("Costa Rica", "506")

    /**
     * [HR] Country: "Croatia", code: 385
     */
    data object HR : CountriesCodes("Croatia", "385")

    /**
     * [CU] Country: "Cuba", code: 53
     */
    data object CU : CountriesCodes("Cuba", "53")

    /**
     * [CW] Country: "Curacao", code: 599
     */
    data object CW : CountriesCodes("Curacao", "599")

    /**
     * [CY] Country: "Cyprus", code: 357
     */
    data object CY : CountriesCodes("Cyprus", "357")

    /**
     * [CZ] Country: "Czech Republic", code: 420
     */
    data object CZ : CountriesCodes("Czech Republic", "420")

    /**
     * [DK] Country: "Denmark", code: 45
     */
    data object DK : CountriesCodes("Denmark", "45")

    /**
     * [DJ] Country: "Djibouti", code: 253
     */
    data object DJ : CountriesCodes("Djibouti", "253")

    /**
     * [DM] Country: "Dominica", code: 1767
     */
    data object DM : CountriesCodes("Dominica", "1767")

    /**
     * [DO809] Country: "Dominican Republic", code: 1809
     */
    data object DO809 : CountriesCodes("Dominican Republic", "1809")

    /**
     * [DO829] Country: "Dominican Republic", code: 1829
     */
    data object DO829 : CountriesCodes("Dominican Republic", "1829")

    /**
     * [DO849] Country: "Dominican Republic", code: 1849
     */
    data object DO849 : CountriesCodes("Dominican Republic", "1849")

    /**
     * [TL] Country: "East Timor", code: 670
     */
    data object TL : CountriesCodes("East Timor", "670")

    /**
     * [EC] Country: "Ecuador", code: 593
     */
    data object EC : CountriesCodes("Ecuador", "593")

    /**
     * [EG] Country: "Egypt", code: 20
     */
    data object EG : CountriesCodes("Egypt", "20")

    /**
     * [SV] Country: "El Salvador", code: 503
     */
    data object SV : CountriesCodes("El Salvador", "503")

    /**
     * [GQ] Country: "Equatorial Guinea", code: 240
     */
    data object GQ : CountriesCodes("Equatorial Guinea", "240")

    /**
     * [ER] Country: "Eritrea", code: 291
     */
    data object ER : CountriesCodes("Eritrea", "291")

    /**
     * [EE] Country: "Estonia", code: 372
     */
    data object EE : CountriesCodes("Estonia", "372")

    /**
     * [ET] Country: "Ethiopia", code: 251
     */
    data object ET : CountriesCodes("Ethiopia", "251")

    /**
     * [FK] Country: "Falkland Islands", code: 500
     */
    data object FK : CountriesCodes("Falkland Islands", "500")

    /**
     * [FO] Country: "Faroe Islands", code: 298
     */
    data object FO : CountriesCodes("Faroe Islands", "298")

    /**
     * [FJ] Country: "Fiji", code: 679
     */
    data object FJ : CountriesCodes("Fiji", "679")

    /**
     * [FI] Country: "Finland", code: 358
     */
    data object FI : CountriesCodes("Finland", "358")

    /**
     * [FR] Country: "France", code: 33
     */
    data object FR : CountriesCodes("France", "33")

    /**
     * [PF] Country: "French Polynesia", code: 689
     */
    data object PF : CountriesCodes("French Polynesia", "689")

    /**
     * [GA] Country: "Gabon", code: 241
     */
    data object GA : CountriesCodes("Gabon", "241")

    /**
     * [GM] Country: "Gambia", code: 220
     */
    data object GM : CountriesCodes("Gambia", "220")

    /**
     * [GE] Country: "Georgia", code: 995
     */
    data object GE : CountriesCodes("Georgia", "995")

    /**
     * [DE] Country: "Germany", code: 49
     */
    data object DE : CountriesCodes("Germany", "49")

    /**
     * [GH] Country: "Ghana", code: 233
     */
    data object GH : CountriesCodes("Ghana", "233")

    /**
     * [GI] Country: "Gibraltar", code: 350
     */
    data object GI : CountriesCodes("Gibraltar", "350")

    /**
     * [GR] Country: "Greece", code: 30
     */
    data object GR : CountriesCodes("Greece", "30")

    /**
     * [GL] Country: "Greenland", code: 299
     */
    data object GL : CountriesCodes("Greenland", "299")

    /**
     * [GD] Country: "Grenada", code: 1473
     */
    data object GD : CountriesCodes("Grenada", "1473")

    /**
     * [GU] Country: "Guam", code: 1671
     */
    data object GU : CountriesCodes("Guam", "1671")

    /**
     * [GT] Country: "Guatemala", code: 502
     */
    data object GT : CountriesCodes("Guatemala", "502")

    /**
     * [GG] Country: "Guernsey", code: 441481
     */
    data object GG : CountriesCodes("Guernsey", "441481")

    /**
     * [GN] Country: "Guinea", code: 224
     */
    data object GN : CountriesCodes("Guinea", "224")

    /**
     * [GW] Country: "Guinea-Bissau", code: 245
     */
    data object GW : CountriesCodes("Guinea-Bissau", "245")

    /**
     * [GY] Country: "Guyana", code: 592
     */
    data object GY : CountriesCodes("Guyana", "592")

    /**
     * [HT] Country: "Haiti", code: 509
     */
    data object HT : CountriesCodes("Haiti", "509")

    /**
     * [HN] Country: "Honduras", code: 504
     */
    data object HN : CountriesCodes("Honduras", "504")

    /**
     * [HK] Country: "Hong Kong", code: 852
     */
    data object HK : CountriesCodes("Hong Kong", "852")

    /**
     * [HU] Country: "Hungary", code: 36
     */
    data object HU : CountriesCodes("Hungary", "36")

    /**
     * [IS] Country: "Iceland", code: 354
     */
    data object IS : CountriesCodes("Iceland", "354")

    /**
     * [IN] Country: "India", code: 91
     */
    data object IN : CountriesCodes("India", "91")

    /**
     * [ID] Country: "Indonesia", code: 62
     */
    data object ID : CountriesCodes("Indonesia", "62")

    /**
     * [IR] Country: "Iran", code: 98
     */
    data object IR : CountriesCodes("Iran", "98")

    /**
     * [IQ] Country: "Iraq", code: 964
     */
    data object IQ : CountriesCodes("Iraq", "964")

    /**
     * [IE] Country: "Ireland", code: 353
     */
    data object IE : CountriesCodes("Ireland", "353")

    /**
     * [IM] Country: "Isle of Man", code: 441624
     */
    data object IM : CountriesCodes("Isle of Man", "441624")

    /**
     * [IL] Country: "Israel", code: 972
     */
    data object IL : CountriesCodes("Israel", "972")

    /**
     * [IT] Country: "Italy", code: 39
     */
    data object IT : CountriesCodes("Italy", "39")

    /**
     * [CI] Country: "Ivory Coast", code: 225
     */
    data object CI : CountriesCodes("Ivory Coast", "225")

    /**
     * [JM] Country: "Jamaica", code: 1876
     */
    data object JM : CountriesCodes("Jamaica", "1876")

    /**
     * [JP] Country: "Japan", code: 81
     */
    data object JP : CountriesCodes("Japan", "81")

    /**
     * [JE] Country: "Jersey", code: 441534
     */
    data object JE : CountriesCodes("Jersey", "441534")

    /**
     * [JO] Country: "Jordan", code: 962
     */
    data object JO : CountriesCodes("Jordan", "962")

    /**
     * [KZ] Country: "Kazakhstan", code: 7
     */
    data object KZ : CountriesCodes("Kazakhstan", "7")

    /**
     * [KE] Country: "Kenya", code: 254
     */
    data object KE : CountriesCodes("Kenya", "254")

    /**
     * [KI] Country: "Kiribati", code: 686
     */
    data object KI : CountriesCodes("Kiribati", "686")

    /**
     * [XK] Country: "Kosovo", code: 383
     */
    data object XK : CountriesCodes("Kosovo", "383")

    /**
     * [KW] Country: "Kuwait", code: 965
     */
    data object KW : CountriesCodes("Kuwait", "965")

    /**
     * [KG] Country: "Kyrgyzstan", code: 996
     */
    data object KG : CountriesCodes("Kyrgyzstan", "996")

    /**
     * [LA] Country: "Laos", code: 856
     */
    data object LA : CountriesCodes("Laos", "856")

    /**
     * [LV] Country: "Latvia", code: 371
     */
    data object LV : CountriesCodes("Latvia", "371")

    /**
     * [LB] Country: "Lebanon", code: 961
     */
    data object LB : CountriesCodes("Lebanon", "961")

    /**
     * [LS] Country: "Lesotho", code: 266
     */
    data object LS : CountriesCodes("Lesotho", "266")

    /**
     * [LR] Country: "Liberia", code: 231
     */
    data object LR : CountriesCodes("Liberia", "231")

    /**
     * [LY] Country: "Libya", code: 218
     */
    data object LY : CountriesCodes("Libya", "218")

    /**
     * [LI] Country: "Liechtenstein", code: 423
     */
    data object LI : CountriesCodes("Liechtenstein", "423")

    /**
     * [LT] Country: "Lithuania", code: 370
     */
    data object LT : CountriesCodes("Lithuania", "370")

    /**
     * [LU] Country: "Luxembourg", code: 352
     */
    data object LU : CountriesCodes("Luxembourg", "352")

    /**
     * [MO] Country: "Macau", code: 853
     */
    data object MO : CountriesCodes("Macau", "853")

    /**
     * [MK] Country: "Macedonia", code: 389
     */
    data object MK : CountriesCodes("Macedonia", "389")

    /**
     * [MG] Country: "Madagascar", code: 261
     */
    data object MG : CountriesCodes("Madagascar", "261")

    /**
     * [MW] Country: "Malawi", code: 265
     */
    data object MW : CountriesCodes("Malawi", "265")

    /**
     * [MY] Country: "Malaysia", code: 60
     */
    data object MY : CountriesCodes("Malaysia", "60")

    /**
     * [MV] Country: "Maldives", code: 960
     */
    data object MV : CountriesCodes("Maldives", "960")

    /**
     * [ML] Country: "Mali", code: 223
     */
    data object ML : CountriesCodes("Mali", "223")

    /**
     * [MT] Country: "Malta", code: 356
     */
    data object MT : CountriesCodes("Malta", "356")

    /**
     * [MH] Country: "Marshall Islands", code: 692
     */
    data object MH : CountriesCodes("Marshall Islands", "692")

    /**
     * [MR] Country: "Mauritania", code: 222
     */
    data object MR : CountriesCodes("Mauritania", "222")

    /**
     * [MU] Country: "Mauritius", code: 230
     */
    data object MU : CountriesCodes("Mauritius", "230")

    /**
     * [YT] Country: "Mayotte", code: 262
     */
    data object YT : CountriesCodes("Mayotte", "262")

    /**
     * [MX] Country: "Mexico", code: 52
     */
    data object MX : CountriesCodes("Mexico", "52")

    /**
     * [FM] Country: "Micronesia", code: 691
     */
    data object FM : CountriesCodes("Micronesia", "691")

    /**
     * [MD] Country: "Moldova", code: 373
     */
    data object MD : CountriesCodes("Moldova", "373")

    /**
     * [MC] Country: "Monaco", code: 377
     */
    data object MC : CountriesCodes("Monaco", "377")

    /**
     * [MN] Country: "Mongolia", code: 976
     */
    data object MN : CountriesCodes("Mongolia", "976")

    /**
     * [ME] Country: "Montenegro", code: 382
     */
    data object ME : CountriesCodes("Montenegro", "382")

    /**
     * [MS] Country: "Montserrat", code: 1664
     */
    data object MS : CountriesCodes("Montserrat", "1664")

    /**
     * [MA] Country: "Morocco", code: 212
     */
    data object MA : CountriesCodes("Morocco", "212")

    /**
     * [MZ] Country: "Mozambique", code: 258
     */
    data object MZ : CountriesCodes("Mozambique", "258")

    /**
     * [NA] Country: "Namibia", code: 264
     */
    data object NA : CountriesCodes("Namibia", "264")

    /**
     * [NR] Country: "Nauru", code: 674
     */
    data object NR : CountriesCodes("Nauru", "674")

    /**
     * [NP] Country: "Nepal", code: 977
     */
    data object NP : CountriesCodes("Nepal", "977")

    /**
     * [NL] Country: "Netherlands", code: 31
     */
    data object NL : CountriesCodes("Netherlands", "31")

    /**
     * [AN] Country: "Netherlands Antilles", code: 599
     */
    data object AN : CountriesCodes("Netherlands Antilles", "599")

    /**
     * [NC] Country: "New Caledonia", code: 687
     */
    data object NC : CountriesCodes("New Caledonia", "687")

    /**
     * [NZ] Country: "New Zealand", code: 64
     */
    data object NZ : CountriesCodes("New Zealand", "64")

    /**
     * [NI] Country: "Nicaragua", code: 505
     */
    data object NI : CountriesCodes("Nicaragua", "505")

    /**
     * [NE] Country: "Niger", code: 227
     */
    data object NE : CountriesCodes("Niger", "227")

    /**
     * [NG] Country: "Nigeria", code: 234
     */
    data object NG : CountriesCodes("Nigeria", "234")

    /**
     * [NU] Country: "Niue", code: 683
     */
    data object NU : CountriesCodes("Niue", "683")

    /**
     * [MP] Country: "Northern Mariana Islands", code: 1670
     */
    data object MP : CountriesCodes("Northern Mariana Islands", "1670")

    /**
     * [KP] Country: "North Korea", code: 850
     */
    data object KP : CountriesCodes("North Korea", "850")

    /**
     * [NO] Country: "Norway", code: 47
     */
    data object NO : CountriesCodes("Norway", "47")

    /**
     * [OM] Country: "Oman", code: 968
     */
    data object OM : CountriesCodes("Oman", "968")

    /**
     * [PK] Country: "Pakistan", code: 92
     */
    data object PK : CountriesCodes("Pakistan", "92")

    /**
     * [PW] Country: "Palau", code: 680
     */
    data object PW : CountriesCodes("Palau", "680")

    /**
     * [PS] Country: "Palestine", code: 970
     */
    data object PS : CountriesCodes("Palestine", "970")

    /**
     * [PA] Country: "Panama", code: 507
     */
    data object PA : CountriesCodes("Panama", "507")

    /**
     * [PG] Country: "Papua New Guinea", code: 675
     */
    data object PG : CountriesCodes("Papua New Guinea", "675")

    /**
     * [PY] Country: "Paraguay", code: 595
     */
    data object PY : CountriesCodes("Paraguay", "595")

    /**
     * [PE] Country: "Peru", code: 51
     */
    data object PE : CountriesCodes("Peru", "51")

    /**
     * [PH] Country: "Philippines", code: 63
     */
    data object PH : CountriesCodes("Philippines", "63")

    /**
     * [PN] Country: "Pitcairn", code: 64
     */
    data object PN : CountriesCodes("Pitcairn", "64")

    /**
     * [PL] Country: "Poland", code: 48
     */
    data object PL : CountriesCodes("Poland", "48")

    /**
     * [PT] Country: "Portugal", code: 351
     */
    data object PT : CountriesCodes("Portugal", "351")

    /**
     * [PR787] Country: "Puerto Rico", code: 1787
     */
    data object PR787 : CountriesCodes("Puerto Rico", "1787")

    /**
     * [PR939] Country: "Puerto Rico", code: 1939
     */
    data object PR939 : CountriesCodes("Puerto Rico", "1939")

    /**
     * [QA] Country: "Qatar", code: 974
     */
    data object QA : CountriesCodes("Qatar", "974")

    /**
     * [RE] Country: "Reunion", code: 262
     */
    data object RE : CountriesCodes("Reunion", "262")

    /**
     * [RO] Country: "Romania", code: 40
     */
    data object RO : CountriesCodes("Romania", "40")

    /**
     * [RU] Country: "Russia", code: 7
     */
    data object RU : CountriesCodes("Russia", "7")

    /**
     * [RW] Country: "Rwanda", code: 250
     */
    data object RW : CountriesCodes("Rwanda", "250")

    /**
     * [BL] Country: "Saint Barthelemy", code: 590
     */
    data object BL : CountriesCodes("Saint Barthelemy", "590")

    /**
     * [WS] Country: "Samoa", code: 685
     */
    data object WS : CountriesCodes("Samoa", "685")

    /**
     * [SM] Country: "San Marino", code: 378
     */
    data object SM : CountriesCodes("San Marino", "378")

    /**
     * [ST] Country: "Sao Tome and Principe", code: 239
     */
    data object ST : CountriesCodes("Sao Tome and Principe", "239")

    /**
     * [SA] Country: "Saudi Arabia", code: 966
     */
    data object SA : CountriesCodes("Saudi Arabia", "966")

    /**
     * [SN] Country: "Senegal", code: 221
     */
    data object SN : CountriesCodes("Senegal", "221")

    /**
     * [RS] Country: "Serbia", code: 381
     */
    data object RS : CountriesCodes("Serbia", "381")

    /**
     * [SC] Country: "Seychelles", code: 248
     */
    data object SC : CountriesCodes("Seychelles", "248")

    /**
     * [SL] Country: "Sierra Leone", code: 232
     */
    data object SL : CountriesCodes("Sierra Leone", "232")

    /**
     * [SG] Country: "Singapore", code: 65
     */
    data object SG : CountriesCodes("Singapore", "65")

    /**
     * [SX] Country: "Sint Maarten", code: 1721
     */
    data object SX : CountriesCodes("Sint Maarten", "1721")

    /**
     * [SK] Country: "Slovakia", code: 421
     */
    data object SK : CountriesCodes("Slovakia", "421")

    /**
     * [SI] Country: "Slovenia", code: 386
     */
    data object SI : CountriesCodes("Slovenia", "386")

    /**
     * [SB] Country: "Solomon Islands", code: 677
     */
    data object SB : CountriesCodes("Solomon Islands", "677")

    /**
     * [SO] Country: "Somalia", code: 252
     */
    data object SO : CountriesCodes("Somalia", "252")

    /**
     * [ZA] Country: "South Africa", code: 27
     */
    data object ZA : CountriesCodes("South Africa", "27")

    /**
     * [KR] Country: "South Korea", code: 82
     */
    data object KR : CountriesCodes("South Korea", "82")

    /**
     * [SS] Country: "South Sudan", code: 211
     */
    data object SS : CountriesCodes("South Sudan", "211")

    /**
     * [ES] Country: "Spain", code: 34
     */
    data object ES : CountriesCodes("Spain", "34")

    /**
     * [LK] Country: "Sri Lanka", code: 94
     */
    data object LK : CountriesCodes("Sri Lanka", "94")

    /**
     * [SH] Country: "Saint Helena", code: 290
     */
    data object SH : CountriesCodes("Saint Helena", "290")

    /**
     * [KN] Country: "Saint Kitts and Nevis", code: 1869
     */
    data object KN : CountriesCodes("Saint Kitts and Nevis", "1869")

    /**
     * [LC] Country: "Saint Lucia", code: 1758
     */
    data object LC : CountriesCodes("Saint Lucia", "1758")

    /**
     * [MF] Country: "Saint Martin", code: 590
     */
    data object MF : CountriesCodes("Saint Martin", "590")

    /**
     * [PM] Country: "Saint Pierre and Miquelon", code: 508
     */
    data object PM : CountriesCodes("Saint Pierre and Miquelon", "508")

    /**
     * [VC] Country: "Saint Vincent and the Grenadines", code: 1784
     */
    data object VC : CountriesCodes("Saint Vincent and the Grenadines", "1784")

    /**
     * [SD] Country: "Sudan", code: 249
     */
    data object SD : CountriesCodes("Sudan", "249")

    /**
     * [SR] Country: "Suriname", code: 597
     */
    data object SR : CountriesCodes("Suriname", "597")

    /**
     * [SJ] Country: "Svalbard and Jan Mayen", code: 47
     */
    data object SJ : CountriesCodes("Svalbard and Jan Mayen", "47")

    /**
     * [SZ] Country: "Swaziland", code: 268
     */
    data object SZ : CountriesCodes("Swaziland", "268")

    /**
     * [SE] Country: "Sweden", code: 46
     */
    data object SE : CountriesCodes("Sweden", "46")

    /**
     * [CH] Country: "Switzerland", code: 41
     */
    data object CH : CountriesCodes("Switzerland", "41")

    /**
     * [SY] Country: "Syria", code: 963
     */
    data object SY : CountriesCodes("Syria", "963")

    /**
     * [TW] Country: "Taiwan", code: 886
     */
    data object TW : CountriesCodes("Taiwan", "886")

    /**
     * [TJ] Country: "Tajikistan", code: 992
     */
    data object TJ : CountriesCodes("Tajikistan", "992")

    /**
     * [TZ] Country: "Tanzania", code: 255
     */
    data object TZ : CountriesCodes("Tanzania", "255")

    /**
     * [TH] Country: "Thailand", code: 66
     */
    data object TH : CountriesCodes("Thailand", "66")

    /**
     * [TG] Country: "Togo", code: 228
     */
    data object TG : CountriesCodes("Togo", "228")

    /**
     * [TK] Country: "Tokelau", code: 690
     */
    data object TK : CountriesCodes("Tokelau", "690")

    /**
     * [TO] Country: "Tonga", code: 676
     */
    data object TO : CountriesCodes("Tonga", "676")

    /**
     * [TT] Country: "Trinidad and Tobago", code: 1868
     */
    data object TT : CountriesCodes("Trinidad and Tobago", "1868")

    /**
     * [TN] Country: "Tunisia", code: 216
     */
    data object TN : CountriesCodes("Tunisia", "216")

    /**
     * [TR] Country: "Turkey", code: 90
     */
    data object TR : CountriesCodes("Turkey", "90")

    /**
     * [TM] Country: "Turkmenistan", code: 993
     */
    data object TM : CountriesCodes("Turkmenistan", "993")

    /**
     * [TC] Country: "Turks and Caicos Islands", code: 1649
     */
    data object TC : CountriesCodes("Turks and Caicos Islands", "1649")

    /**
     * [TV] Country: "Tuvalu", code: 688
     */
    data object TV : CountriesCodes("Tuvalu", "688")

    /**
     * [AE] Country: "United Arab Emirates", code: 971
     */
    data object AE : CountriesCodes("United Arab Emirates", "971")

    /**
     * [UG] Country: "Uganda", code: 256
     */
    data object UG : CountriesCodes("Uganda", "256")

    /**
     * [GB] Country: "United Kingdom ", code: 44
     */
    data object GB : CountriesCodes("United Kingdom ", "44")

    /**
     * [UA] Country: "Ukraine", code: 380
     */
    data object UA : CountriesCodes("Ukraine", "380")

    /**
     * [UY] Country: "Uruguay", code: 598
     */
    data object UY : CountriesCodes("Uruguay", "598")

    /**
     * [US] Country: "United States", code: 1
     */
    data object US : CountriesCodes("United States", "1")

    /**
     * [UZ] Country: "Uzbekistan", code: 998
     */
    data object UZ : CountriesCodes("Uzbekistan", "998")

    /**
     * [VU] Country: "Vanuatu", code: 678
     */
    data object VU : CountriesCodes("Vanuatu", "678")

    /**
     * [VA] Country: "Vatican", code: 379
     */
    data object VA : CountriesCodes("Vatican", "379")

    /**
     * [VE] Country: "Venezuela", code: 58
     */
    data object VE : CountriesCodes("Venezuela", "58")

    /**
     * [VN] Country: "Vietnam", code: 84
     */
    data object VN : CountriesCodes("Vietnam", "84")

    /**
     * [VI] Country: "U.S. Virgin Islands", code: 1340
     */
    data object VI : CountriesCodes("U.S. Virgin Islands", "1340")

    /**
     * [WF] Country: "Wallis and Futuna", code: 681
     */
    data object WF : CountriesCodes("Wallis and Futuna", "681")

    /**
     * [EH] Country: "Western Sahara", code: 212
     */
    data object EH : CountriesCodes("Western Sahara", "212")

    /**
     * [YE] Country: "Yemen", code: 967
     */
    data object YE : CountriesCodes("Yemen", "967")

    /**
     * [ZM] Country: "Zambia", code: 260
     */
    data object ZM : CountriesCodes("Zambia", "260")

    /**
     * [ZW] Country: "Zimbabwe", code: 263
     */
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