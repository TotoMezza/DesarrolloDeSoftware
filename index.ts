type Rating = {
    rate: number;
    count: number;
};

type Product = {
    id: number;
    title: string;
    price: number;
    description: string;
    category: string;
    image: string;
    rating: Rating;
};

fetch('https://fakestoreapi.com/products')
    .then (res => res.json())
    .then ((products: Product[]) => {
        //Prepare table html:
        let tableHtml: string = '<thead><tr><th>ID</th><th>TITLE</th><th>DESCRIPTION</th><th>PRICE</th></tr></thead><tbody>';
        //Loop through all products to generate table rows od the table
        products.forEach((p: Product) =>{
            tableHtml += `<tr><td>${p.id}</td><td>${p.title}</td><td>${p.description}</td><td>${p.price}</td></tr>`; //con el alt y la tecla de cerrar llave se hace la comilla invertida
        });
        //close table body
        tableHtml += '</tbody>';
        //grab table element to set its inner html
        document.querySelector('#tableElement')!.innerHTML = tableHtml;
        // hide spinner
        const spinnerElement: HTMLElement = document.querySelector('#spinnerContainer')!; //el signo de exclamacion sirve para indicarle a typescript que el los busque si o si al elemento pq ya sabemos que lo va a encontrar
        spinnerElement!.style.display = 'none';

    }); 