# Engenharias de Software e Programação

# Atividade 1

## Texto 1 - Definindo Engenharia de Software
What precisely do we mean by software engineering? What distinguishes “software engineering” from “programming” or “computer science”? And why would Google have a unique perspective to add to the corpus of previous software engineering literature written over the past 50 years?
 
The terms “programming” and “software engineering” have been used interchangeably for quite some time in our industry, although each term has a different emphasis and different implications. University students tend to study computer science and get jobs writing code as “programmers.”
 
“Software engineering,” however, sounds more serious, as if it implies the application of some theoretical knowledge to build something real and precise. Mechanical engineers, civil engineers, aeronautical engineers, and those in other engineering disciplines all practice engineering. They all work in the real world and use the application of their theoretical knowledge to create something real. Software engineers also create “something real,” though it is less tangible than the things other engineers create.
 
Unlike those more established engineering professions, current software engineering theory or practice is not nearly as rigorous. Aeronautical engineers must follow rigid guidelines and practices, because errors in their calculations can cause real damage; programming, on the whole, has traditionally not followed such rigorous practices. But, as software becomes more integrated into our lives, we must adopt and rely on more rigorous engineering methods. We hope this book helps others see a path toward more reliable software practices.

1. -> A engenharia de software envolve mais do que apenas escrever código. Ela inclui a criação de sistemas complexos e confiáveis, utilizando princípios de engenharia. Embora o termo "programação" tenha sido usado de forma intercambiável com "engenharia de software" ao longo do tempo, há uma diferença importante. A programação se concentra na criação de código, enquanto a engenharia de software abrange todo o processo de desenvolvimento de um sistema, desde o planejamento até a manutenção.

### Resumo:
- **Programação**: Foco em escrever código.
- **Engenharia de Software**: Criação de sistemas robustos e sustentáveis com base em princípios de engenharia.
- **Ciência da Computação**: Fundamentos teóricos que sustentam a programação e a engenharia de software.

---
# Atividade 2

## Texto 2 - Programação ao Longo do Tempo
Programming Over Time
We propose that “software engineering” encompasses not just the act of writing code, but all of the tools and processes an organization uses to build and maintain that code over time. What practices can a software organization introduce that will best keep its code valuable over the long term? How can engineers make a codebase more sustainable and the software engineering discipline itself more rigorous? We don’t have fundamental answers to these questions, but we hope that Google’s collective experience over the past two decades illuminates possible paths toward finding those answers.
 
One key insight we share in this book is that software engineering can be thought of as “programming integrated over time.” What practices can we introduce to our code to make it sustainable—able to react to necessary change—over its life cycle, from conception to introduction to maintenance to deprecation?
 
The book emphasizes three fundamental principles that we feel software organizations should keep in mind when designing, architecting, and writing their code:
 
Time and Change
How code will need to adapt over the length of its life
 
Scale and Growth
How an organization will need to adapt as it evolves
 
Trade-offs and Costs
How an organization makes decisions, based on the lessons of Time and Change and Scale and Growth.

2. -> A engenharia de software vai além da simples escrita de código. Ela envolve todos os processos e ferramentas utilizadas para construir e manter o código ao longo do tempo. A principal questão aqui é como garantir que o código seja valioso a longo prazo, sustentável e capaz de se adaptar às mudanças. Um ponto fundamental abordado no livro é a ideia de que a engenharia de software pode ser vista como "programação integrada ao longo do tempo". O código precisa ser sustentável, reagindo de forma eficaz às mudanças necessárias durante seu ciclo de vida, desde sua concepção até sua descontinuação.

### Três Princípios Fundamentais:
1. **Tempo e Mudança**: O código precisa ser adaptável ao longo do tempo.
2. **Escala e Crescimento**: A organização precisa evoluir à medida que o software cresce.
3. **Compensações e Custos**: A organização deve equilibrar decisões com base nos princípios de tempo, mudança, escala e crescimento.

### Resumo:
O texto destaca que a engenharia de software envolve mais do que escrever código, incluindo a manutenção e adaptação do código ao longo do tempo. O Google compartilha sua experiência para ajudar a tornar o código mais sustentável. Os três princípios principais são: adaptar o código às mudanças, crescer conforme a organização evolui e tomar decisões equilibrando custos e trade-offs.

