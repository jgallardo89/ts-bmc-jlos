for(var i = 0; i < 234; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

});

if (bIE) document.getElementById('u181').attachEvent("onmousedown", function(e) { StartDragWidget(e, 'u181'); });
else {
    document.getElementById('u181').addEventListener("mousedown", function(e) { StartDragWidget(e, 'u181'); }, true);
    document.getElementById('u181').addEventListener("touchstart", function(e) { StartDragWidget(e, 'u181'); }, true);
}

widgetIdToDragFunction['u181'] = function() {
var e = windowEvent;

if (true) {

	MoveWidgetBy('u184',widgetDragInfo.xDelta,widgetDragInfo.yDelta,'none',500);

	MoveWidgetBy('u181',widgetDragInfo.xDelta,widgetDragInfo.yDelta,'none',500);

}

}

if (bIE) document.getElementById('u130').attachEvent("onmousedown", function(e) { StartDragWidget(e, 'u130'); });
else {
    document.getElementById('u130').addEventListener("mousedown", function(e) { StartDragWidget(e, 'u130'); }, true);
    document.getElementById('u130').addEventListener("touchstart", function(e) { StartDragWidget(e, 'u130'); }, true);
}

widgetIdToDragFunction['u130'] = function() {
var e = windowEvent;

if (true) {

	MoveWidgetBy('u133',widgetDragInfo.xDelta,widgetDragInfo.yDelta,'none',500);

	MoveWidgetBy('u130',widgetDragInfo.xDelta,widgetDragInfo.yDelta,'none',500);

}

}

u115.style.cursor = 'pointer';
$axure.eventManager.click('u115', function(e) {

if (true) {

	SetPanelVisibility('u133','','none',500);

	SetPanelVisibility('u130','','none',500);

}
});
gv_vAlignTable['u122'] = 'top';gv_vAlignTable['u21'] = 'top';gv_vAlignTable['u2'] = 'top';gv_vAlignTable['u79'] = 'top';gv_vAlignTable['u17'] = 'top';gv_vAlignTable['u135'] = 'center';gv_vAlignTable['u151'] = 'center';gv_vAlignTable['u212'] = 'top';
u229.style.cursor = 'pointer';
$axure.eventManager.click('u229', function(e) {

if (true) {

	SetPanelVisibility('u184','hidden','none',500);

	SetPanelVisibility('u181','hidden','none',500);

}
});
gv_vAlignTable['u55'] = 'top';gv_vAlignTable['u101'] = 'top';gv_vAlignTable['u186'] = 'center';gv_vAlignTable['u5'] = 'top';gv_vAlignTable['u105'] = 'top';gv_vAlignTable['u27'] = 'top';gv_vAlignTable['u138'] = 'top';gv_vAlignTable['u172'] = 'top';gv_vAlignTable['u67'] = 'top';gv_vAlignTable['u120'] = 'top';gv_vAlignTable['u152'] = 'top';gv_vAlignTable['u37'] = 'top';gv_vAlignTable['u141'] = 'top';gv_vAlignTable['u11'] = 'center';gv_vAlignTable['u93'] = 'top';gv_vAlignTable['u75'] = 'top';gv_vAlignTable['u200'] = 'center';gv_vAlignTable['u7'] = 'top';gv_vAlignTable['u89'] = 'top';gv_vAlignTable['u47'] = 'top';
u228.style.cursor = 'pointer';
$axure.eventManager.click('u228', function(e) {

if (true) {

	SetPanelVisibility('u184','hidden','none',500);

	SetPanelVisibility('u181','hidden','none',500);

}
});
gv_vAlignTable['u103'] = 'top';gv_vAlignTable['u164'] = 'top';gv_vAlignTable['u99'] = 'top';gv_vAlignTable['u57'] = 'top';gv_vAlignTable['u203'] = 'top';gv_vAlignTable['u125'] = 'top';
u6.style.cursor = 'pointer';
$axure.eventManager.click('u6', function(e) {

if (true) {

;

;

;

;

;

}
});
gv_vAlignTable['u41'] = 'top';gv_vAlignTable['u149'] = 'center';gv_vAlignTable['u118'] = 'top';gv_vAlignTable['u189'] = 'top';
u176.style.cursor = 'pointer';
$axure.eventManager.click('u176', function(e) {

if (true) {

	SetPanelVisibility('u133','hidden','none',500);

	SetPanelVisibility('u130','hidden','none',500);

}
});
gv_vAlignTable['u174'] = 'top';gv_vAlignTable['u85'] = 'top';gv_vAlignTable['u51'] = 'top';document.getElementById('u182_img').tabIndex = 0;

