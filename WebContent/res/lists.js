    function getTshirtList()
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/BezirksMusigFest/api/tshirts",
					success : function(response) {
						var code = "";
						if (response.tshirt.length !== undefined) {
							for (var i = 0; i < response.tshirt.length; i++) {
                code = code + '<option value="'+response.tshirt[i].id+'">'+response.tshirt[i].name+'</option>';
              }
            }else {
							code = code + '<option value="'+response.tshirt.id+'">'+response.tshirt.name+'</option>';
            }
            $("#tshirtSelect").html(code);
          } 
      });
    }
  
function getWorkerList()
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/BezirksMusigFest/api/workers",
					success : function(response) {
            var code = "<thead><tr><th></th><th>Vorname</th><th>Nachname</th><th>email</th><th>Handy</th><th>Telefon</th><th>T-Shirt</th><th>Datum</th><th>Start</th><th>Ende</th><th>Bereich</th><th>Aufgabe</th></tr></thead><tbody>";
						if (response.worker.length !== undefined) {

							for (var i = 0; i < response.worker.length; i++) {
								code = code
										+ '<tr><th scope="row">'
										+ (i + 1)
										+ '</th><td>'
										+ response.worker[i].fname
										+ '</td><td> '
										+ response.worker[i].lname
										+ '</td><td> '
										+ response.worker[i].email
										+ '</td><td>'
										+ response.worker[i].mobile
										+ '</td><td> '
                		+ response.worker[i].telephone
										+ '</td><td> '
                    + response.worker[i].tshirt
										+ '</td><td> '
                    + response.worker[i].date
										+ '</td><td> '
                    + response.worker[i].start
										+ '</td><td> '
										+ response.worker[i].end
                    + '</td><td> '
										+ response.worker[i].place
                    + '</td><td> '
										+ response.worker[i].task
										+ '</td><</tr>';
							}
						} else {
							code = code
									+ '<tr><th scope="row">'
									+ 1
									+ '</th><td> '
									+ response.worker.fname
									+ '</td><td> '
									+ response.worker.lname
									+ '</td><td> '
                  + response.worker[i].email
                  + '</td><td>'
                  + response.worker[i].mobile
                  + '</td><td> '
                  + response.worker[i].telephone
                  + '</td><td> '
                  + response.worker[i].tshirt
                  + '</td><td> '
                  + response.worker[i].date
                  + '</td><td> '
                  + response.worker[i].start
                  + '</td><td> '
                  + response.worker[i].end
                  + '</td><td> '
                  + response.worker[i].place
                  + '</td><td> '
                  + response.worker[i].task
									+ '</td></tr>';
						}
						code = code + "</tbody>";
						$('#workerList').html(code);
						
					},
					error : function(e) {
						console.log(e);
					}
				});
    }
   
  function getPlacesList() //Rechte bekommen
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/BezirksMusigFest/api/places",
					success : function(response) {
						var code = "";
						if (response.place.length !== undefined) {
							for (var i = 0; i < response.place.length; i++) {
                code = code + '<option value="'+response.place[i].id+'">'+response.place[i].name+'</option>';
              }
            }else {
							code = code + '<option value="'+response.place.id+'">'+response.place.name+'</option>';
            }
            $("#placeSelect").html(code);
          } 
      });
    }

  function getTaskList(id) //Rechte bekommen
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/BezirksMusigFest/api/place/id/tasks",
					success : function(response) {
						var code = "";
						if (response.task.length !== undefined) {
							for (var i = 0; i < response.task.length; i++) {
                code = code + '<option value="'+response.task[i].id+'">'+response.task[i].name+'</option>';
              }
            }else {
							code = code + '<option value="'+response.task.id+'">'+response.task.name+'</option>';
            }
            $("#taskSelect").html(code);
          } 
      });
    }

  function getTimeList() //Rechte bekommen
    {
      $.ajax({
					headers : {
						Accept : 'application/json'
					},
					type : 'GET',
					url : "/BezirksMusigFest/api/termin",
					success : function(response) {
						var code = "";
						if (response.termin.length !== undefined) {
							for (var i = 0; i < response.termin.length; i++) {
                code = code + '<option value="'+response.termin[i].id+'">'+response.termin[i].name+'</option>';
              }
            }else {
							code = code + '<option value="'+response.termin.id+'">'+response.termin.name+'</option>';
            }
            $("#timeSelect").html(code);
          } 
      });
    }
             
