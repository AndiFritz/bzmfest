<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="img/note.ico">

<title>ProblemSolver</title>

<!-- Bootstrap core CSS -->
<link href="./bootstrap/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="./bootstrap/bootstrap.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="./bootstrap/ie-emulation-modes-warning.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
  <script src="./res/group.js"> </script>  <!--Groupconfig-->
  <script src="./res/person.js"> </script> <!--Personconfig-->
  <script src="./res/termin.js"> </script> <!--Terminconfig-->
  <script src="./res/lists.js"> </script> <!--get InstrumentList,... -->
<!-- <link rel="icon" href="http://getbootstrap.com/favicon.ico"> -->

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(document).on("click", "#listButton", function() {
					getWorkerList();
					
          $(".ListContainer").fadeIn("slow");
					hideMainPage();
				});

				$(document).on("click", "#personButton", function() {
					loadPersonList();
					viewPersonList();
					hideMainPage();
				});
        
        $(document).on("click", "#addPersonButton", function() {
          hidePersonList();
          $("#updatePersonButton").hide();
          getTimeList();
          getPlacesList();
          getTshirtList();
          $(".editPersonContainer").fadeIn("slow");
					hideMainPage(); 
				});
        
        $(document).on("click", "#savePersonButton", function() {
          addPerson();
          loadPersonList();
          hidePersonEditConfig();
          viewPersonList();
				});
        
				$(document).on("click",	".editPersonButton", function() {
			        var selectedMemberID = $(this).attr('name');
              var memberFname = $(this).parent().parent().children().eq(1).text();
              var memberLname = $(this).parent().parent().children().eq(2).text();
              var memberEmail = $(this).parent().parent().children().eq(3).text();
              var memberMobile = $(this).parent().parent().children().eq(4).text();
              var memberTelephone = $(this).parent().parent().children().eq(5).text();
              var memberCity = $(this).parent().parent().children().eq(6).text();
              var memberAddress = $(this).parent().parent().children().eq(7).text();
              var memberGebyear = $(this).parent().parent().children().eq(8).text();
              var memberTshirt = $(this).parent().parent().children().eq(9).text();
              var memberTime = $(this).parent().parent().children().eq(10).text();
              var memberPlace = $(this).parent().parent().children().eq(11).text();
              var memberTask = $(this).parent().parent().children().eq(12).text();
              hidePersonList();
              $("#savePersonButton").hide();
              $("#fnameInput").val(memberFname);
              $("#lnameInput").val(memberLname);
              $("#emailInput").val(memberEmail);
              $("#mobileInput").val(memberMobile);
              $("#telephoneInput").val(memberTelephone);
              $("#cityInput").val(memberCity);
              $("#addressInput").val(memberAddress);
              $("#gebyearInput").val(memberGebyear);
              $("tshirtSelect").select(memberTshirt);
              $("timeSelect").select(memberTime);
              $("placeSelect").select(memberPlace);
              $("taskSelect").select(memberTask);
              getTimeList();
              getPlaceList();
              getTaskList();// bei aenderung des Select Items
              getTshirtList();
              //fillGroupSelect(); // Selection button for selecting group
              $("#updatePersonButton").fadeIn('fast');
              viewPersonEditContainer();
						});        
        
        $(document).on("click", "#updatePersonButton", function() {
					var selectedMemberID = $(".editPersonButton").attr('name');
          updatePerson(selectedMemberID);
				}); 
        
				$(document).on("click", ".deletePersonButton", function() {
					var selectedMemberID = $(this).attr('name');
					deletePerson(selectedMemberID);
				});        
        
				$(document).on("click", "#timesButton", function() {
					loadTerminList();
					viewTerminList();
					hideMainPage();
				});
        
        $(document).on("click", "#addTerminButton", function() {
          hideTerminList();
          $("#updateTerminButton").hide();
          getTypList();
          viewTerminEditContainer();
					hideMainPage(); 
				});
        
        $(document).on("click", "#saveTerminButton", function() {
          addTermin();
          hideTerminEditContainer();
          loadTerminList();
          viewTerminList();
				});
        
        $(document).on("click", ".deleteTerminButton", function() {
					var selectedTerminID = $(this).attr('name');
					deleteTermin(selectedTerminID);
          loadTerminList();
				});        
			});
  
  $( "#placeSelect" ).change(function() {
    alert( "Handler for .change() called." );
    var selectedPlaceID = $("#placeSelct").attr('value');
    getTaskList(id);
  });
  
	function hideMainPage() {
		$(".mainpage").hide();
	}