u182.style.cursor = 'pointer';
$axure.eventManager.click('u182', function(e) {

if (true) {

	SetPanelVisibility('u184','hidden','none',500);

	SetPanelVisibility('u181','hidden','none',500);

}
});
gv_vAlignTable['u23'] = 'top';gv_vAlignTable['u202'] = 'center';gv_vAlignTable['u166'] = 'top';gv_vAlignTable['u95'] = 'top';gv_vAlignTable['u61'] = 'top';gv_vAlignTable['u158'] = 'center';gv_vAlignTable['u223'] = 'top';
u114.style.cursor = 'pointer';
$axure.eventManager.click('u114', function(e) {

if (false) {

SetWidgetRichText('u43', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">H</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">2H</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;"> WS</span></p>');

SetWidgetRichText('u45', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Host to Host </span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">web services</span></p>');

SetWidgetRichText('u47', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">2</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">9/01/2013</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">&nbsp;</span></p>');

SetWidgetRichText('u49', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">10</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">:20:06</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;"> am</span></p>');

;

;

SetWidgetRichText('u55', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Propuesto</span></p>');

SetWidgetRichText('u57', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">B</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">NC</span></p>');

SetWidgetRichText('u59', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Bancomer Net Cash</span></p>');

SetWidgetRichText('u61', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">09/01/2013</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">&nbsp;</span></p>');

SetWidgetRichText('u63', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">04</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">:</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">40</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">:</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">34</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;"> pm</span></p>');

;

;

SetWidgetRichText('u69', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#FFFFFF;">Propuesto</span></p>');

}
else
if ((false) && ((false) && ((false) && ((false) && (false))))) {

SetWidgetRichText('u29', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">H</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">2H TRAD</span></p>');

SetWidgetRichText('u31', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">Host to Host tradicional</span></p>');

SetWidgetRichText('u33', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">09/01/2013 </span></p>');

SetWidgetRichText('u35', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">0</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">3:20:06</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;"> pm</span></p>');

;

;

SetWidgetRichText('u41', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">Funcional</span></p>');

SetWidgetRichText('u43', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">H</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">2H</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;"> WS</span></p>');

SetWidgetRichText('u45', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">Host to Host </span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">web services</span></p>');

SetWidgetRichText('u47', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">2</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">9/01/2013 </span></p>');

SetWidgetRichText('u49', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">10</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">:20:06</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;"> am</span></p>');

;

;

SetWidgetRichText('u55', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">Propuesto</span></p>');

SetWidgetRichText('u57', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">B</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">NC</span></p>');

SetWidgetRichText('u59', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">Bancomer Net Cash</span></p>');

SetWidgetRichText('u61', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">09/01/2013 </span></p>');

SetWidgetRichText('u63', '<p style="text-align:center;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">04</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">:</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">40</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">:</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">34</span><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;"> pm</span></p>');

;

;

SetWidgetRichText('u69', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#000000;">Propuesto</span></p>');

}
else
if (true) {

SetWidgetRichText('u29', '<p style="text-align:left;"><span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">Valor</span></p>');

}
});
gv_vAlignTable['u33'] = 'top';gv_vAlignTable['u71'] = 'top';gv_vAlignTable['u198'] = 'center';gv_vAlignTable['u214'] = 'top';gv_vAlignTable['u127'] = 'top';gv_vAlignTable['u225'] = 'top';gv_vAlignTable['u43'] = 'top';gv_vAlignTable['u169'] = 'top';gv_vAlignTable['u187'] = 'top';gv_vAlignTable['u154'] = 'top';
u227.style.cursor = 'pointer';
$axure.eventManager.click('u227', function(e) {

if (true) {

	SetPanelVisibility('u184','hidden','none',500);

	SetPanelVisibility('u181','hidden','none',500);

}
});
gv_vAlignTable['u139'] = 'top';gv_vAlignTable['u87'] = 'top';gv_vAlignTable['u53'] = 'top';gv_vAlignTable['u192'] = 'top';gv_vAlignTable['u121'] = 'top';gv_vAlignTable['u19'] = 'top';gv_vAlignTable['u65'] = 'top';gv_vAlignTable['u109'] = 'top';gv_vAlignTable['u97'] = 'top';gv_vAlignTable['u63'] = 'top';gv_vAlignTable['u81'] = 'top';
u177.style.cursor = 'pointer';
$axure.eventManager.click('u177', function(e) {

if (true) {

	SetPanelVisibility('u133','hidden','none',500);

	SetPanelVisibility('u130','hidden','none',500);

}
});
gv_vAlignTable['u209'] = 'center';gv_vAlignTable['u190'] = 'top';gv_vAlignTable['u9'] = 'center';gv_vAlignTable['u73'] = 'top';gv_vAlignTable['u69'] = 'top';gv_vAlignTable['u147'] = 'center';gv_vAlignTable['u163'] = 'top';gv_vAlignTable['u91'] = 'top';document.getElementById('u131_img').tabIndex = 0;

u131.style.cursor = 'pointer';
$axure.eventManager.click('u131', function(e) {

if (true) {

	SetPanelVisibility('u133','hidden','none',500);

	SetPanelVisibility('u130','hidden','none',500);

}
});
gv_vAlignTable['u113'] = 'center';gv_vAlignTable['u29'] = 'top';gv_vAlignTable['u111'] = 'top';gv_vAlignTable['u132'] = 'center';gv_vAlignTable['u217'] = 'top';
u129.style.cursor = 'pointer';
$axure.eventManager.click('u129', function(e) {

if (true) {

	SetPanelVisibility('u181','','none',500);

	SetPanelVisibility('u184','','none',500);

}
});
gv_vAlignTable['u183'] = 'center';gv_vAlignTable['u173'] = 'top';gv_vAlignTable['u39'] = 'top';gv_vAlignTable['u31'] = 'top';gv_vAlignTable['u83'] = 'top';
u178.style.cursor = 'pointer';
$axure.eventManager.click('u178', function(e) {

if (true) {

	SetPanelVisibility('u133','hidden','none',500);

	SetPanelVisibility('u130','hidden','none',500);

}
});
gv_vAlignTable['u196'] = 'center';gv_vAlignTable['u15'] = 'top';gv_vAlignTable['u49'] = 'top';gv_vAlignTable['u124'] = 'top';gv_vAlignTable['u205'] = 'top';gv_vAlignTable['u145'] = 'center';gv_vAlignTable['u25'] = 'top';gv_vAlignTable['u59'] = 'top';gv_vAlignTable['u215'] = 'top';gv_vAlignTable['u161'] = 'top';gv_vAlignTable['u224'] = 'top';gv_vAlignTable['u45'] = 'top';gv_vAlignTable['u77'] = 'top';gv_vAlignTable['u143'] = 'center';gv_vAlignTable['u220'] = 'top';gv_vAlignTable['u107'] = 'top';gv_vAlignTable['u35'] = 'top';gv_vAlignTable['u136'] = 'top';gv_vAlignTable['u194'] = 'center';