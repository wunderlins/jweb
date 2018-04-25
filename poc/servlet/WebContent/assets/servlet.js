/**
 * open dialog window
 * 
 * @param target
 * @param url
 * @returns Objetc window
 */
function wopen(target, url) {
	var w = window.open(url, target, "width=800, height=600, menubar=0, toolbar=0, location=0, status=1, directories=0, scrollbars=1");
	return w;
}

/**
 * open dialog window
 * 
 * this one is with a simpler interface. We only have to pass this from the a tag.
 * 
 * @param o
 * @returns Object window
 */
function wopen2(o) {
	var opts = "width=800, height=600, menubar=0, toolbar=0, location=0, status=1, directories=0, scrollbars=1";
	var w = window.open(o.getAttribute("href"), 
			            o.getAttribute("target"), 
			            opts);
	return w;
}