<?php
if (!isset($_GET['e'])) {
?>

<form action="?">
<label for="e">Boxlight ip:</label><br>
<input type="text" id="e" name="e"><br><br>
<input type="submit">
</form>
<p>to find the boxlight's ip, open unplugd and it should be on the middle column</p>
<?php
	exit();
}


$endpoint = 'http://'.htmlspecialchars($_GET['e']).':8000';
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Remote Control</title>
	<link rel="stylesheet"  type="text/css" href="<?=$endpoint?>/remote/structure.css" />
	<link rel="stylesheet" type="text/css" href="<?=$endpoint?>/remote/mobile.css"/>
    <link rel="stylesheet" type="text/css" href="<?=$endpoint?>/remote/theme.css"/>
    <link rel="shortcut icon" href="<?=$endpoint?>/remote/favicon.ico" mce_href="<?=$endpoint?>/remote/favicon.ico" type="image/x-icon">
	<script src="<?=$endpoint?>/remote/jquery.js" type="text/javascript"></script>
	<script src="<?=$endpoint?>/remote/mobile.js" type="text/javascript"></script>
    <script type="text/javascript">
function openLiveTV(url)
		{
		$.mobile.showPageLoadingMsg();
		$.get("<?=$endpoint?>/remote/media_control", {action:'setUri',uri:url,type:'video/*'}, 
			function (data, textStatus){
			if("success"==textStatus){
				 setTimeout(function(){
					 $.mobile.hidePageLoadingMsg();
					 },3000);
			}else
			{
				$.mobile.hidePageLoadingMsg();
				alert(textStatus);
			}
		});
		}
function play()
{
		//$.mobile.showPageLoadingMsg();
		$.get("<?=$endpoint?>/remote/media_control", {action:'play'}, 
			function (data, textStatus){
			if("success"==textStatus){
				 
			}else
			{
				//$.mobile.hidePageLoadingMsg();
				alert(textStatus);
			}
		});
}

function pause()
{
		//$.mobile.showPageLoadingMsg();
		$.get("<?=$endpoint?>/remote/media_control", {action:'pause'}, 
			function (data, textStatus){
			if("success"==textStatus){
				 
			}else
			{
				//$.mobile.hidePageLoadingMsg();
				//finish
				alert(textStatus);
			}
		});
}

function finish()
{
		//$.mobile.showPageLoadingMsg();
		$.get("<?=$endpoint?>/remote/media_control", {action:'finish'}, 
			function (data, textStatus){
			if("success"==textStatus){
				 
			}else
			{
				//$.mobile.hidePageLoadingMsg();
				//finish
				alert(textStatus);
			}
		});
}

function sendKeycode(key)
{
		$.get("<?=$endpoint?>/remote/keycode_control", {keycode:key}, 
			function (data, textStatus){
			if("success"==textStatus){
			}else
			{
				alert(textStatus);
			}
		});
}

function setVolume(mut,vol)
{
		$.get("<?=$endpoint?>/remote/volume_control", {mute:mut,volume:vol}, 
			function (data, textStatus){
			if("success"==textStatus){
				
			}else
			{
				alert(textStatus);
			}
		});
}

function popkeycode(keycodes)
{
	if (keycodes.length > 0) {
	sendKeycode(keycodes.shift());
	setTimeout(function(){popkeycode(keycodes);},500);
	}
}

    </script>
</head> 
<body> 
	<div data-role="page">

	<div data-role="header">
		<h1>Gerardo Control</h1>
	</div><!-- /header -->

	<div data-role="content" class="ui-grid-b">
    <div class="ui-block-a"><a href="javascript:popkeycode([82,66,66,66,22,66]);" data-role="button" data-theme="c" >HDMI1</a></div>
    <div class="ui-block-b"><a href="javascript:popkeycode([82,66,66,66,22,22,22,22,22,66]);" data-role="button" data-theme="c" >VGA</a></div>
    <div class="ui-block-c"><a href="javascript:popkeycode([82,66,66,66,66]);" data-role="button" data-theme="c" >Android</a></div>
<details><summary>fun stuff</summary>
	<div class="ui-block-a"><a href="javascript:sendKeycode(3);" data-role="button" data-theme="c" >Home</a></div>
	<div class="ui-block-b"><a href="javascript:sendKeycode(4);" data-role="button" data-theme="c" >Return</a></div>	 
	<div class="ui-block-c"><a href="javascript:sendKeycode(82);" data-role="button" data-theme="c" >Menu</a></div>  
    <div class="ui-block-a"><a href="javascript:sendKeycode(24);" data-role="button" data-theme="c" >Vol+</a></div>
	<div class="ui-block-b"><a href="javascript:sendKeycode(25);" data-role="button" data-theme="c" >Vol-</a></div>	 
	<div class="ui-block-c"><a href="javascript:sendKeycode(91);" data-role="button" data-theme="c" >Mute</a></div>  
    <div class="ui-block-a"><a href="javascript:sendKeycode(66);" data-role="button" data-theme="c" >Enter</a></div>
	<div class="ui-block-b"><a href="javascript:sendKeycode(61);" data-role="button" data-theme="c" >TAB</a></div>	 
    <div class="ui-block-c"><a href="javascript:popkeycode([35,33,46,29,46,32,43,62,51,29,47,62,36,33,46,33]);" data-role="button" data-theme="c" >gerardo</a></div>
	<div class="ui-block-a"><a href="javascript:sendKeycode(21);" data-role="button" data-theme="c" >Left</a></div>	 
	<div class="ui-block-b"><a href="javascript:sendKeycode(22);" data-role="button" data-theme="c" >Right</a></div>	 
	<div class="ui-block-c"><a href="javascript:play();" data-role="button" data-theme="c" >Pause</a></div>	 
	<div class="ui-block-a"><a href="javascript:sendKeycode(19);" data-role="button" data-theme="c" >Up</a></div>	 
	<div class="ui-block-b"><a href="javascript:sendKeycode(20);" data-role="button" data-theme="c" >Down</a></div>	 
    <div class="ui-block-c"><a href="javascript:popkeycode([47,29,42,32,31,29,48,47]);" data-role="button" data-theme="c" >SANDCATS</a></div>
	<div class="ui-block-a"><a href="javascript:sendKeycode(97);" data-role="button" data-theme="c" >PgDn</a></div>	 
	<div class="ui-block-b"><a href="javascript:sendKeycode(96);" data-role="button" data-theme="c" >PgUp</a></div>	 
</details>
</div>
</div>
</body>
</html>
