i= 0
function uuidv4() {
    return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
      (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
  }

const btnAdd = document.getElementById('submitBtn')
function Adicionar() {
    axios.post('http://localhost:8080/books', {
        id: inputID.value,
        name: nomeLivro.value
    }) .then(response => {
        window.location.reload();
        console.log("Livro adicionado", response.data)
    }).catch(e => {
        }
    )
}
btnAdd.addEventListener('click',Adicionar)
document.addEventListener("DOMContentLoaded", () => {

    fetch("http://localhost:8080/books") 
        .then(response => response.json())
        .then(data => {
            
            const bookList = document.getElementById("book-list");
            data.forEach(book => {
                const listItem = document.createElement("li");
                const deleteButton = document.createElement('button') 
                const upItem = document.createElement("input")
                const upButton = document.createElement("button");
                const inputID = document.getElementById('inputID')
                const nomeLivro = document.getElementById('nomeLivro')
                inputID.setAttribute('value',uuidv4())
                upButton.innerHTML = "Editar nome";
                deleteButton.innerHTML = "Excluir";
                listItem.textContent = book.name;
                bookList.appendChild(listItem);
                bookList.appendChild(upItem);
                bookList.appendChild(upButton);
                bookList.appendChild(deleteButton);
                upButton.setAttribute('id',i);
                
                upButton.setAttribute('class','btn btn-primary')
                deleteButton.setAttribute('class','btn btn-danger')
                i++;
                upButton.addEventListener('click',Update)
                deleteButton.addEventListener('click', Excluir)
                function Update(){
                   upItemValor = upItem.value;
                   axios.put("http://localhost:8080/books/"+book.id , { id: book.id, name: upItemValor })
                   .then(response => {
                    console.log("Livro atualizado com sucesso:", response.data)
                        listItem.innerText = upItemValor
                })
                .catch(error => {
                    console.error("Erro ao atualizar o livro:", error);
                });


                }

                function Excluir(){
                    axios.delete("http://localhost:8080/books/"+book.id, { id: book.id })
                    .then(response =>{
                        console.log('Deletado', response.data)
                        upButton.remove()
                        deleteButton.remove()
                        listItem.remove()
                        upItem.remove()
                    })
                    .catch(error => {
                        console.error("Erro ao deletar", error)
                    })
                }

            });
        });
});

