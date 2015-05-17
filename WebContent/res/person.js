function loadPersonList() {
		$.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/BezirksMusigFest/api/person",
					success : function(response) {
						  var code = "<thead><tr><th></th><th>Vorname</th><th>Nachname</th><th>email</th><th>Handy</th><th>Telefon</th><th>Ort</th><th>Adresse</th><th>Jahrgang</th><th>T-Shirt</th><th>Schicht</th><th>Bereich</th><th>Aufgabe</th></tr></thead><tbody>";
						if (response.person.length !== undefined) {

							for (var i = 0; i < response.person.length; i++) {
								code = code
										+ '<tr><th scope="row">'
										+ (i + 1)
										+ '</th><td>'
										+ response.person[i].fname
										+ '</td><td> '
										+ response.person[i].lname
										+ '</td><td> '
										+ response.person[i].email
										+ '</td><td>'
										+ response.person[i].mobile
										+ '</td><td> '
                		+ response.person[i].telephone
										+ '</td><td> '
                    + response.person[i].city
										+ '</td><td> '
                    + response.person[i].address
										+ '</td><td> '
                    + response.person[i].gebyear
										+ '</td><td> '
										+ response.person[i].tshirt
                    + '</td><td> '
										+ response.person[i].time
                    + '</td><td> '
										+ response.person[i].place
                    + '</td><td> '
										+ response.person[i].task
										+ '</td><td><option value='+response.person[i].id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editPersonButton" name="'+response.person[i].id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deletePersonButton" name="'+response.person[i].id+'">delete</button></td></tr>';
							}
						} else {
							code = code
									+ '<tr><th scope="row">'
									+ 1
									+ '</th><td> '
									+ response.person.fname
									+ '</td><td> '
									+ response.person.lname
									+ '</td><td> '
									+ response.person.email
									+ '</td><td> '
									+ response.person.mobile
                  + '</td><td> '
                  + response.person.telephone
								  + '</td><td> '
                  + response.person.city
                  + '</td><td> '
                  + response.person.address
                  + '</td><td> '
              		+ response.person.gebyear
                  + '</td><td> '
									+ '</td><td> '
									+ response.person[i].tshirt
                  + '</td><td> '
                  + response.person[i].time
                  + '</td><td> '
                  + response.person[i].place
                  + '</td><td> '
                  + response.person[i].task
									+ '</td><td><option value='+response.person.id+'></td><td width="5%"></option><button type="button" class="btn btn-warning editPersonButton" name="'+response.person.id+'">edit</button></td><td width="5%"><button type="button" class="btn btn-danger deletePersonButton" name="'+response.person.id+'">delete</button></td></tr>';
						}

						code = code + "</tbody>";
						$("#Personconfig").html(code);
					},
					error : function(e) {
						console.log(e);
					}
				});
	}
  
  function addPerson()
  {
    var person = {};
    person.fname=$("#fnameInput").val();
    person.lname=$("#lnameInput").val();
    person.email=$("#emailInput").val();
    person.mobile=$("#mobileInput").val();
    person.telephone=$("#telephoneInput").val();
    person.city=$("#cityInput").val();
    person.address=$("#adressInput").val();
    person.gebyear=$("#gebyearInput").val();
    person.tbl_tshirt_id=$("#tshirtSelect").val();
    person.time=$("#timeSelect").val();
    person.place=$("#placeSelect").val();
    person.task=$("#taskSelect").val();
    $.ajax({
    headers:{Accept:'application/json'}, 
    contentType:'application/json',
    type:'POST',
    url: "/api/person",
    data: JSON.stringify(person),
    success: function(response)
    {
        $("#fnameInput").val('');
        $("#lnameInput").val('');
        $("#emailInput").val('');
        $("#mobileInput").val('');
        $("#telephoneInput").val('');
        $("#cityInput").val('');
        $("#addressInput").val('');
        $("#gebyearInput").val('');
        $(".calloutADD").fadeIn("slow");
        $(".calloutADD").delay(3000).fadeOut("fast");
        loadPersonList();
    },
    error : function(e){console.log(e);}
    });
  }
  
  
	function viewPersonList() {
		$(".PersonContainer").fadeIn("slow");
	}
  
  function hidePersonList() {
		$(".PersonContainer").hide();
	}
  
  function hidePersonEditConfig()
  {
    $(".editPersonContainer").fadeOut("slow");
  }

	function updatePerson (id) {
		var person = {};
    person.fname=$("#fnameInput").val();
    person.lname=$("#lnameInput").val();
    person.email=$("#emailInput").val();
    person.mobile=$("#mobileInput").val();
    person.telephone=$("#telephoneInput").val();
    person.city=$("#cityInput").val();
    person.address=$("#adressInput").val();
    person.gebyear=$("#gebyearInput").val();
    person.tbl_tshirt_id=$("#tshirtSelect").val();
    person.time=$("#timeSelect").val();
    person.place=$("#placeSelect").val();
    person.task=$("#taskSelect").val();
    $.ajax({
    headers:{Accept:'application/json'}, 
    contentType:'application/json',
    type:'PUT',
    url: "/api/person/"+id,
    data: JSON.stringify(person),
    success: function(response)
    {
        $("#fnameInput").val('');
        $("#lnameInput").val('');
        $("#emailInput").val('');
        $("#mobileInput").val('');
        $("#telephoneInput").val('');
        $("#cityInput").val('');
        $("#addressInput").val('');
        $("#gebyearInput").val('');
        $(".calloutADD").fadeIn("slow");
        $(".calloutADD").delay(3000).fadeOut("fast");
    },
    error : function(e){console.log(e);}
    });
	}

	function deletePerson(id) {		
		$.ajax({
			headers : {
				Accept : 'application/json'
			},
			contentType : 'application/json',
			type : 'DELETE',
			url : '/api/person/'+ id,
			success : function(response) {
        loadPersonList();
				$(".calloutDELETE").fadeIn("slow");
				$(".calloutDELETE").delay(3000).fadeOut("fast");
				
			},
			error : function(e) {
				console.log(e);
			}
		
		});
		loadPersonList();
	}

 function viewPersonEditContainer() {
    $(".editPersonContainer").fadeIn("slow");
  }