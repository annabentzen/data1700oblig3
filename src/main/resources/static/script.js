document.addEventListener('DOMContentLoaded', function () {
    const ticketForm = document.getElementById('ticketForm');
    const ticketList = document.getElementById('ticketList');
    const deleteTickets = document.querySelector('button[type="reset"]'); // Select the reset button

    const tickets = [];

    fetch('/hentFilmer')
        .then(response => response.json())
        .then(filmer => {
            const movieDropdown = document.getElementById('movie');
            filmer.forEach(film => {
                let option = document.createElement('option');
                option.text = film;
                option.value = film;
                movieDropdown.add(option);
            });
        });

    ticketForm.addEventListener('submit', function (e) {
        e.preventDefault();

        const movie = document.getElementById('movie').value;
        const quantity = document.getElementById('quantity').value;
        const firstname = document.getElementById('firstname').value;
        const surname = document.getElementById('surname').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;

        //checks if all input fields are filled in
        if (!quantity || !movie || !firstname || !surname || !email || !phone) {
            alert("Alle felt må fylles ut.");
            return;
        }

        // creates a ticket object
        const ticket = {
            movie: movie,
            quantity: quantity,
            firstname: firstname,
            surname: surname,
            email: email,
            phone: phone
        };

        fetch('/orders', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(ticket)
        }).then(response => {
            if (!response.ok) {
                throw new Error('Nettverksrespons ikke ok');
            }
        }).then(data => {
            // the order is successfully saved on the server
            showTickets();
        }).catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

        ticketForm.reset();
    });

    // Event listener for deleting tickets
    deleteTickets.addEventListener('click', function () {
        fetch('/orders', {
            method: 'DELETE'
        }).then(() => {
            ticketList.innerHTML = ''; //clear the ticket list
            showTickets();
        });
    });

    ticketForm.addEventListener('reset', function () {
        ticketList.innerHTML = ''; //clear ticket list
    });

    function showTickets() {
        fetch('/orders')
            .then(response => response.json())
            .then(tickets => {
                const ticketList = document.getElementById('ticketList');
                ticketList.innerHTML = '';
                tickets.forEach(function (ticket) {
                    const tr = document.createElement('tr');
                    tr.innerHTML = `
                    <td>${ticket.movie}</td>
                    <td>${ticket.quantity}</td>
                    <td>${ticket.firstname}</td>
                    <td>${ticket.surname}</td>
                    <td>${ticket.email}</td>
                    <td>${ticket.phone}</td>
                `;
                    ticketList.appendChild(tr);
                });
            });
    }

    showTickets();
});