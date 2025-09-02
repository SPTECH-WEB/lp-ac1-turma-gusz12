package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;
    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
        qtdAluno = 0;
        this.ativa = true;
    }
    public void matricular(Integer qtd){
        if(qtd != null && qtd > 0 && ativa){
            qtdAluno += qtd;
        }
    }
    public Integer cancelar(Integer qtd){
        if(qtd != null && qtd > 0 && ativa && qtd <= qtdAluno){
            qtdAluno -= qtd;
            return qtd;
        }else {
            return null;
        }
    }
    public Integer desativar(){
        if(ativa){
            Integer total_alunos = qtdAluno;
            qtdAluno = 0;
            ativa = false;
            return total_alunos;
        }else {
            return null;
        }
    }
    public void transferir(Turma destino, Integer qtdATransferir){
        if(
                destino != null &&
                qtdATransferir != null &&
                qtdATransferir > 0 &&
                destino.ativa &&
                this.ativa &&
                qtdATransferir <= this.qtdAluno
        ){
            destino.qtdAluno += qtdATransferir;
            this.qtdAluno -= qtdATransferir;
        }
    }
    public Boolean reajustarMensalidade(Double reajuste){
        if(reajuste != null && reajuste > 0){
            mensalidade += (mensalidade * reajuste);
            return true;
        }else {
            return false;
        }
    }
    public String getNome(){
        return this.nome;
    }
    public Double getMensalidade(){
        return this.mensalidade;
    }
    public Integer getQtdAluno(){
        return this.qtdAluno;
    }
    public Boolean getAtiva(){
        return this.ativa;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