</script>
<body>

	<!-- Fixed navbar -->
	<div class="row">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ProblemSolver</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="./dashboard.jsp">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li><a href="#logout">Logout</a></li>
					
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		</nav>
	</div>
	<!-- Begin page content -->
  <div class="conatiner" style="margin-top: 50px"> </div>
	<div style="margin-top: 50px" class="container mainpage">
		<div class="page-header">
			<h1>ProblemSolver</h1>
		</div>
		<p class="lead">
			
		</p>
    
<!------------------------------------------------------------------------------ Buttons !! ----------------------------------->
		<div class="row">
			<div class="col-md-4">
				<button type="submit" class="btn btn-default" id="personButton">
					<img data-holder-rendered="true" src="./img/members.svg"
						style="width: 140px; height: 140px;" data-src="holder.js/140x140"
						class="img-rounded" alt="140x140">
					<p class="lead">Personen</p>
				</button>
			</div>
      <div class="col-md-4">
				<button type="submit" class="btn btn-default" id="listButton">
					<img data-holder-rendered="true" src="./img/group.svg"
						style="width: 140px; height: 140px;" data-src="holder.js/140x140"
						class="img-rounded" alt="140x140">
					<p class="lead">Liste</p>
				</button>
			</div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-default" id="timesButton">
					<img data-holder-rendered="true" src="./img/calendar.svg"
						style="width: 140px; height: 140px;" data-src="holder.js/140x140"
						class="img-rounded" alt="140x140">
					<p class="lead">Schichten</p>
				</button>
			</div>
		</div>
	</div>
  
