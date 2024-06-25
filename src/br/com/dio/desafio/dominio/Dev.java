package br.com.dio.desafio.dominio;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }


    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }



    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        }
        else {
            System.out.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String verificarProgresso(Bootcamp bootcamp) {
        int totalConteudos = bootcamp.getConteudos().size();
        int conteudosConcluidos = (int) this.conteudosConcluidos.stream()
                .filter(bootcamp.getConteudos()::contains)
                .count();
        int definindoPercentagem = (totalConteudos == 0 ? 0 : (int)(((double)conteudosConcluidos / totalConteudos) * 100));
        String progresso = definindoPercentagem + "%";
        return progresso;
    }

    public List<Conteudo> listarConteudoPendente(Bootcamp bootcamp) {
        List<Conteudo> conteudoASerAdicionado = bootcamp.getConteudos().stream()
                .filter(conteudoBootcamp -> this.getConteudosConcluidos().stream()
                        .noneMatch(conteudoBootcamp::equals))
                .collect(Collectors.toList());
        return conteudoASerAdicionado;
    }

    public String datelhesDoDev(Bootcamp bootcamp) {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalhes do aluno: " + getNome() + "\n");
        sb.append("------------------------ \n");
        sb.append("Conteúdos incritos: \n");
        for(Conteudo conteudo : getConteudosInscritos()) {
            sb.append(conteudo.getTitulo() + "\n");
            sb.append("Descrição: " + conteudo.getDescricao() + "\n");
        }
        sb.append("------------------------ \n");
        sb.append("Conteúdos concluídos: \n");
        for(Conteudo conteudo : getConteudosConcluidos()) {
            sb.append(conteudo.getTitulo() + "\n");

        }
        sb.append("------------------------ \n");
        sb.append("XP: " + calcularTotalXp() + "\n");
        sb.append("Progresso: " + verificarProgresso(bootcamp) + "\n");

        sb.append("Conteúdos restantes para concluir o bootcamp: \n");
        for (Conteudo conteudo : listarConteudoPendente(bootcamp)) {
            sb.append(conteudo.getTitulo() + "\n");
        }
        return sb.toString();
    }
}
