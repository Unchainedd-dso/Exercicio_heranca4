public class ContaRemunerada extends ContaBancaria{
    private double percentualRemuneracao;

    public ContaRemunerada(int numeroConta, String nomeCorrentista){
        super(numeroConta, nomeCorrentista);

        percentualRemuneracao = 0;
    }
    
    public double getPercentRemuneracao(){
        return percentualRemuneracao;
    }

    public void definePercentRemuneracao(double valor){
        if(valor > 0){
            percentualRemuneracao = valor;
        }
        else{
            System.out.println("Percentual inválido, tente novamente");
        }
    }

    public boolean deposito(double valor){
        boolean transacaoValida = super.deposito(valor);
        if(transacaoValida){
            saldo += valor*(percentualRemuneracao/100);
        }
        return transacaoValida;
    }

}
