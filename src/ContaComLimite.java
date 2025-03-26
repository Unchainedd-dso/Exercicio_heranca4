public class ContaComLimite extends ContaBancaria{
    private double taxaJuros;
    private double limiteOferecido;
    private double limiteConsumido;
    private double juros;

    public ContaComLimite(int numeroConta, String nomeCorrentista){
        super(numeroConta, nomeCorrentista);

        // Valores padrão para o limite e taxa de juros na crianção de uma Conta com Limite
        limiteOferecido = 1000;
        // No começo, nada do limite foi oferecido
        limiteConsumido = 0;
        taxaJuros = 10;
        juros = 0;
    }

    public double getJuros(){
        return juros;
    }

    public double getLimite(){
        return limiteOferecido;
    }

    public double getLimiteConsumido(){
        return limiteConsumido;
    }

    public boolean retirada(double valor){
        // Exemplo: saldo = 0, limiteOferecido = 2000, limiteConsumido = 1400 -> valorDisponivel = 600
        double valorDisponivel = saldo + limiteOferecido - limiteConsumido;
        if(valor <= valorDisponivel){
            if(valor <= saldo){
                saldo -= valor;
            }
            else{
                // Digamos que o saldo seja de 300, e o valor seja 600. O limite conumido sera 600 - 300, e o saldo sera completamente consumido
                // Nao é necessario contemplar aqui o caso em que o limiteConsumido ultrapasse o limiteOferecido porque, para a transação ser feita,
                // o valor retirado tem que estar dentro do limite de retirada.
                limiteConsumido += valor - saldo;
                saldo = 0;

                // Toda vez que um valor é retirado, que faça com que o limite seja consumido, 
                // O valor dos juros é aumentado com base no valor total do limite consumido
                // A IMPLEMENTAÇÂO ERA PRA SER ASSIM?
                juros += limiteConsumido*(taxaJuros/100.0); 
            }
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deposito(double valor){
        if(valor > 0 && limiteConsumido == 0){
            saldo += valor;
            return true;
        }
        else if(limiteConsumido > 0){
            if(valor <= limiteConsumido){
                limiteConsumido -= valor;
            }
            else{
                saldo += valor - limiteConsumido;
                limiteConsumido = 0;
            }
            return true;
        }
        else{
            return false;
        }
    }

    public void defineLimite(double valor){
        if(valor >= 0 && valor >= limiteConsumido){
            limiteOferecido = valor;
        }
        else if(valor < 0){
            System.out.println("Limite não pode ser menor que zero");
        }
        else{
            System.out.println("O novo limite não pode ser menor que o quanto de limite ja foi consumido");
        }
    }

    public boolean quitaJuros(){
        if(saldo >= juros){
            saldo -= juros;
            juros = 0;
            return true;
        }
        else{
            return false;
        }
    }
}
