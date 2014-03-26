importPackage(java.io);
importPackage(java.util);
importPackage(java.lang);

var fileName;
function run() {
	var defaultFileName = "D:\\TestTask\\testTask.properties";
		var properties = new Properties();
		try {
			if (fileName == undefined || fileName==""){
				println("Use default properties file: " + defaultFileName);
				properties.load(new FileInputStream(defaultFileName));
			}else{
				println("Use external properties file: " + fileName);
				properties.load(new FileInputStream(fileName));
			}
		
			var keys = properties.stringPropertyNames();
			var i = keys.size();
			var iterator = keys.iterator();

			while (iterator.hasNext()){
				var key = iterator.next();
				println("Key: " + key + ";  Value: " + properties.get(key));
			}
			return properties;
		}catch (e){
			print("Error description: " + e);
			return new Exception(e);
		}

};
run();
	
	
		



