# bertoti

## 1. Comentar com suas palavras o primeiro trecho do livro Software Engineering at Google, Oreilly.

O primeiro trecho fala sobre as diferenças entre "engenharia de software", "programação" e "ciência da computação". Enquanto programação é basicamente escrever código, engenharia de software envolve o uso de conhecimento teórico para criar sistemas que funcionemem um bom estado. O autor compara isso com outras áreas da engenharia, destacando que a engenharia de software ainda não tem a mesma rigidez. Com a crescente importância do software, o autor sugere que é hora de adotar práticas mais rigorosas. 

## 2. Comentar com suas palavras o segundo trecho do livro Software Engineering at Google, Oreilly.

O segundo trecho aborda questões que são frequentemente difíceis na área de engenharia de software, como a manutenção de código a longo prazo e a adaptação a mudanças constantes. Além disso, fala sobre os três princípios (Tempo e Mudança, Escala e Crescimento, e Compromissos e Custos). Cada um desses princípios toca em um desafio real que todos nós enfrentamos em projetos de software, seja no momento da criação ou na manutenção. 

## 3. Listar e explicar 3 exemplos de tradeoffs.

### Custo x Qualidade:
Quando você compra um produto, frequentemente há um trade-off entre custo e qualidade. Um produto mais barato pode não ter a mesma qualidade de um produto mais caro, mas você economiza dinheiro ao escolher o mais barato.

### Velocidade x Precisão:
Ao treinar uma IA, você pode optar por um modelo mais rápido, mas menos preciso, ou um modelo mais preciso, mas mais demorado para treinar e usar.

### Privacidade x Conveniência:
Ao usar um aplicativo que coleta muitos dados pessoais, você pode obter uma experiência mais conveniente, mas isso vem com o custo de abrir mão da sua privacidade.

## 4. Classes UML.

<p align="center">
      <img src="imagem/uml.png" width="800" height="800">
</p>

## 5. JAVA.

### Cliente.java

<pre>package loja;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}</pre>

### Loja.java

<pre>package loja;

import java.util.LinkedList;
import java.util.List;

public class Loja {

    private List<Cliente> clientes = new LinkedList<Cliente>();

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Cliente> buscarClienteNome(String nome) {
        List<Cliente> encontrados = new LinkedList<Cliente>();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome))
                encontrados.add(cliente);
        }

        return encontrados;
    }
}</pre>

### Teste.java

<pre>package loja;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class Teste {

    @Test
    void test() {
        Loja loja = new Loja();

        loja.addCliente(new Cliente("Carlos", "987654321"));

        assertEquals(loja.getClientes().size(), 1);

        List<Cliente> clientesEncontrados = loja.buscarClienteNome("Carlos");
        assertEquals(clientesEncontrados.get(0).getCpf(), "987654321");
    }
}
</pre>

## 6. Testes automatizados.

### TesteCliente.java

<pre>package loja;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteCliente {

    @Test
    public void testConstrutor() {
        Cliente cliente = new Cliente("João", "123.456.789-00");
        assertEquals("João", cliente.getNome());
        assertEquals("123.456.789-00", cliente.getCpf());
    }

    @Test
    public void testSetNome() {
        Cliente cliente = new Cliente("João", "123.456.789-00");
        cliente.setNome("Maria");
        assertEquals("Maria", cliente.getNome());
    }

    @Test
    public void testSetCpf() {
        Cliente cliente = new Cliente("João", "123.456.789-00");
        cliente.setCpf("987.654.321-00");
        assertEquals("987.654.321-00", cliente.getCpf());
    }
}</pre>

### TesteLoja.java

<pre>package loja;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteLoja {

    @Test
    public void testConstrutor() {
        Cliente cliente = new Cliente("João", "123.456.789-00");
        assertEquals("João", cliente.getNome());
        assertEquals("123.456.789-00", cliente.getCpf());
    }

    @Test
    public void testSetNome() {
        Cliente cliente = new Cliente("João", "123.456.789-00");
        cliente.setNome("Maria");
        assertEquals("Maria", cliente.getNome());
    }

    @Test
    public void testSetCpf() {
        Cliente cliente = new Cliente("João", "123.456.789-00");
        cliente.setCpf("987.654.321-00");
        assertEquals("987.654.321-00", cliente.getCpf());
    }
}</pre>

### Testee.java

<pre>package loja;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class Testee {

    @Test
    void testAdicionarEBuscarCliente() {
        Loja loja = new Loja();

        loja.addCliente(new Cliente("Carlos", "987654321"));

        assertEquals(1, loja.getClientes().size(), "A loja deve conter 1 cliente após adicionar.");

        List<Cliente> clientesEncontrados = loja.buscarClienteNome("Carlos");

        assertEquals(1, clientesEncontrados.size(), "Deve encontrar 1 cliente com o nome Carlos.");
        assertEquals("987654321", clientesEncontrados.get(0).getCpf(), "O CPF do cliente encontrado deve ser 987654321.");
        assertEquals("Carlos", clientesEncontrados.get(0).getNome(), "O nome do cliente encontrado deve ser Carlos.");
    }

    @Test
    void testBuscarClienteInexistente() {
        Loja loja = new Loja();
        loja.addCliente(new Cliente("Maria", "111222333"));

        List<Cliente> clientesEncontrados = loja.buscarClienteNome("José");

        assertTrue(clientesEncontrados.isEmpty(), "Não deve encontrar cliente com o nome José.");
    }
}</pre>

