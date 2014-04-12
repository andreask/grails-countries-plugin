includeTargets << grailsScript("Init")

target(main: "fetch the country list from wikipedia and convert it to csv") {
	def countryMap = [:]
    URL url = new URL("http://en.wikipedia.org/wiki/List_of_countries_by_continent_%28data_file%29")
    def countriesCsv = "$basedir/web-app/countries.csv"
    url.withReader { reader ->
        def slurper = new XmlSlurper(new org.ccil.cowan.tagsoup.Parser())
        def html = slurper.parse(reader)
        def countryList =  html.'**'.find {it.@id=='mw-content-text'}.pre.toString()
				
		countryList.eachLine { String line ->
			if (line != null && line != "") {
				def lineArray = line.tokenize()
				def ckey = lineArray[2]
				
				countryMap[ckey] = []
				countryMap[ckey].add(lineArray[0])
				countryMap[ckey].add(lineArray[1])
				countryMap[ckey].add(lineArray[2])
				countryMap[ckey].add(lineArray[3])
			}
		}
	}
	
	url = new URL("http://countrycode.org/")
	url.withReader { reader ->
		def slurper = new XmlSlurper(new org.ccil.cowan.tagsoup.Parser())
		def html = slurper.parse(reader)
		def phoneList =  html.'**'.find {it.@id=='main_table_blue'}.tbody

		phoneList.tr.each { tr ->
			def array = []
				
			tr.td.each { td ->
				array.add(td.toString())
			}
			
			array.remove(0)
				
			array[0] = array[0].replaceAll(' ', '').split('/')
			array = array.flatten()
			array[1] = array[1].replaceAll("\u00A0", "")
			
			if (countryMap[array[1]])
				countryMap[array[1]].add(array[2])
		}
	}
	
	File output = new File(countriesCsv)
	
	output.withWriter { Writer writer ->
		countryMap.keySet().each { key ->
			writer.println(countryMap[key].join("\t").replaceAll("null", ""))
		}
	}

    echo "successfully fetched and converted $countriesCsv from $url"

    copy(todir:"${basedir}/web-app") {
        fileset(dir: "$countriesPluginDir/web-app", includes: "*.csv")
    }

}

setDefaultTarget(main)
