module crud {
	requires java.desktop;
	requires com.google.gson;
	opens auto.crud to com.google.gson;
}