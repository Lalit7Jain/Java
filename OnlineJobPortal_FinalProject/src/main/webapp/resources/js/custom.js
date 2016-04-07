$(document)
				.ready(
						function() {
							
							$("#search").submit(function(event) {
									
									// Prevent the form from submitting via the browser.
									event.preventDefault();
									getResultsList();
						});
					
							
							
							alert("Its working on load");
							var xmlHttp;
							xmlHttp = GetXmlHttpObject();

							function getResultsList() {
								alert("Its working inside");
								if (xmlHttp == null) {
									alert("Your browser does not support AJAX!");
									return;
								}

								var key = document.getElementById("text").value;
								var query = "key=" + key.trim();
								xmlHttp.onreadystatechange() == function () {

									if (xmlHttp.readyState == 4) {
										document.getElementById("results").innerHTML = "";
										var json = JSON
												.parse(xmlHttp.responseText);
										if (json.listings.length > 0) {
											var x = document
													.createElement("TABLE");
											x.setAttribute("id", "myTable");
											document.getElementById("results")
													.appendChild(x);

											var y = document
													.createElement("TR");
											y.setAttribute("id", "myTr");
											document.getElementById("myTable")
													.appendChild(y);

											var z = document
													.createElement("TH");
											var t = document
													.createTextNode("Title");

											z.appendChild(t);
											document.getElementById("myTr")
													.appendChild(z);

											var z = document
													.createElement("TH");
											var t = document
													.createTextNode("Description");
											z.appendChild(t);
											document.getElementById("myTr")
													.appendChild(z);

											var z = document
													.createElement("TH");
											var t = document
													.createTextNode("Salary");
											z.appendChild(t);
											document.getElementById("myTr")
													.appendChild(z);

											var z = document
													.createElement("TH");
											var t = document
													.createTextNode("Company Name");
											z.appendChild(t);
											document.getElementById("myTr")
													.appendChild(z);

											var z = document
													.createElement("TH");
											var t = document
													.createTextNode("Apply");
											z.appendChild(t);
											document.getElementById("myTr")
													.appendChild(z);

											for (var count = 0; count < json.listings.length; count++) {
												var y = document
														.createElement("TR");
												y.setAttribute("id", "myTr"
														+ count);
												document.getElementById(
														"myTable").appendChild(
														y);

												var z = document
														.createElement("TD");
												var t = document
														.createTextNode(json.listings[count].title);
												z.appendChild(t);
												document.getElementById(
														"myTr" + count)
														.appendChild(z);

												var z = document
														.createElement("TD");
												var t = document
														.createTextNode(json.listings[count].description);
												z.appendChild(t);
												document.getElementById(
														"myTr" + count)
														.appendChild(z);

												var z = document
														.createElement("TD");
												var t = document
														.createTextNode(json.listings[count].salary);
												z.appendChild(t);
												document.getElementById(
														"myTr" + count)
														.appendChild(z);

												var z = document
														.createElement("TD");
												var t = document
														.createTextNode(json.listings[count].company.name);
												z.appendChild(t);
												document.getElementById(
														"myTr" + count)
														.appendChild(z);

												var z = document
														.createElement("TD");
												var a = document
														.createElement('a');
												var id = json.listings[count].id;
												var rowID = "myTr" + count;
												var linkText = document
														.createTextNode("Apply");
												a.appendChild(linkText);
												a.title = "Apply";
												a.onclick = (function(id, rowID) {
													return function() {
														applyjob(id, rowID);
													}
												})(id, rowID);
												z.appendChild(a);
												document.getElementById(
														"myTr" + count)
														.appendChild(z);
											}
										} else {

											document.getElementById("results").innerHTML = "Nothing Found";
										}
									}

								};
								xmlHttp.open("POST", "searchresult.htm", true);
								xmlHttp.setRequestHeader("Content-type",
										"application/x-www-form-urlencoded");
								xmlHttp.send(query);
								return false;

							}

							function GetXmlHttpObject() {
								var xmlHttp = null;
								try {
									// Firefox, Opera 8.0+, Safari
									xmlHttp = new XMLHttpRequest();
								} catch (e) {
									// Internet Explorer
									try {
										xmlHttp = new ActiveXObject(
												"Msxml2.XMLHTTP");
									} catch (e) {
										xmlHttp = new ActiveXObject(
												"Microsoft.XMLHTTP");
									}
								}
								return xmlHttp;
							}

						});