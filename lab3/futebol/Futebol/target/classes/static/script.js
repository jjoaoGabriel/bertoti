const API = "http://localhost:8080/players";

let selectedId = null;

function loadPlayers() {

    fetch(API)

        .then(response => response.json())

        .then(data => {

            const tableBody =
                document.getElementById("table-body");

            tableBody.innerHTML = "";

            data.forEach(player => {

                const row =
                    document.createElement("tr");

                row.innerHTML = `

                    <td>${player.id}</td>

                    <td>${player.name}</td>

                    <td>${player.position}</td>

                    <td>${player.team}</td>

                    <td>${player.age}</td>

                    <td class="actions"></td>

                `;

                const actionsCell =
                    row.querySelector(".actions");

                const editButton =
                    document.createElement("button");

                editButton.textContent = "Editar";

                editButton.addEventListener("click", () => {
                    selectPlayer(player);
                });

                const deleteButton =
                    document.createElement("button");

                deleteButton.textContent = "Excluir";

                deleteButton.addEventListener("click", () => {
                    deletePlayer(player.id);
                });

                actionsCell.appendChild(editButton);

                actionsCell.appendChild(deleteButton);

                tableBody.appendChild(row);
            });
        })

        .catch(error => {
            console.error(
                "Erro ao carregar jogadores:",
                error
            );
        });
}

function addPlayer() {

    const player = getFormData();

    fetch(API, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(player)

    })

    .then(response => {

        if (!response.ok) {
            throw new Error("Erro ao adicionar");
        }

        clearForm();

        loadPlayers();
    })

    .catch(error => {

        console.error(
            "Erro ao adicionar jogador:",
            error
        );
    });
}

function updatePlayer() {

    if (selectedId === null) {

        alert(
            "Selecione um jogador para editar."
        );

        return;
    }

    const player = getFormData();

    fetch(`${API}/${selectedId}`, {

        method: "PUT",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(player)

    })

    .then(response => {

        if (!response.ok) {
            throw new Error("Erro ao atualizar");
        }

        selectedId = null;

        clearForm();

        loadPlayers();
    })

    .catch(error => {

        console.error(
            "Erro ao atualizar jogador:",
            error
        );
    });
}

function deletePlayer(id) {

    fetch(`${API}/${id}`, {

        method: "DELETE"

    })

    .then(response => {

        if (!response.ok) {
            throw new Error("Erro ao deletar");
        }

        loadPlayers();
    })

    .catch(error => {

        console.error(
            "Erro ao deletar jogador:",
            error
        );
    });
}

function selectPlayer(player) {

    selectedId = player.id;

    document.getElementById("name").value =
        player.name;

    document.getElementById("position").value =
        player.position;

    document.getElementById("team").value =
        player.team;

    document.getElementById("age").value =
        player.age;

    console.log(
        "Jogador selecionado:",
        selectedId
    );
}

function getFormData() {

    return {

        name:
            document.getElementById("name").value,

        position:
            document.getElementById("position").value,

        team:
            document.getElementById("team").value,

        age:
            parseInt(
                document.getElementById("age").value
            )
    };
}

function clearForm() {

    document.getElementById("name").value = "";

    document.getElementById("position").value = "";

    document.getElementById("team").value = "";

    document.getElementById("age").value = "";
}

window.onload = loadPlayers;