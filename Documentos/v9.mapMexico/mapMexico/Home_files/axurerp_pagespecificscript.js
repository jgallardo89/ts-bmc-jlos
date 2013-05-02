for(var i = 0; i < 17; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

});
gv_vAlignTable['u3'] = 'top';gv_vAlignTable['u16'] = 'center';gv_vAlignTable['u12'] = 'top';
$axure.eventManager.keyup('u4', function(e) {

if ((GetWidgetText('u4')) == ('1')) {

	var obj1 = document.getElementById("u5");
    obj1.focus();

}
});
gv_vAlignTable['u8'] = 'center';gv_vAlignTable['u10'] = 'center';
$axure.eventManager.keyup('u5', function(e) {

if ((GetWidgetText('u5')) == ('1')) {

	var obj1 = document.getElementById("u6");
    obj1.focus();

}
});
gv_vAlignTable['u1'] = 'center';u14.tabIndex = 0;

u14.style.cursor = 'pointer';
$axure.eventManager.click('u14', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('030_CambioContrasenia.html');

}
});
gv_vAlignTable['u14'] = 'top';
u6.style.cursor = 'pointer';
$axure.eventManager.click('u6', function(e) {

if (((GetWidgetText('u4')) == ('1')) && ((GetWidgetText('u5')) == ('1'))) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('MainMenu.html');

}
else
if (true) {

	SetPanelVisibility('u13','','none',500);

	self.location.href=$axure.globalVariableProvider.getLinkUrl('MainMenu.html');

}
});
u2.tabIndex = 0;

u2.style.cursor = 'pointer';
$axure.eventManager.click('u2', function(e) {

if (true) {

	self.location.href=$axure.globalVariableProvider.getLinkUrl('030_CambioContrasenia.html');

}
});
gv_vAlignTable['u2'] = 'top';gv_vAlignTable['u11'] = 'top';