fetch('https://fakestoreapi.com/products')
    .then(function (res) { return res.json(); })
    .then(function (products) {
    //Prepare table html:
    var tableHtml = '<thead><tr><th>ID</th><th>TITLE</th><th>DESCRIPTION</th><th>PRICE</th></tr></thead><tbody>';
    //Loop through all products to generate table rows od the table
    products.forEach(function (p) {
        tableHtml += "<tr><td>".concat(p.id, "</td><td>").concat(p.title, "</td><td>").concat(p.description, "</td><td>").concat(p.price, "</td></tr>"); //con el alt y la tecla de cerrar llave se hace la comilla invertida
    });
    //close table body
    tableHtml += '</tbody>';
    //grab table element to set its inner html
    document.querySelector('#tableElement').innerHTML = tableHtml;
    // hide spinner
    var spinnerElement = document.querySelector('#spinnerContainer'); //el signo de exclamacion sirve para indicarle a typescript que el los busque si o si al elemento pq ya sabemos que lo va a encontrar
    spinnerElement.style.display = 'none';
});