## 7. JAVA SQLite.

### Aluno.java

<pre>package com.example.biblioteca;

public class Aluno {
    private String nome;
    private String ra;

    public Aluno() {}

    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }

    @Override
    public String toString() {
        return "Aluno{nome='" + nome + "', ra='" + ra + "'}";
    }
}
</pre>

### Biblioteca.java

<pre>package com.example.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();

    public void addLivro(Livro l) {
        if (l != null) livros.add(l);
    }

    public List<Livro> listar() {
        return Collections.unmodifiableList(livros);
    }
}</pre>

### DataBase.java

<pre>package com.example.biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private final String url;

    public Database(String url) {
        this.url = url;
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public void criarTabelaSeNecessario() {
        String sql = "CREATE TABLE IF NOT EXISTS livros ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "titulo TEXT NOT NULL,"
                + "autor TEXT"
                + ");";
        try (Connection c = connect(); Statement s = c.createStatement()) {
            s.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela: " + e.getMessage(), e);
        }
    }

    public int inserirLivro(Livro l) {
        String sql = "INSERT INTO livros(titulo, autor) VALUES(?,?)";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir livro: " + e.getMessage(), e);
        }
    }

    public List<Livro> listarLivros() {
        String sql = "SELECT id, titulo, autor FROM livros ORDER BY id";
        List<Livro> out = new ArrayList<>();
        try (Connection c = connect(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                out.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros: " + e.getMessage(), e);
        }
        return out;
    }

    public List<Livro> buscarPorTitulo(String termo) {
        String sql = "SELECT id, titulo, autor FROM livros WHERE titulo LIKE ? ORDER BY id";
        List<Livro> out = new ArrayList<>();
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + termo + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    out.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livros: " + e.getMessage(), e);
        }
        return out;
    }
}
</pre>

### Livro.java


<pre>package com.example.biblioteca;

public class Livro {
    private Integer id;
    private String titulo;
    private String autor;

    public Livro() {}
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    public Livro(Integer id, String titulo, String autor) {
        this.id = id; this.titulo = titulo; this.autor = autor;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "Livro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "'}";
    }
}</pre>

### Main.java

<pre>package com.example.biblioteca;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("== Iniciando demonstração Biblioteca + SQLite ==");

        SalaDeAula sala = new SalaDeAula("Sala 101");
        sala.adicionarAluno(new Aluno("Ted Mosby", "20250001"));
        sala.adicionarAluno(new Aluno("Barney Stinson", "20250002"));
        System.out.println("Alunos na " + sala.getNome() + ": " + sala.listarAlunos());

        Biblioteca bib = new Biblioteca();
        bib.addLivro(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
        bib.addLivro(new Livro("Java: Como Programar", "Deitel"));
        System.out.println("Livros em memória: " + bib.listar());

        try {
            String dbFile = "biblioteca.db";
            Path p = Path.of(dbFile);
            if (!Files.exists(p)) Files.createFile(p);

            String url = "jdbc:sqlite:" + dbFile;
            Database db = new Database(url);
            db.criarTabelaSeNecessario();

            Livro l1 = new Livro("Introdução ao Java", "Autor A");
            int id1 = db.inserirLivro(l1);
            System.out.println("Inserido livro id=" + id1 + ": " + l1.getTitulo());

            Livro l2 = new Livro("Estruturas de Dados", "Autor B");
            int id2 = db.inserirLivro(l2);
            System.out.println("Inserido livro id=" + id2 + ": " + l2.getTitulo());

            List<Livro> todos = db.listarLivros();
            System.out.println("Livros no banco: " + todos);

            List<Livro> busca = db.buscarPorTitulo("Java");
            System.out.println("Busca por 'Java': " + busca);

        } catch (Exception e) {
            System.err.println("Erro na demo SQLite: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("== Fim da demonstração ==");
    }
}
</pre>

### SalaDeAula.java

<pre>package com.example.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalaDeAula {
    private String nome;
    private final List<Aluno> alunos = new ArrayList<>();

    public SalaDeAula() {}
    public SalaDeAula(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public void adicionarAluno(Aluno a) { if (a != null) alunos.add(a); }
    public List<Aluno> listarAlunos() { return Collections.unmodifiableList(alunos); }

    @Override
    public String toString() {
        return "SalaDeAula{nome='" + nome + "', alunos=" + alunos + "}";
    }
}</pre>

### Usuario.java

<pre>package com.example.biblioteca;

public class Usuario {
    private String nome;

    public Usuario() {}
    public Usuario(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() { return "Usuario{nome='" + nome + "'}"; }
}</pre>

## 8. Usar ollama4j.

### Ollama.java

<pre>import java.io.*;
import java.net.*;

public class Ollama {
    public static void main(String[] args) {
        try {
            // Usa 127.0.0.1 pois o log mostra que o Ollama escuta nesse IP
            URL url = new URL("http://127.0.0.1:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // JSON correto segundo a API atual
            String jsonInput = """
                {
                  "model": "codellama:7b",
                  "prompt": "Escreva os cinco nomes mais populares do mundo",
                  "stream": false
                }
                """;

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int status = conn.getResponseCode();
            System.out.println("HTTP Status: " + status);

            // Lê resposta (erro ou sucesso)
            InputStream responseStream = (status >= 200 && status < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(responseStream, "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line.trim());
                }
                System.out.println("Resposta:");
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}</pre>
