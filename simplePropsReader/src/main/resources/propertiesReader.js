importPackage(java.io);
importPackage(java.util);
importPackage(java.lang);

var properties = new Properties();
properties.load(new FileInputStream("D:\\TestTask\\testTask.properties"));

var keys = properties.stringPropertyNames();
var iterator = keys.iterator();
try {
	while (iterator.hasNext()){
		var key = iterator.next();
		println("Key: " + key + ";  Value: " + properties.get(key));
	}
}catch (e){
	print("Error description: " + e);
}