<!------------------------------------------------------------------------------ Callouts !! ----------------------------------->
	<div class="conatiner" style="display: none">
		<div class="bs-callout bs-callout-info calloutADD"
			id="callout-type-b-i-elems" style="display: none">
			<h4 id="alternate-elements">
				Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span
					class="anchorjs-icon"></span></a>
			</h4>
			<p>Add successful!</p>
		</div>
		<div class="bs-callout bs-callout-info calloutUPDATE"
			id="callout-type-b-i-elems" style="display: none">
			<h4 id="alternate-elements">
				Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span
					class="anchorjs-icon"></span></a>
			</h4>
			<p>Update successful!</p>
		</div>
		<div class="bs-callout bs-callout-info calloutDELETE"
			id="callout-type-b-i-elems" style="display: none">
			<h4 id="alternate-elements">
				Hinweis!<a class="anchorjs-link" href="#alternate-elements"><span
					class="anchorjs-icon"></span></a>
			</h4>
			<p>Delete successful!</p>
		</div>
	</div>

  <!------------------------------------------------------------------------------ Container !! ----------------------------------->
	<div class="container editPersonContainer" style="display: none" style="margin-top: 50px">
		<div class="page-header">
			<h1>Userdata</h1>
		</div>
		<table class="table table-hover" id="editPersonconfigData">
      <tr><td><label for="fnameInput">Vorname</label><input type="text" class="form-control" placeholder="Vorname" id="fnameInput" /></td>
          <td><label for="lnameInput">Nachname</label><input type="text" class="form-control" placeholder="Nachname" id="lnameInput" /></td>
      </tr>
      <tr>
          <td><label for="emailInput">Email</label><input type="email" class="form-control" placeholder="Email" id="emailInput" /></td>
          <td><label for="mobileInput">Handy</label><input type="password" class="form-control" placeholder="Password" id="mobileInput" /></td>
          <td><label for="telephoneInput">Telefon</label><input type="password" class="form-control" placeholder="Password" id="telephoneInput" /></td>
          <td><label for="cityInput">Ort</label><input type="password" class="form-control" placeholder="Password" id="cityInput" /></td>
          <td><label for="addressInput">Adresse</label><input type="password" class="form-control" placeholder="Password" id="addressInput" /></td>
          <td><label for="gebyearInput">Jahrgang</label><input type="password" class="form-control" placeholder="Password" id="gebyearInput" /></td>
      </tr>
      <tr> 
        <td><label for="tshirtSelect">T-Shirt</label><select id="tshirtSelect" class="form-control"></select></td>
        <td><label for="timeSelect">Schicht</label><select id="timeSelect" class="form-control"></select></td>
        <td><label for="placeSelect">Bereich</label><select id="placeSelect" class="form-control"></select></td>
        <td><label for="taskSelect">Task</label><select id="taskSelect" class="form-control"></select></td>
      </tr>
    </table>
    <button type="submit" class="btn btn-default" id="savePersonButton" style="font-size: 17px;"><img data-holder-rendered="true" src="./img/personadd.svg" style="width: 24px; height: 24px;" data-src="holder.js/140x140" class="img-rounded" alt="30x30">Save</button>
          <button type="submit" class="btn btn-default" id="updatePersonButton" style="font-size: 17px;"><img data-holder-rendered="true" src="./img/personadd.svg" style="width: 24px; height: 24px;" data-src="holder.js/140x140" class="img-rounded" alt="30x30">Save</button>
	</div>
  
  <div class="container PersonContainer" style="display: none">
		<div class="page-header">
      <h1>Usermanagement</h1> <button type="submit" class="btn btn-primary" id="addPersonButton" style="font-size: 17px;"><img data-holder-rendered="true" src="./img/personadd.svg" style="width: 24px; height: 24px;" data-src="holder.js/140x140" class="img-rounded" alt="50x30">   neuer User</button>
		</div>
		<table class="table table-hover" id="Personconfig"></table> //Table for listing all persons
	</div>
  
  <div class="container editTerminContainer" style="display: none">
		<div class="page-header">
			<h1>Schichten</h1>
		</div>
		<table class="table table-hover" id="editTerminConfigData">
      <tr><td><label for="nameInput">Bezeichnung</label><input type="text" class="form-control" placeholder="Bezeichnung" id="TerminNameInput" /></td>
          <td><label for="dateInput">Datum</label><input type="date" class="form-control" placeholder="12.12.2012" id="dateInput" /></td>
      </tr>
      <tr>
          <td><label for="starttimeInput">Startzeit</label><input type="time" class="form-control" placeholder="12:12" id="starttimeInput" /></td>
          <td><label for="endtimeInput">Endzeit</label><input type="time" class="form-control" placeholder="13:13" id="endtimeInput" /></td>
      </tr>      
    </table>
    <button type="submit" class="btn btn-default" id="saveTerminButton" style="font-size: 17px;"><img data-holder-rendered="true" src="./img/personadd.svg" style="width: 24px; height: 24px;" data-src="holder.js/140x140" class="img-rounded" alt="30x30">Save</button>
          <button type="submit" class="btn btn-default" id="updateTerminButton" style="font-size: 17px;"><img data-holder-rendered="true" src="./img/personadd.svg" style="width: 24px; height: 24px;" data-src="holder.js/140x140" class="img-rounded" alt="30x30">Save</button>
	</div>
  
  <div class="container TerminContainer" style="display: none">
		<div class="page-header">
			<h1>Terminmanagement</h1><button type="submit" class="btn btn-primary" id="addTerminButton" style="font-size: 17px;"><img data-holder-rendered="true" src="./img/personadd.svg" style="width: 24px; height: 24px;" data-src="holder.js/140x140" class="img-rounded" alt="50x30">   neuer Termin</button>
		</div>
		<table class="table table-hover" id="Terminconfig"></table>
	</div>

	<div class="container ListContainer" style="display: none">
		<div class="page-header">
      <h1>Übersicht</h1>
		</div>
		<table class="table table-hover" id="workerList"></table>
	</div>
  

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="res/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>

