
	var singleSelect = true;
	var sortSelect = true;
	var sortPick = true;

	function initIt() {
		var selectList = document.getElementById("SelectList");
		var pickList = document.getElementById("PickList");
  		var pickOptions = pickList.options;
		pickOptions[0] = null;
		//selectList.focus();  // Set focus on the selectlist
	}

function addIt() {

var selectedArray = new Array();
var selectList = document.getElementById("SelectList");
var selectOptions = selectList.options;
		var j;
		var count = 0;
		for (i=0; i<selectList.options.length; i++) {
		    if (selectList.options[i].selected) {
		      selectedArray[count] = selectList.options[i].value;
		      count++;
    		}
  	 	}
for(x=0;x<selectedArray.length;x++){
		
		var selectIndex = selectList.selectedIndex;
		var pickList = document.getElementById("PickList");
		var pickOptions = pickList.options;
		var pickOLength = pickOptions.length;

	if (selectIndex > -1) {
		pickOptions[pickOLength] = new Option(selectList[selectIndex].text);
		pickOptions[pickOLength].value = selectList[selectIndex].value;
		if (singleSelect) {
			selectOptions[selectIndex] = null;
		}
		if (sortPick) {
			var tempText;
			var tempValue;
			while (pickOLength > 0 && pickOptions[pickOLength].value < pickOptions[pickOLength-1].value) {
				tempText = pickOptions[pickOLength-1].text;
		        tempValue = pickOptions[pickOLength-1].value;
		        pickOptions[pickOLength-1].text = pickOptions[pickOLength].text;
		        pickOptions[pickOLength-1].value = pickOptions[pickOLength].value;
		        pickOptions[pickOLength].text = tempText;
		        pickOptions[pickOLength].value = tempValue;
		        pickOLength = pickOLength - 1;
      		}
	    }
   }
}
}

function delIt() {
	var selectedArray = new Array();
	var pickList = document.getElementById("PickList");
	var j;
		var count = 0;
		for (i=0; i<pickList.options.length; i++) {
		    if (pickList.options[i].selected) {
		      selectedArray[count] = pickList.options[i].value;
		      count++;
    		}
  	 	}
for(x=0;x<selectedArray.length;x++){
	var selectList = document.getElementById("SelectList");
	var selectOptions = selectList.options;
	var selectOLength = selectOptions.length;
	pickList = document.getElementById("PickList");
	var pickIndex = pickList.selectedIndex;
	var pickOptions = pickList.options;
	
	if (pickIndex > -1) {
		if (singleSelect) {
			selectOptions[selectOLength] = new Option(pickList[pickIndex].text);
			selectOptions[selectOLength].value = pickList[pickIndex].value;
		}
    	pickOptions[pickIndex] = null;
		if (singleSelect && sortSelect) {
			var tempText;
			var tempValue;
			while (selectOLength > 0 && selectOptions[selectOLength].value < selectOptions[selectOLength-1].value) {
				tempText = selectOptions[selectOLength-1].text;
				tempValue = selectOptions[selectOLength-1].value;
				selectOptions[selectOLength-1].text = selectOptions[selectOLength].text;
				selectOptions[selectOLength-1].value = selectOptions[selectOLength].value;
				selectOptions[selectOLength].text = tempText;
				selectOptions[selectOLength].value = tempValue;
				selectOLength = selectOLength - 1;
			}
		}
	}
}
}
function copyAll(){
	var selectList = document.getElementById("SelectList");
	var selectAll = selectList.options.length;
	var i=0;
	

	for(i=0;i<selectAll;i++){
			selectIndex = i;
			var selectOptions = selectList.options;
			var pickList = document.getElementById("PickList");
			var pickOptions = pickList.options;
			var pickOLength = pickOptions.length;
			
			if (selectIndex > -1) {
				pickOptions[pickOLength] = new Option(selectList[selectIndex].text);
				pickOptions[pickOLength].value = selectList[selectIndex].value;
				//if (singleSelect) {
				//	selectOptions[selectIndex] = null;
				//}
				if (sortPick) {
					var tempText;
					var tempValue;
					while (pickOLength > 0 && pickOptions[pickOLength].value < pickOptions[pickOLength-1].value) {
						tempText = pickOptions[pickOLength-1].text;
				        tempValue = pickOptions[pickOLength-1].value;
				        pickOptions[pickOLength-1].text = pickOptions[pickOLength].text;
		        		pickOptions[pickOLength-1].value = pickOptions[pickOLength].value;
				        pickOptions[pickOLength].text = tempText;
				        pickOptions[pickOLength].value = tempValue;
		        		pickOLength = pickOLength - 1;
      				}
	    		}
   			}
	}
	selectList = document.getElementById("SelectList");
	selectOptions = selectList.options;
	selectAll = selectOptions.length;

	for(i=0;i<selectAll;i++){
		selectOptions[0] = null;
	}
}
function deleteAll(){
	var selectList = document.getElementById("SelectList");
	var pickList = document.getElementById("PickList");
	var selectAll = pickList.options.length;

	var i=0;

	for(i=0;i<selectAll;i++){
	var selectOptions = selectList.options;
	var selectOLength = selectOptions.length;
	pickList = document.getElementById("PickList");
	var pickIndex = i;
	var pickOptions = pickList.options;

	if (pickIndex > -1) {
		if (singleSelect) {
			selectOptions[selectOLength] = new Option(pickList[pickIndex].text);
			selectOptions[selectOLength].value = pickList[pickIndex].value;
		}
    	//pickOptions[pickIndex] = null;
		if (singleSelect && sortSelect) {
			var tempText;
			var tempValue;
			while (selectOLength > 0 && selectOptions[selectOLength].value < selectOptions[selectOLength-1].value) {
				tempText = selectOptions[selectOLength-1].text;
				tempValue = selectOptions[selectOLength-1].value;
				selectOptions[selectOLength-1].text = selectOptions[selectOLength].text;
				selectOptions[selectOLength-1].value = selectOptions[selectOLength].value;
				selectOptions[selectOLength].text = tempText;
				selectOptions[selectOLength].value = tempValue;
				selectOLength = selectOLength - 1;
			}
		}
	}
	}

	pickList = document.getElementById("PickList");
	pickListOptions = pickList.options;
	selectAll = pickListOptions.length;

	for(i=0;i<selectAll;i++){
		pickListOptions[0] = null;
	}
}