---
# Atividade 3

## Trade-offs (Compensações)

Durante o desenvolvimento de software, os engenheiros precisam tomar decisões que envolvem trade-offs, isto é, escolher entre opções que trazem diferentes benefícios e desafios. Aqui estão alguns exemplos de trade-offs comuns:

### 1. Linguagem de Programação:
- **Exemplo**: Python é mais fácil de aprender e programar, mas Java oferece melhor desempenho.
  - **Trade-off**: Facilitar a aprendizagem pode comprometer a performance a longo prazo, enquanto optar por uma linguagem de alto desempenho pode ser mais difícil de aprender.

### 2. Segurança:
- **Exemplo**: Aplicar fortes medidas de segurança pode dificultar a experiência do usuário.
  - **Trade-off**: A segurança mais robusta reduz o risco de ataques, mas pode tornar o sistema menos acessível ou intuitivo para os usuários.

### 3. Custo vs Qualidade:
- **Exemplo**: Reduzir custos pode ser vantajoso no curto prazo.
  - **Trade-off**: No longo prazo, isso pode resultar em mais problemas técnicos, que terão um custo maior para corrigir.

---

## Conclusão

A engenharia de software é uma disciplina complexa e em evolução. A chave para garantir que o software seja sustentável e adaptável ao longo do tempo é a integração de práticas rigorosas e o equilíbrio entre as compensações que surgem no desenvolvimento de sistemas. O Google, com sua experiência em ambientes de grande escala, oferece uma valiosa perspectiva sobre como navegar essas questões. O importante é ter um sistema de ponto a ponto simples (sistema completo) de começo e não partes de um sistema e "juntar". 

---
# Atividade 4

# Comentario slide 57

![Image](https://github.com/user-attachments/assets/5a42a662-afbd-4a4a-9f2e-a0291d44cf2d)

### O essencial é entregar um produto validado e que agregue valor, permitindo aprimoramentos contínuos ao longo do desenvolvimento do projeto e das suas respectivas entregas.

---
# Atividade 5

## Projeto em Java  -  Package at_bertoti

package at_bertoti;

public class Produto {
    private String nome;
    private int codigo;

    public Produto(String nome, int codigo) {
	this.nome = nome;
	this.codigo = codigo;
    }

    public String getNome() {
	return nome;
    }
    public void setNome(String nome) {
	this.nome = nome;
    }
    public int getCodigo() {
	return codigo;
    }
    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }
}

---

package at_bertoti;

import java.util.List;
import java.util.LinkedList;

public class Estoque {
    private List<Produto> produtos = new LinkedList<Produto>();

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto buscarProdutoCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> buscarProdutoNome(String nome) {
        List<Produto> encontrados = new LinkedList<Produto>();
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                encontrados.add(produto);
            }
        }
        return encontrados;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}

---

package at_bertoti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Teste {
    
    @Test
    public void teste() {
        Estoque estoque = new Estoque();
        estoque.addProduto(new Produto("Martelo", 1010123));
        estoque.addProduto(new Produto("Parafuso 2mm", 12345678));

        assertEquals(2, estoque.getProdutos().size());

        Produto produto = estoque.buscarProdutoCodigo(12345678);
        assertEquals("Parafuso 2mm", produto.getNome());
    }
}

---

package at_bertoti;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto p1 = new Produto("Martelo", 1010123);
        Produto p2 = new Produto("Parafuso 2mm", 12345678);

        estoque.addProduto(p1);
        estoque.addProduto(p2);

        System.out.println("Produtos no estoque:");
        for (Produto p : estoque.getProdutos()) {
            System.out.println("Nome: " + p.getNome() + " | Código: " + p.getCodigo());
        }

        int codigoBuscado = 12345678;
        Produto encontrado = estoque.buscarProdutoCodigo(codigoBuscado);
        if (encontrado != null) {
            System.out.println("\nProduto encontrado com código " + codigoBuscado + ": " + encontrado.getNome());
        } else {
            System.out.println("\nProduto com código " + codigoBuscado + " não encontrado.");
        }
    }
}

