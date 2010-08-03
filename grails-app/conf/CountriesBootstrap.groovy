import org.codehaus.groovy.grails.plugins.neo4j.Continent
import org.codehaus.groovy.grails.plugins.neo4j.Country

class CountriesBootstrap {

    def init = { servletContext ->
        if (Continent.count()==0) {
            [
                    ['asa'],
                    ['eur'],
                    ['afi'],
                    ['nam'],
                    ['sam'],
                    ['aus'],
                    ['afa'],
            ].each {
                assert new Continent(key:it[0]).save()
            }
        }

        if (Country.count()==0) {
            setupCountries()
        }    }
    def destroy = {
    }

    def setupCountries() {
        def countries = [
["num","domain","land","countries","countries_long","iso","ioc","ort","kont"],
["004",".af","Afghanistan","Afghanistan","Islamic State of Afghanistan","AF","AFG","Kabul","asa"],
["008",".al","Albanien","Albania","Republic of Albania","AL","ALB","Tirana","eur"],
["012",".dz","Algerien","Algeria","Democratic and Popular Republic of Algeria","DZ","ALG","Algiers","afi"],
["020",".ad","Andorra","Andorra","Principality of Andorra","AD","AND","Andorra la Vella","eur"],
["024",".ao","Angola","Angola","Republic of Angola","AO","ANG","Luanda","afi"],
["028",".ag","Antigua und Barbuda","Antigua and Barbuda","","AG","ANT","Saint John's","nam"],
["032",".ar","Argentinien","Argentina","Argentine Republic","AR","ARG","Buenos Aires","sam"],
["051",".am","Armenien","Armenia","Republic of Armenia","AM","ARM","Yerevan","asa"],
["036",".au","Australien","Australia","Commonwealth of Australia","AU","AUS","Canberra","aus"],
["040",".at","Oesterreich","Austria","Republic of Austria","AT","AUT","Vienna","eur"],
["031",".az","Aserbaidschan","Azerbaijan","Azerbaijani Republic","AZ","AZE","Baku","asa"],
["044",".bs","Bahamas","Bahamas, The","Commonwealth of The Bahamas","BS","BAH","Nassau","nam"],
["048",".bh","Bahrain","Bahrain","State of Bahrain","BH","BRN","Manama","asa"],
["050",".bd","Bangladesh","Bangladesh","People's Republic of Bangladesh","BD","BAN","Dhaka","asa"],
["052",".bb","Barbados","Barbados","","BB","BAR","Bridgetown","nam"],
["112",".by","Weissrussland","Belarus","Republic of Belarus","BY","BLR","Minsk","eur"],
["056",".be","Belgien","Belgium","Kingdom of Belgium","BE","BEL","Brussels","eur"],
["084",".bz","Belize","Belize","","BZ","BIZ","Belmopan","nam"],
["204",".bj","Benin","Benin","Republic of Benin","BJ","BEN","Porto-Novo","afa"],
["064",".bt","Bhutan","Bhutan","Kingdom of Bhutan","BT","BHU","Thimphu","asa"],
["068",".bo","Bolivien","Bolivia","Republic of Bolivia","BO","BOL","Sucre","sam"],
["070",".ba","Bosnien und Herzegovina","Bosnia and Herzegovina","","BA","BIH","Sarajevo","eur"],
["072",".bw","Botsuana","Botswana","Republic of Botswana","BW","BOT","Gaborone","afa"],
["076",".br","Brasilien","Brazil","Federative Republic of Brazil","BR","BRA","Brasília","sam"],
["096",".bn","Brunei","Brunei","Negara Brunei Darussalam","BN","BRU","Bandar Seri Begawan","afa"],
["100",".bg","Bulgarien","Bulgaria","Republic of Bulgaria","BG","BUL","Sofia","eur"],
["854",".bf","Burkina Faso","Burkina Faso","Burkina Faso","BF","BUR","Ouagadougou","afa"],
["104",".mm","Burma","Myanmar","Pyidaungsu Thamada Myanmar Naing-Ngan-Daw","MM","MYA","Rangoon","asa"],
["108",".bi","Burundi","Burundi","Republic of Burundi","BI","BDI","Bujumbura","afa"],
["116",".kh","Kambotscha","Cambodia","Kingdom of Cambodia","KH","CAM","Phnom Penh","asa"],
["120",".cm","Kamerun","Cameroon","Republic of Cameroon","CM","CMR","Yaoundé","afa"],
["124",".ca","Kanada","Canada","","CA","CAN","Ottawa","nam"],
["132",".cv","Kap Verde","Cape Verde","Republic of Cape Verde","CV","CPV","Praia","afa"],
["140",".cf","Zentralafrikanische Republik","Central African Republic","Central African Republic","CF","CAF","Bangui","afa"],
["148",".td","Tschad","Chad","Republic of Chad","TD","CHA","N'Djamena","afa"],
["152",".cl","Chile","Chile","Republic of Chile","CL","CHI","Santiago","sam"],
["156",".cn","Volksrepublik China","China","People's Republic of China","CN","CHN","Beijing","asa"],
["170",".co","Kolumbien","Colombia","Republic of Colombia","CO","COL","Bogotá","sam"],
["174",".km","Komoren","Comoros","Federal Islamic Republic of the Comoros","","","Moroni","afa"],
["178",".cg","Republik Kongo","Congo","Republic of the Congo","KM","COM","Brazzaville","afa"],
["180",".cd","Demokratische Republik Kongo","Congo","Democratic Republic of the Congo","CD","COD","Kinshasa","afa"],
["188",".cr","Costa Rica","Costa Rica","Republic of Costa Rica","CR","CRC","San José","nam"],
["384",".ci","Elfenbeinkueste","Côte d'Ivoire","Republic of Côte d'Ivoire","CI","CIV","Yamoussoukro","afa"],
["191",".hr","Kroatien","Croatia","Republic of Croatia","HR","CRO","Zagreb","eur"],
["192",".cu","Kuba","Cuba","Republic of Cuba","CU","CUB","Havana","nam"],
["196",".cy","Zypern","Cyprus","Republic of Cyprus","CY","CYP","Nicosia","eur"],
["203",".cz","Tschechische Republik","Czech Republic","Czech Republic","CZ","CZE","Prague","eur"],
["208",".dk","Daenemark","Denmark","Kingdom of Denmark","DK","DEN","Copenhagen","eur"],
["262",".dj","Dschibuti","Djibouti","Republic of Djibouti","DJ","DJI","Djibouti","afa"],
["212",".dm","Domenica","Dominica","Commonwealth of Dominica","DM","DMA","Roseau","nam"],
["214",".do","Dominikanische Republik","Dominican Republic","Dominican Republic","DO","DOM","Santo Domingo","nam"],
["218",".ec","Ecuador","Ecuador","Republic of Ecuador","EC","ECU","Quito","sam"],
["818",".eg","Aegypten","Egypt","Arab Republic of Egypt","EG","EGY","Cairo","afa"],
["222",".sv","El Salvador","El Salvador","Republic of El Salvador","SV","ESA","San Salvador","nam"],
["324",".gn","Guinea","Equatorial Guinea","Republic of Equatorial Guinea","GN","GUI","Malabo","afa"],
["232",".er","Eritrea","Eritrea","State of Eritrea","ER","ERI","Asmara","afa"],
["233",".ee","Estland","Estonia","Republic of Estonia","EE","EST","Tallinn","eur"],
["231",".et","Aethiopien","Ethiopia","Federal Democratic Republic of Ethiopia","ET","ETH","Addis Ababa","afa"],
["232",".fj","Fidschi","Fiji","Republic of the Fiji Islands","FJ","FIJ","Suva","aus"],
["246",".fi","Finnland","Finland","Republic of Finland","FI","FIN","Helsinki","eur"],
["250",".fr","Frankreich","France","French Republic","FR","FRA","Paris","eur"],
["266",".ga","Gabun","Gabon","Gabonese Republic","GA","GAB","Libreville","afa"],
["270",".gm","Gambia","Gambia, The","Republic of The Gambia","GM","GAM","Banjul","afa"],
["268",".ge","Georgien","Georgia","","GE","GEO","Tiflis","asa"],
["276",".de","Deutschland","Germany","Federal Republic of Germany","DE","GER","Berlin","eur"],
["288",".gh","Ghana","Ghana","Republic of Ghana","GH","GHA","Accra","afa"],
["300",".gr","Griechenland","Greece","Hellenic Republic","","","Athens",""],
["308",".gd","Grenada","Grenada","","GD","GRN","Saint George's","nam"],
["320",".gt","Guatemala","Guatemala","Republic of Guatemala","GT","GUA","Guatemala","nam"],
["324",".gn","Guinea","Guinea","Republic of Guinea","GN","GUI","Conakry","afa"],
["624",".gw","Guinea-Bissau","Guinea-Bissau","Republic of Guinea-Bissau","GW","GBS","Bissau","afa"],
["328",".gy","Guyana","Guyana","Co-operative Republic of Guyana","GY","GUY","Georgetown","sam"],
["332",".ht","Haiti","Haiti","Republic of Haiti","HT","HAI","Port-au-Prince","nam"],
["336",".va","Vatikanstadt","Holy See","Holy See","VA","","Vatican City","eur"],
["340",".hn","Honduras","Honduras","Republic of Honduras","HN","HON","Tegucigalpa","nam"],
["348",".hu","Ungarn","Hungary","Republic of Hungary","HU","HUN","Budapest","eur"],
["352",".is","Island","Iceland","Republic of Iceland","IS","ISL","Reykjavík","eur"],
["356",".in","Indien","India","Republic of India","IN","IND","New Delhi","asa"],
["360",".id","Indonesien","Indonesia","Republic of Indonesia","ID","INA","Jakarta",""],
["364",".ir","Iran","Iran","Islamic Republic of Iran","IR","IRI","Tehran","asa"],
["368",".iq","Irak","Iraq","Republic of Iraq","IQ","IRQ","Baghdad","asa"],
["372",".ie","Irland","Ireland","","IE","IRL","Dublin","eur"],
["376",".il","Israel","Israel","State of Israel","IL","ISR","Jerusalem","asa"],
["380",".it","Italien","Italy","Italian Republic","IT","ITA","Rome","eur"],
["388",".jm","Jamaika","Jamaica","","JM","JAM","Kingston","nam"],
["392",".jp","japan","Japan","","JP","JPN","Tokyo","asa"],
["400",".jo","Jordanien","Jordan","Hashemite Kingdom of Jordan","JO","JOR","Amman","asa"],
["398",".kz","Kasachstan","Kazakhstan","Republic of Kazakhstan","KZ","KAZ","Astana","asa"],
["404",".ke","Kenia","Kenya","Republic of Kenya","KE","KEN","Nairobi","afa"],
["296",".ki","Kiribati","Kiribati","Republic of Kiribati","KI","KIR","Tarawa","aus"],
["408",".kp","Nordkorea","Korea, North","Democratic People's Republic of Korea","KP","PRK","P'yongyang","asa"],
["410",".kr","Suedkorea","Korea, South","Republic of Korea","KR","KOR","Seoul","asa"],
["414",".kw","Kuwait","Kuwait","State of Kuwait","KW","KUW","Kuwait","asa"],
["417",".kg","Kirgisistan","Kyrgyzstan","Kyrgyz Republic","KG","KGZ","Bishkek","asa"],
  ["418",".la","Laos","Laos","Lao People's Democratic Republic","LA","LAO","Vientiane","asa"],
["428",".lv","Lettland","Latvia","Republic of Latvia","LV","LAT","Riga","eur"],
["422",".lb","Libanon","Lebanon","Lebanese Republic","LB","LIB","Beirut","asa"],
["426",".ls","Lesotho","Lesotho","Kingdom of Lesotho","LS","LES","Maseru","afa"],
["430",".lr","Liberia","Liberia","Republic of Liberia","LR","LBR","Monrovia","afa"],
["434",".ly","Lybien ","Libya","Socialist People's Libyan Arab Jamahiriya","LY","LBA","Tripoli","afa"],
["438",".li","Liechtenstein","Liechtenstein","Principality of Liechtenstein","LI","LIE","Vaduz","eur"],
["440",".lt","Lithauen","Lithuania","Republic of Lithuania","LT","LTU","Vilnius","eur"],
["442",".lu","Luxemburg","Luxembourg","Grand Duchy of Luxembourg","LU","LUX","Luxembourg","eur"],
["807",".mk","Mazedonien","Macedonia","The Former Yugoslav Republic of Macedonia","MK","MKD","Skopje","eur"],
["450",".mg","Madagaskar","Madagascar","Republic of Madagascar","MG","MAD","Antananarivo","afa"],
["454",".mw","Malawi","Malawi","Republic of Malawi","MW","MAW","Lilongwe","afa"],
["458",".my","Malaysia","Malaysia","","MY","MAS","Kuala Lumpur","asa"],
["462",".mv","Malediven","Maldives","Republic of Maldives","MV","MDV","Male","asa"],
["466",".ml","Mali","Mali","Republic of Mali","ML","MLI","Bamako","afa"],
["470",".mt","Malta","Malta","","MT","MLT","Valletta","eur"],
["584",".mh","Marshallinseln","Marshall Islands","Republic of the Marshall Islands","MH","MHL","Majuro","aus"],
["478",".mr","Mauretanien","Mauritania","Islamic Republic of Mauritania","MR","MTN","Nouakchott","afa"],
["480",".mu","Mauritius","Mauritius","Republic of Mauritius","MU","MRI","Port Louis","afa"],
["484",".mx","Mexiko","Mexico","United Mexican States","MX","MEX","Mexico","nam"],
["583",".fm","Mikronesien","Micronesia, Federated States of","Federated States of Micronesia","","","Palikir",""],
["498",".md","Moldavien","Moldova","Republic of Moldova","MD","MDA","Chisinau","eur"],
["492",".mc","Monaco","Monaco","Principality of Monaco","MC","MON","Monaco","eur"],
["496",".mn","Mongolei","Mongolia","","MN","MGL","Ulaanbaatar","asa"],
["504",".ma","Marokko","Morocco","Kingdom of Morocco","MA","MAR","Rabat","afa"],
["508",".mz","Mosambik","Mozambique","Republic of Mozambique","MZ","MOZ","Maputo","afa"],
["516",".nq","Namibia","Namibia","Republic of Namibia","NA","NAM","Windhoek","afa"],
["520",".nr","Naru","Nauru","Republic of Nauru","NR","NRU","Yaren District","aus"],
["524",".np","Nepal","Nepal","Kingdom of Nepal","NP","NEP","Kathmandu","asa"],
["528",".nl","Niederlande","Netherlands","Kingdom of the Netherlands","NL","NED","Amsterdam","eur"],
["554",".nz","Neuseeland","New Zealand","","NZ","NZL","Wellington","aus"],
["558",".ni","Nicaragua","Nicaragua","Republic of Nicaragua","NI","NCA","Managua","nam"],
["562",".ne","Niger","Niger","Republic of Niger","NE","NIG","Niamey","afa"],
["566",".ng","Nigeria","Nigeria","Federal Republic of Nigeria","NG","NGR","Abuja","afa"],
["578",".no","Norwegen","Norway","Kingdom of Norway","NO","NOR","Oslo","eur"],
["512",".om","Oman","Oman","Sultanate of Oman","OM","OMA","Muscat","asa"],
["586",".pk","Pakistan","Pakistan","Islamic Republic of Pakistan","PK","PAK","Islamabad","asa"],
["585",".pw","Palau","Palau","Republic of Palau","PW","PLW","Koror","aus"],
["591",".pa","Panama","Panama","Republic of Panama","PA","PAN","Panama","nam"],
["598",".pg","Papua-Neuguinea","Papua New Guinea","Independent State of Papua New Guinea","PG","PNG","Port Moresby","aus"],
["600",".py","Paraguay","Paraguay","Republic of Paraguay","PY","PAR","Asunción","sam"],
["604",".pe","Peru","Peru","Republic of Peru","","","Lima",""],
["608",".ph","Philippinen","Philippines","Republic of the Philippines","PH","PHI","Manila","asa"],
["616",".pl","Polen","Poland","Republic of Poland","PL","POL","Warsaw","eur"],
["620",".pt","Portugal","Portugal","Portuguese Republic","PT","POR","Lisbon","eur"],
["634",".qa","Katar","Qatar","State of Qatar","QA","QAT","Doha","asa"],
["642",".ro","Rumaenien","Romania","","RO","ROU","Bucharest","eur"],
["643",".ru","Russische Foederation","Russia","Russian Federation","RU","RUS","Moscow","eur"],
["646",".rw","Ruanda","Rwanda","Rwandese Republic","RW","RWA","Kigali","afa"],
["659",".kn","St. Kitts und Nevis","Saint Kitts and Nevis","Federation of Saint Kitts and Nevis","KN","SKN","Basseterre","nam"],
["662",".lc","St. Lucia","Saint Lucia","","LC","LCA","Castries","nam"],
["670",".vc","St. Vincent und die Grenadinen","Saint Vincent and the Grenadines","","VC","VIN","Kingstown","nam"],
["882",".ws","Samoa","Samoa","Independent State of Samoa","WS","SAM","Apia","aus"],
["674",".sm","San Marino","San Marino","Republic of San Marino","SM","SMR","San Marino","eur"],
["678",".st","Sao Tome and Principe","Sao Tome and Principe","Democratic Republic of Sao Tome and Principe","ST","STP","São Tomé","afa"],
["682",".sa","Saudi Arabien","Saudi Arabia","Kingdom of Saudi Arabia","SA","KSA","Riyadh","asa"],
["686",".sn","Senegal","Senegal","Republic of Senegal","SN","SEN","Dakar","afa"],
["690",".sc","Seychellen","Seychelles","Republic of Seychelles","SC","SEY","Victoria","afa"],
["694",".sl","Sierra Leone","Sierra Leone","Republic of Sierra Leone","SL","SLE","Freetown","afa"],
["702",".sg","Singapur","Singapore","Republic of Singapore","SG","SIN","Singapore","asa"],
["703",".sk","Slowakei","Slovakia","Slovak Republic","SK","SVK","Bratislava","eur"],
["705",".si","Slowenien","Slovenia","Republic of Slovenia","SI","SLO","Ljubljana","eur"],
["090",".sb","Salomonen","Solomon Islands","","SB","SOL","Honiara","aus"],
["706",".so","Somalia","Somalia","","SO","SOM","Mogadishu","afa"],
["710",".za","Südafrika","South Africa","Republic of South Africa","ZA","RSA","Pretoria","afa"],
["724",".es","Spanien","Spain","Kingdom of Spain","ES","ESP","Madrid","eur"],
["144",".lk","Sri Lanka","Sri Lanka","Democratic Socialist Republic of Sri Lanka","LK","SRI","Colombo","asa"],
["736",".sd","Sudan","Sudan","Republic of the Sudan","SD","SUD","Khartoum","afa"],
["740",".sr","Surinam","Suriname","Republic of Suriname","SR","SUR","Paramaribo","sam"],
["748",".sz","Swasiland","Swaziland","Kingdom of Swaziland","SZ","SWZ","Mbabane","afa"],
["752",".se","Schweden","Sweden","Kingdom of Sweden","SE","SWE","Stockholm","eur"],
["756",".ch","Schweiz","Switzerland","Swiss Confederation","CH","SUI","Bern","eur"],
["760",".sy","Syrien","Syria","Syrian Arab Republic","SY","SYR","Damascus","asa"],
["762",".tj","Tadschikistan","Tajikistan","Republic of Tajikistan","TJ","TJK","Dushanbe","asa"],
["834",".tz","Tansania","Tanzania","United Republic of Tanzania","TZ","TAN","Dar es Salaam Dodoma","afa"],
["764",".th","Thailand","Thailand","Kingdom of Thailand","TH","THA","Bangkok","asa"],
["768",".tg","Togo","Togo","Togolese Republic","TG","TOG","Lom&eacute;","afa"],
["776",".to","Tonga","Tonga","Kingdom of Tonga","TO","TGA","Nuku'alofa","aus"],
["780",".tt","Trinidad und Tobago","Trinidad and Tobago","Republic of Trinidad and Tobago","TT","TRI","Port-of-Spain","nam"],
["788",".tn","Tunesien","Tunisia","Republic of Tunisia","TN","TUN","Tunis","afa"],
["792",".tr","Türkei","Turkey","Republic of Turkey","TR","TUR","Ankara","asa"],
["795",".tm","Turkmenistan","Turkmenistan","","TM","TKM","Ashgabat","asa"],
["798",".tv","Tuvalu","Tuvalu","","TV","TUV","Funafuti","aus"],
["800",".ug","Uganda","Uganda","Republic of Uganda","UG","UGA","Kampala","afa"],
["804",".ua","Ukraine","Ukraine","","UA","UKR","Kiev","eur"],
["784",".ae","Vereinigte Arabische Emirate","United Arab Emirates","United Arab Emirates","AE","UAE","Abu Dhabi","asa"],
["826",".uk","Grossbritanien","United Kingdom","United Kingdom of Great Britain and Northern Ireland","GB","GBR","London","eur"],
["840",".us","Vereinigte Staaten von Amerika","United States","United States of America","US","USA","Washington, DC","nam"],
["858",".uy","Uruguay","Uruguay","Oriental Republic of Uruguay","UY","URU","Montevideo","sam"],
["860",".uz","Usbekistan","Uzbekistan","Republic of Uzbekistan","UZ","UZB","Tashkent","asa"],
["548",".vu","Vanuatu","Vanuatu","Republic of Vanuatu","VU","VAN","Port-Vila","aus"],
["862",".ve","Venezuela","Venezuela","Republic of Venezuela","VE","VEN","Caracas","sam"],
["704",".vn","Vietnam","Vietnam","Socialist Republic of Vietnam","VN","VIE","Hanoi","asa"],
["887",".ye","Jemen","Yemen","Republic of Yemen","YE","YEM","Sanaa","asa"],
["894",".zm","Sambia","Zambia","Republic of Zambia","ZM","ZAM","Lusaka","afa"],
["716",".zw","Simbabwe","Zimbabwe","Republic of Zimbabwe","ZW","ZIM","Harare","afa"],
        ]

        countries.each { fields->
            def country = new Country(
                    iso3166Number: fields[0],
                    domain: fields[1],
                    name: fields[3],
                    iso3166_2: fields[5],
                    iso3166_6: fields[6],
                    capital: fields[7],
                    continent: Continent.findByKey(fields[8])
                    )
            assert country.save(), country.errors.allErrors

        }
    }

}