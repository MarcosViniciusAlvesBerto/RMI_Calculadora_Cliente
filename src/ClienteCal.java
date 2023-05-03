
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class ClienteCal {

    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry registro = LocateRegistry.getRegistry("localhost");

        Object obj = registro.lookup("Calculadora");
        Calculadora calculadora = (Calculadora) obj;
        int opcao = -1;
        while (opcao != 9) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu: \n 1 - Adção \n 2 - Subtração \n 3 - Produto \n 4 - Divisão \n - 9 Sair"));;
            int ValorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor "));
            int ValorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor "));
            if (opcao == 1) {
                int Resultado = calculadora.adicao(ValorA, ValorB);
                System.out.println("Resultado da adição: " + Resultado);
            } else {
                if (opcao == 2) {
                    int Resultado = calculadora.subtracao(ValorA, ValorB);
                    System.out.println("Resultado da Subtração: " + Resultado);
                } else {
                    if (opcao == 3) {
                        int Resultado = calculadora.produto(ValorA, ValorB);
                        System.out.println("O resultado do produto e:" + Resultado);
                    } else {
                        if (opcao == 4) {
                            double Resultado = calculadora.divisao(ValorA, ValorB);
                            System.out.println("O resultado da divisao e:" + Resultado);
                        }
                    }
                }
            }
        }
    }
}
