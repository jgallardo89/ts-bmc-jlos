ToggleFilter = function(){
	if (!this.filtered){
		pageChannels.filter(function(ds, row, rowNum) { 
			if (rowNum % 2)	return row;
			return null; 
		});
	}else{
		pageChannels.filter(null);
	}
	this.filtered = !this.filtered;
};

function FilterData(columName,element){
    var tf = element;
    if (!tf.value){
    	html_ds.filter(null);
        return;
    }
    var regExpStr = tf.value;
    regExpStr = regExpStr.replace(".", "\\.");
    var regExp = new RegExp(regExpStr, "i");
    var filterFunc = function(ds, row, rowNumber){
        var str = row[columName];
        if (str && str.search(regExp) != -1)
            return row;
        return null;
    };
    html_ds.filter(filterFunc);
}

function StartFilterTimer(columName,element){
    if (StartFilterTimer.timerID)
        clearTimeout(StartFilterTimer.timerID);
    StartFilterTimer.timerID = setTimeout(function() { StartFilterTimer.timerID = null; FilterData(columName,element); }, 100);
}
